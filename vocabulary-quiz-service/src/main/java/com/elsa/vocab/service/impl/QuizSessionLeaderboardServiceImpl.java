package com.elsa.vocab.service.impl;

import com.elsa.vocab.application.model.response.QuizSessionLeaderboardResponse;
import com.elsa.vocab.application.model.response.QuizSessionMemberResponse;
import com.elsa.vocab.infrastructure.configuration.exception.ResourceNotFoundException;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionMemberRepository;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionRepository;
import com.elsa.vocab.service.QuizSessionLeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuizSessionLeaderboardServiceImpl implements QuizSessionLeaderboardService {

    private final JpaQuizSessionRepository quizSessionRepository;
    private final JpaQuizSessionMemberRepository quizSessionMemberRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    @Transactional(readOnly = true)
    public QuizSessionLeaderboardResponse getLeaderboard(String quizSessionCode) {
        var session = quizSessionRepository.findByCode(quizSessionCode)
                .orElseThrow(ResourceNotFoundException::new);
        var sort = Sort.by(Order.desc("receivedScore"), Order.asc("completedDate"));
        var members = quizSessionMemberRepository.findAllByQuizSessionCode(quizSessionCode, sort)
                .stream().map(member -> QuizSessionMemberResponse.builder()
                        .userId(member.getUser().getId())
                        .fullName(member.getUser().getFirstName() + " " + member.getUser().getLastName())
                        .receivedScore(member.getReceivedScore())
                        .completedDate(member.getCompletedDate())
                        .build())
                .toList();
        return QuizSessionLeaderboardResponse.builder()
                .startedDate(session.getStatedDate())
                .members(members)
                .build();
    }

    @Override
    public void updateLeaderboard(String quizSessionCode) {
        var zSetOps = redisTemplate.opsForZSet();
        var hashOps = redisTemplate.opsForHash();
        var rankingSet = zSetOps.reverseRangeWithScores("leaderboard:" + quizSessionCode, 0, -1);

        if (rankingSet == null) {
            return;
        }

        var members = rankingSet.stream()
                .map(item -> {
                    var score = item.getScore() != null ? item.getScore().intValue() : 0;
                    var userId = String.valueOf(item.getValue());
                    var fullName = String.valueOf(hashOps.get("members:" + quizSessionCode, userId));
                    return QuizSessionMemberResponse.builder()
                            .userId(userId)
                            .fullName(fullName)
                            .receivedScore(score)
                            .build();
                })
                .toList();

        var leaderboard = QuizSessionLeaderboardResponse.builder()
                .members(members)
                .build();

        messagingTemplate.convertAndSend(
                "/topic/quiz-sessions/" + quizSessionCode + "/leaderboard",
                leaderboard
        );
    }
}
