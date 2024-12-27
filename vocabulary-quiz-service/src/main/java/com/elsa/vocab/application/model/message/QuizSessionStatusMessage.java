package com.elsa.vocab.application.model.message;

import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizSessionStatusMessage {
    private QuizSessionStatus status;
    private int countDownTime;
}
