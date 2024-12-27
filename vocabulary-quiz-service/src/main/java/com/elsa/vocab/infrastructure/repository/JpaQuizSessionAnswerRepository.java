package com.elsa.vocab.infrastructure.repository;

import com.elsa.vocab.infrastructure.model.entity.JpaQuizSessionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaQuizSessionAnswerRepository extends JpaRepository<JpaQuizSessionAnswer, String> {
    Optional<JpaQuizSessionAnswer> findByQuizSessionQuestionIdAndQuizSessionMemberUserId(String sessionQuestionId, String userId);
}