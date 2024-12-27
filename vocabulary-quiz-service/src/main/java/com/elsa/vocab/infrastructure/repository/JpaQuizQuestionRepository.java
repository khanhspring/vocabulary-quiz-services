package com.elsa.vocab.infrastructure.repository;

import com.elsa.vocab.infrastructure.model.entity.JpaQuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaQuizQuestionRepository extends JpaRepository<JpaQuizQuestion, String> {
}