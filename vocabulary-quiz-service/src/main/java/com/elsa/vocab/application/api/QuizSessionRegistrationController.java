package com.elsa.vocab.application.api;

import com.elsa.vocab.application.model.request.QuizSessionRegistrationRequest;
import com.elsa.vocab.service.QuizSessionRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/quiz-sessions/registrations")
public class QuizSessionRegistrationController {
    private final QuizSessionRegistrationService quizSessionRegistrationService;

    @PostMapping
    public void register(@Valid @RequestBody QuizSessionRegistrationRequest request) throws SchedulerException {
        quizSessionRegistrationService.register(request);
    }
}
