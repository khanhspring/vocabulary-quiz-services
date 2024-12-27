package com.elsa.vocab.infrastructure.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz_session_member")
public class JpaQuizSessionMember extends TimestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Instant joinedDate;
    private Instant completedDate;
    private Integer receivedScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_session_id")
    private JpaQuizSession quizSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private JpaUser user;
}
