package com.elsa.vocab.infrastructure.model.entity;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz_session_answer")
public class JpaQuizSessionAnswer extends TimestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer receivedScore;
    private Instant submittedDate;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_session_member_id")
    private JpaQuizSessionMember quizSessionMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_session_question_id")
    private JpaQuizSessionQuestion quizSessionQuestion;
}
