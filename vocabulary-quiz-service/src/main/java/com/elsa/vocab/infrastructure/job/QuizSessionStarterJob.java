package com.elsa.vocab.infrastructure.job;

import com.elsa.vocab.infrastructure.configuration.exception.ApplicationException;
import com.elsa.vocab.service.QuizSessionService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuizSessionStarterJob implements Job {
    private final QuizSessionService quizSessionService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        var sessionCode = jobExecutionContext.getTrigger()
                .getJobDataMap()
                .getString("quizSessionCode");
        try {
            quizSessionService.start(sessionCode);
        } catch (SchedulerException e) {
            throw new ApplicationException(e);
        }
    }
}
