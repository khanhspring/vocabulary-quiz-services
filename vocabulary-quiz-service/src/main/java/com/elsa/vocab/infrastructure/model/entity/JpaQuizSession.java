package com.elsa.vocab.infrastructure.model.entity;

import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz_session")
public class JpaQuizSession extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String title;
    private String description;
    private Integer duration;
    private Integer maxMembers;
    private Integer totalQuestions;
    @Enumerated(EnumType.STRING)
    private QuizSessionStatus status;
    private Instant scheduledDate;
    private Instant statedDate;
}
