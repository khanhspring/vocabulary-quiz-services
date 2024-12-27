package com.elsa.vocab.service;

import com.elsa.vocab.application.model.request.AnswerQuizSessionQuestionRequest;
import com.elsa.vocab.application.model.request.SearchQuizSessionRequest;
import com.elsa.vocab.application.model.response.AnswerResponse;
import com.elsa.vocab.application.model.response.QuizQuestionResponse;
import com.elsa.vocab.application.model.response.QuizSessionResponse;
import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import org.quartz.SchedulerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizSessionService {
    Page<QuizSessionResponse> search(SearchQuizSessionRequest request, Pageable pageable);
    QuizSessionResponse getByCode(String code);
    List<QuizQuestionResponse> getQuestions(String quizSessionCode);
    AnswerResponse answer(String quizSessionCode, AnswerQuizSessionQuestionRequest request);
    void scheduleToStart(String quizSessionCode) throws SchedulerException;
    void start(String quizSessionCode) throws SchedulerException;
    void complete(String quizSessionCode);
}
