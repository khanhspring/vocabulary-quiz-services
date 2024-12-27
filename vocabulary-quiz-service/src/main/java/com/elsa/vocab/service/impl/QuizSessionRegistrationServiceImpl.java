package com.elsa.vocab.service.impl;

import com.elsa.vocab.application.model.request.QuizSessionRegistrationRequest;
import com.elsa.vocab.infrastructure.configuration.exception.ApplicationException;
import com.elsa.vocab.infrastructure.enumeration.QuizSessionStatus;
import com.elsa.vocab.infrastructure.util.AuthUtils;
import com.elsa.vocab.service.QuizSessionMemberService;
import com.elsa.vocab.service.QuizSessionRegistrationService;
import com.elsa.vocab.service.QuizSessionService;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizSessionRegistrationServiceImpl implements QuizSessionRegistrationService {

    private final QuizSessionService quizSessionService;
    private final QuizSessionMemberService quizSessionMemberService;
    private static final int MAX_MEMBERS_TO_START = 2;

    @Override
    @Transactional
    public void register(QuizSessionRegistrationRequest request) throws SchedulerException {
        var userId = AuthUtils.currentUserIdOrElseThrow();
        var session = quizSessionService.getByCode(request.getSessionCode());
        if (session.getStatus() != QuizSessionStatus.Ready) {
            throw new ApplicationException("The quiz session is not accepted new registrations");
        }
        var isJoined = quizSessionMemberService.isJoined(userId, request.getSessionCode());
        if (isJoined) {
            throw new DuplicateRequestException("The user already joined the quiz session");
        }

        var totalMembers = quizSessionMemberService.getTotalMembers(userId);
        if (session.getMaxMembers() != null && totalMembers < session.getMaxMembers()) {
            quizSessionMemberService.addMember(userId, request.getSessionCode());
        }

        totalMembers = quizSessionMemberService.getTotalMembers(request.getSessionCode());
        if (totalMembers  >= MAX_MEMBERS_TO_START) {
            // TODO: in production, we should provide another mechanism to start a sessions
            quizSessionService.scheduleToStart(request.getSessionCode());
        }
    }
}
