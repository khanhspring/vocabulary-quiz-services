package com.elsa.vocab.infrastructure.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionDetail {
    private String id;
    private List<String> correctAnswer;
    private Integer score;
}
