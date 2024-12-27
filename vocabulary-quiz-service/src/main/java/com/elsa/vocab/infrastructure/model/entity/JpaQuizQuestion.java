package com.elsa.vocab.infrastructure.model.entity;

import com.elsa.vocab.infrastructure.enumeration.QuizQuestionDifficultyLevel;
import com.elsa.vocab.infrastructure.enumeration.QuizQuestionStatus;
import com.elsa.vocab.infrastructure.enumeration.QuizQuestionType;
import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz_question")
public class JpaQuizQuestion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private QuizQuestionType type;

    private String content;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> options;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> correctAnswer;

    @Enumerated(EnumType.STRING)
    private QuizQuestionStatus status;

    @Enumerated(EnumType.STRING)
    private QuizQuestionDifficultyLevel difficultyLevel;
}
