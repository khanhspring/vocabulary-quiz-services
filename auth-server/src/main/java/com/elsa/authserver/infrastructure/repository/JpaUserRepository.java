package com.elsa.authserver.infrastructure.repository;

import com.elsa.authserver.infrastructure.common.enumeration.UserStatus;
import com.elsa.authserver.infrastructure.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<JpaUser, String> {
    boolean existsByEmail(String email);
    Optional<JpaUser> findByUsernameAndStatus(String username, UserStatus status);
    Optional<JpaUser> findByUsernameAndStatusIn(String username, List<UserStatus> statuses);
}
