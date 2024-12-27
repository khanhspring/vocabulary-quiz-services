package com.elsa.vocab.service;

import com.elsa.vocab.application.model.request.QuizSessionRegistrationRequest;
import org.quartz.SchedulerException;

public interface QuizSessionRegistrationService {
    void register(QuizSessionRegistrationRequest request) throws SchedulerException;
}
