package com.elsa.vocab.application.model.response;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizSessionLeaderboardResponse {
    private Instant startedDate;
    private List<QuizSessionMemberResponse> members;
}
