package com.elsa.vocab.service.impl;

import com.elsa.vocab.application.model.message.QuizSessionStatusMessage;
import com.elsa.vocab.infrastructure.configuration.exception.InvalidParamsException;
import com.elsa.vocab.infrastructure.configuration.exception.UnauthorizedException;
import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import com.elsa.vocab.infrastructure.model.entity.JpaQuizSessionMember;
import com.elsa.vocab.infrastructure.model.entity.JpaUser;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionMemberRepository;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionRepository;
import com.elsa.vocab.infrastructure.repository.JpaUserRepository;
import com.elsa.vocab.service.QuizSessionLeaderboardService;
import com.elsa.vocab.service.QuizSessionMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class QuizSessionMemberServiceImpl implements QuizSessionMemberService {

    private final JpaUserRepository userRepository;
    private final JpaQuizSessionRepository quizSessionRepository;
    private final JpaQuizSessionMemberRepository quizSessionMemberRepository;
    private final QuizSessionLeaderboardService quizSessionLeaderboardService;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    @Transactional(readOnly = true)
    public boolean isJoined(String userId, String quizSessionCode) {
        return quizSessionMemberRepository.existsByQuizSessionCodeAndUserId(quizSessionCode, userId);
    }

    @Override
    @Transactional
    public void addMember(String userId, String quizSessionCode) {
        var user = userRepository.findById(userId)
                .orElseThrow(UnauthorizedException::new);
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(InvalidParamsException::new);

        updateLMember(quizSessionCode, user);

        var newMember = JpaQuizSessionMember.builder()
                .user(user)
                .quizSession(session)
                .joinedDate(Instant.now())
                .build();
        quizSessionMemberRepository.save(newMember);
    }

    @Override
    @Transactional
    public void addScore(String userId, String quizSessionCode, Integer score) {
        if (score <= 0) {
            return;
        }

        updateLeaderboard(quizSessionCode, userId, score);

        var member = quizSessionMemberRepository.findByQuizSessionCodeAndUserId(quizSessionCode, userId)
                .orElseThrow();
        var currentScore = member.getReceivedScore() == null ? 0 : member.getReceivedScore();
        member.setReceivedScore(currentScore + score);
        quizSessionMemberRepository.save(member);
    }

    @Override
    public Integer getTotalMembers(String quizSessionCode) {
        return quizSessionMemberRepository.countByQuizSessionCode(quizSessionCode);
    }

    private void updateLeaderboard(String quizSessionCode, String userId, Integer score) {
        var zSetOps = redisTemplate.opsForZSet();
        Double currentScore = zSetOps.score("leaderboard:" + quizSessionCode, userId);
        if (currentScore == null) {
            currentScore = 0.0;
        }
        int newScore = currentScore.intValue() + score;
        long currentTime = Long.MAX_VALUE - System.nanoTime();
        double newScoreWithTime = Double.parseDouble(newScore + "." + currentTime);
        zSetOps.add("leaderboard:" + quizSessionCode, userId, newScoreWithTime);
        redisTemplate.expire("leaderboard:" + quizSessionCode, Duration.of(60, ChronoUnit.MINUTES));
        quizSessionLeaderboardService.updateLeaderboard(quizSessionCode);
    }

    private void updateLMember(String quizSessionCode, JpaUser user) {
        var hashOps = redisTemplate.opsForHash();
        hashOps.put("members:" + quizSessionCode, user.getId(), user.getFirstName() + " " + user.getLastName());
    }
}
