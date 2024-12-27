package com.elsa.vocab.application.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponse {
    private boolean correct;
    private int receivedScore;
}
