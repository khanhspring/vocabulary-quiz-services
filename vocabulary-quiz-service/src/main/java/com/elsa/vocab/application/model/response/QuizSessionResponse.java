package com.elsa.vocab.application.model.response;

import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizSessionResponse {
    private String id;
    private String code;
    private String title;
    private String description;
    private Integer duration;
    private Integer maxMembers;
    private Integer totalQuestions;
    private QuizSessionStatus status;
    private Instant statedDate;
    private Instant scheduledDate;
    private boolean isJoined;
}
