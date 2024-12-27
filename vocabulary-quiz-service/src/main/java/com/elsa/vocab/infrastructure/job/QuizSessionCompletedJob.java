package com.elsa.vocab.infrastructure.job;

import com.elsa.vocab.service.QuizSessionService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuizSessionCompletedJob implements Job {
    private final QuizSessionService quizSessionService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        var sessionCode = jobExecutionContext.getTrigger()
                .getJobDataMap()
                .getString("quizSessionCode");
        quizSessionService.complete(sessionCode);
    }
}
