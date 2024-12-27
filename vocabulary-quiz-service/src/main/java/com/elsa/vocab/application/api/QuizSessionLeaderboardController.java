package com.elsa.vocab.application.api;

import com.elsa.vocab.application.model.response.QuizSessionLeaderboardResponse;
import com.elsa.vocab.service.QuizSessionLeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/quiz-sessions/{code}")
public class QuizSessionLeaderboardController {

    private final QuizSessionLeaderboardService leaderboardService;

    @GetMapping("leaderboard")
    public QuizSessionLeaderboardResponse getLeaderboard(@PathVariable("code") String code) {
        return leaderboardService.getLeaderboard(code);
    }
}
