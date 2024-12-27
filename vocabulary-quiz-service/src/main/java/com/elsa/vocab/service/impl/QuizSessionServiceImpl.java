package com.elsa.vocab.service.impl;

import com.elsa.vocab.application.model.message.QuizSessionStatusMessage;
import com.elsa.vocab.application.model.request.AnswerQuizSessionQuestionRequest;
import com.elsa.vocab.application.model.request.SearchQuizSessionRequest;
import com.elsa.vocab.application.model.response.AnswerResponse;
import com.elsa.vocab.application.model.response.QuizQuestionResponse;
import com.elsa.vocab.application.model.response.QuizSessionResponse;
import com.elsa.vocab.infrastructure.configuration.exception.ApplicationException;
import com.elsa.vocab.infrastructure.configuration.exception.InvalidParamsException;
import com.elsa.vocab.infrastructure.configuration.exception.ResourceNotFoundException;
import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import com.elsa.vocab.infrastructure.job.QuizSessionJobHelper;
import com.elsa.vocab.infrastructure.model.entity.JpaQuizSessionAnswer;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionAnswerRepository;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionMemberRepository;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionQuestionRepository;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionRepository;
import com.elsa.vocab.infrastructure.util.AuthUtils;
import com.elsa.vocab.service.QuizSessionMemberService;
import com.elsa.vocab.service.QuizSessionService;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizSessionServiceImpl implements QuizSessionService {
    private final JpaQuizSessionRepository quizSessionRepository;
    private final JpaQuizSessionQuestionRepository quizSessionQuestionRepository;
    private final JpaQuizSessionAnswerRepository quizSessionAnswerRepository;
    private final JpaQuizSessionMemberRepository quizSessionMemberRepository;
    private final QuizSessionMemberService quizSessionMemberService;
    private final SimpMessagingTemplate messagingTemplate;
    private final QuizSessionJobHelper jobHelper;

    @Override
    @Transactional(readOnly = true)
    public Page<QuizSessionResponse> search(SearchQuizSessionRequest request, Pageable pageable) {
        var page = quizSessionRepository.findAll(pageable);
        return page.map(item -> QuizSessionResponse.builder()
                .id(item.getId())
                .code(item.getCode())
                .title(item.getTitle())
                .description(item.getDescription())
                .duration(item.getDuration())
                .status(item.getStatus())
                .maxMembers(item.getMaxMembers())
                .statedDate(item.getStatedDate())
                .totalQuestions(item.getTotalQuestions())
                .build());
    }

    @Override
    public QuizSessionResponse getByCode(String code) {
        var item = quizSessionRepository.findByCode(code)
                .orElseThrow(ResourceNotFoundException::new);
        var userId = AuthUtils.currentUserIdOrElseThrow();
        var isJoined = quizSessionMemberService.isJoined(userId, code);
        return QuizSessionResponse.builder()
                .id(item.getId())
                .code(item.getCode())
                .title(item.getTitle())
                .description(item.getDescription())
                .totalQuestions(item.getTotalQuestions())
                .maxMembers(item.getMaxMembers())
                .duration(item.getDuration())
                .status(item.getStatus())
                .statedDate(item.getStatedDate())
                .scheduledDate(item.getScheduledDate())
                .isJoined(isJoined)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuizQuestionResponse> getQuestions(String quizSessionCode) {
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(ResourceNotFoundException::new);
        if (session.getStatus() != QuizSessionStatus.InProgress) {
            throw new ApplicationException("The quiz session status is invalid!");
        }
        var items = quizSessionQuestionRepository.findByQuizSessionCode(quizSessionCode);
        return items.stream().map(item -> QuizQuestionResponse.builder()
                .id(item.getId())
                .type(item.getQuestion().getType())
                .options(item.getQuestion().getOptions())
                .content(item.getQuestion().getContent())
                .build()).toList();
    }

    @Override
    @Transactional
    public AnswerResponse answer(String quizSessionCode, AnswerQuizSessionQuestionRequest request) {
        var userId = AuthUtils.currentUserIdOrElseThrow();
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(ResourceNotFoundException::new);
        if (session.getStatus() != QuizSessionStatus.InProgress) {
            throw new ApplicationException("The quiz session does not accept answers!");
        }
        var sessionAnswer = quizSessionAnswerRepository.findByQuizSessionQuestionIdAndQuizSessionMemberUserId(request.getQuestionId(), userId);
        if (sessionAnswer.isPresent()) {
            throw new DuplicateRequestException("This question is already answered!");
        }
        var sessionMember = quizSessionMemberRepository.findByQuizSessionCodeAndUserId(quizSessionCode, userId)
                .orElseThrow(ResourceNotFoundException::new);
        var sessionQuestion = quizSessionQuestionRepository.findById(request.getQuestionId())
                .orElseThrow(InvalidParamsException::new);
        var correctAnswer = sessionQuestion.getQuestion().getCorrectAnswer();
        var isCorrect = correctAnswer.size() == request.getAnswer().size()
                && new HashSet<>(correctAnswer).containsAll(request.getAnswer());

        var receivedScore = isCorrect ? sessionQuestion.getScore() : 0;
        quizSessionAnswerRepository.save(JpaQuizSessionAnswer.builder()
                        .answer(request.getAnswer())
                        .quizSessionQuestion(sessionQuestion)
                        .receivedScore(receivedScore)
                        .quizSessionMember(sessionMember)
                        .submittedDate(Instant.now())
                .build());
        quizSessionMemberService.addScore(userId, quizSessionCode, receivedScore);
        return AnswerResponse.builder()
                .correct(isCorrect)
                .receivedScore(receivedScore)
                .build();
    }

    @Override
    @Transactional
    public void scheduleToStart(String quizSessionCode) throws SchedulerException {
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(ResourceNotFoundException::new);
        session.setStatus(QuizSessionStatus.ScheduledToStart);
        session.setScheduledDate(Instant.now().plus(5, ChronoUnit.SECONDS));
        quizSessionRepository.save(session);

        jobHelper.triggerToStart(quizSessionCode);

        messagingTemplate.convertAndSend(
                "/topic/quiz-sessions/" + quizSessionCode + "/status",
                QuizSessionStatusMessage.builder()
                        .status(QuizSessionStatus.ScheduledToStart)
                        .countDownTime(5)
                        .build()
        );
    }

    @Override
    @Transactional
    public void start(String quizSessionCode) throws SchedulerException {
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(ResourceNotFoundException::new);
        session.setStatus(QuizSessionStatus.InProgress);
        session.setStatedDate(Instant.now());
        quizSessionRepository.save(session);
        jobHelper.triggerToComplete(quizSessionCode, session.getDuration());

        messagingTemplate.convertAndSend(
                "/topic/quiz-sessions/" + quizSessionCode + "/status",
                QuizSessionStatusMessage.builder()
                        .status(QuizSessionStatus.InProgress)
                        .countDownTime(0)
                        .build()
        );
    }

    @Override
    public void complete(String quizSessionCode) {
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(ResourceNotFoundException::new);
        session.setStatus(QuizSessionStatus.Completed);
        quizSessionRepository.save(session);

        messagingTemplate.convertAndSend(
                "/topic/quiz-sessions/" + quizSessionCode + "/status",
                QuizSessionStatusMessage.builder()
                        .status(QuizSessionStatus.Completed)
                        .countDownTime(0)
                        .build()
        );
    }
}
