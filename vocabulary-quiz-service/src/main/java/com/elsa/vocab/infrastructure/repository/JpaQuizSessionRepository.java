package com.elsa.vocab.infrastructure.repository;

import com.elsa.vocab.infrastructure.model.entity.JpaQuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaQuizSessionRepository extends JpaRepository<JpaQuizSession, String> {

    Optional<JpaQuizSession> findByCode(String code);
}