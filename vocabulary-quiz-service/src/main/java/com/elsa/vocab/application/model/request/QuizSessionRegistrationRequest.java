package com.elsa.vocab.application.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizSessionRegistrationRequest {
    @NotNull
    @NotEmpty
    private String sessionCode;
}
