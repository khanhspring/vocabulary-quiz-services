package com.elsa.vocab.service;

public interface QuizSessionMemberService {
    boolean isJoined(String userId, String quizSessionCode);
    void addMember(String userId, String quizSessionCode);
    void addScore(String userId, String quizSessionCode, Integer score);
    Integer getTotalMembers(String quizSessionCode);
}
