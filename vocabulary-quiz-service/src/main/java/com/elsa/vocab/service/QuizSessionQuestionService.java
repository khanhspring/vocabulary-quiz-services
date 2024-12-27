package com.elsa.vocab.service;

import com.elsa.vocab.infrastructure.model.common.QuizQuestionDetail;

public interface QuizSessionQuestionService {
    QuizQuestionDetail getQuestionDetail(String questionId);
}
