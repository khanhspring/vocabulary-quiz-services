package com.elsa.vocab.application.model.response;

import com.elsa.vocab.infrastructure.enumeration.QuizQuestionType;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionResponse {
    private String id;
    private QuizQuestionType type;
    private String content;
    private Map<String, String> options;
}
