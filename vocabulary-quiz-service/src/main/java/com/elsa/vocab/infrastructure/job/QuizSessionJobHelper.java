package com.elsa.vocab.infrastructure.job;

import lombok.RequiredArgsConstructor;
import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class QuizSessionJobHelper {
    private final Scheduler scheduler;

    public void triggerToStart(String quizSessionCode) throws SchedulerException {
        var job = JobBuilder.newJob().ofType(QuizSessionStarterJob.class)
                .storeDurably()
                .withIdentity("quizSessionStarterJob" + quizSessionCode)
                .build();

        var cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, 5);
        var trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerToStartQuizSession" + quizSessionCode)
                .usingJobData("quizSessionCode", quizSessionCode)
                .startAt(cal.getTime())
                .build();
        scheduler.scheduleJob(job, trigger);
    }

    public void triggerToComplete(String quizSessionCode, Integer duration) throws SchedulerException {
        var job = JobBuilder.newJob().ofType(QuizSessionCompletedJob.class)
                .storeDurably()
                .withIdentity("quizSessionCompletedJob" + quizSessionCode)
                .build();

        var cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, duration);
        var trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerToCompleteQuizSession" + quizSessionCode)
                .usingJobData("quizSessionCode", quizSessionCode)
                .startAt(cal.getTime())
                .build();
        scheduler.scheduleJob(job, trigger);
    }
}
