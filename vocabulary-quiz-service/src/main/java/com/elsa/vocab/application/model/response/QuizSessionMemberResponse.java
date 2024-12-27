package com.elsa.vocab.application.model.response;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizSessionMemberResponse {
    private String userId;
    private String fullName;
    private Instant completedDate;
    private Integer receivedScore;
}
