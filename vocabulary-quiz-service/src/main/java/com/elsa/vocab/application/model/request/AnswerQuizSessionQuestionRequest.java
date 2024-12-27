package com.elsa.vocab.application.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerQuizSessionQuestionRequest {
    @NotNull
    private String questionId;
    @NotNull
    private List<String> answer;
}
