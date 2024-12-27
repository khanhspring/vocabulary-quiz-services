package com.elsa.vocab.service.impl;

import com.elsa.vocab.infrastructure.configuration.exception.ResourceNotFoundException;
import com.elsa.vocab.infrastructure.model.common.QuizQuestionDetail;
import com.elsa.vocab.infrastructure.repository.JpaQuizSessionQuestionRepository;
import com.elsa.vocab.service.QuizSessionQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizSessionQuestionServiceImpl implements QuizSessionQuestionService {
    private final JpaQuizSessionQuestionRepository quizSessionQuestionRepository;

    @Override
    @Cacheable("quiz_session_question")
    public QuizQuestionDetail getQuestionDetail(String sessionQuestionId) {
        var item = quizSessionQuestionRepository.findById(sessionQuestionId)
                .orElseThrow(ResourceNotFoundException::new);
        return QuizQuestionDetail.builder()
                .id(item.getId())
                .correctAnswer(item.getQuestion().getCorrectAnswer())
                .score(item.getScore())
                .build();
    }
}
