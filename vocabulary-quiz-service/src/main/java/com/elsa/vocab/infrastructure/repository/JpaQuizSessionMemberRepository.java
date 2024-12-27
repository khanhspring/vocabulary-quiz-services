package com.elsa.vocab.infrastructure.repository;

import com.elsa.vocab.infrastructure.model.entity.JpaQuizSessionMember;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaQuizSessionMemberRepository extends JpaRepository<JpaQuizSessionMember, String> {
    boolean existsByQuizSessionCodeAndUserId(String quizSessionCode, String userId);
    Integer countByQuizSessionCode(String quizSessionCode);
    Optional<JpaQuizSessionMember> findByQuizSessionCodeAndUserId(String quizSessionCode, String userId);
    List<JpaQuizSessionMember> findAllByQuizSessionCode(String quizSessionCode, Sort sort);
}