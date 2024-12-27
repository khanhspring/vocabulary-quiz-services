package com.elsa.vocab.application.api;

import com.elsa.vocab.application.model.request.AnswerQuizSessionQuestionRequest;
import com.elsa.vocab.application.model.request.SearchQuizSessionRequest;
import com.elsa.vocab.application.model.response.AnswerResponse;
import com.elsa.vocab.application.model.response.QuizQuestionResponse;
import com.elsa.vocab.application.model.response.QuizSessionResponse;
import com.elsa.vocab.service.QuizSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/quiz-sessions")
public class QuizSessionController {

    private final QuizSessionService quizSessionService;

    @GetMapping
    public Page<QuizSessionResponse> search(@Valid SearchQuizSessionRequest request,
                                            @PageableDefault(size = 20, sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return quizSessionService.search(request, pageable);
    }

    @GetMapping("/{code}")
    public QuizSessionResponse getByCode(@PathVariable("code") String code) {
        return quizSessionService.getByCode(code);
    }

    @GetMapping("/{code}/questions")
    public List<QuizQuestionResponse> getQuestions(@PathVariable("code") String code) {
        return quizSessionService.getQuestions(code);
    }

    @PostMapping("/{code}/answers")
    public AnswerResponse answer(@PathVariable("code") String code,
                                       @Valid @RequestBody AnswerQuizSessionQuestionRequest request) {
        return quizSessionService.answer(code, request);
    }
}
