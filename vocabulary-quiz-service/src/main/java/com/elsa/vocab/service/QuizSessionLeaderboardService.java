package com.elsa.vocab.service;

import com.elsa.vocab.application.model.response.QuizSessionLeaderboardResponse;

public interface QuizSessionLeaderboardService {
    QuizSessionLeaderboardResponse getLeaderboard(String quizSessionCode);
    void updateLeaderboard(String quizSessionCode);
}
