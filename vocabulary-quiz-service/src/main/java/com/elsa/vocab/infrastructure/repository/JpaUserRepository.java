package com.elsa.vocab.infrastructure.repository;

import com.elsa.vocab.infrastructure.model.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<JpaUser, String> {

}