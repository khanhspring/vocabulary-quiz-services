package com.elsa.vocab.infrastructure.repository;

import com.elsa.vocab.infrastructure.model.entity.JpaQuizSessionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaQuizSessionQuestionRepository extends JpaRepository<JpaQuizSessionQuestion, String> {
    List<JpaQuizSessionQuestion> findByQuizSessionCode(String quizSessionCode);
}