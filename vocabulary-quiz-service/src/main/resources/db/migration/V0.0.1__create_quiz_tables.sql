CREATE TABLE quiz_session
(
    id                 varchar(36)  NOT NULL,
    code               varchar(10)  NOT NULL,
    title              varchar(250) NOT NULL,
    description        varchar(2000),
    duration           int          NOT NULL DEFAULT 0,
    max_members        int,
    total_questions    int          NOT NULL,
    status             varchar(20)  NOT NULL,
    scheduled_date        timestamp,
    stated_date        timestamp,

    created_date       timestamp    NOT NULL,
    created_by         varchar(36)           DEFAULT NULL,
    last_modified_date timestamp             DEFAULT NULL,
    last_modified_by   varchar(36)           DEFAULT NULL,
    version            int,
    PRIMARY KEY (id)
);

CREATE TABLE quiz_session_member
(
    id                 varchar(36) NOT NULL,
    quiz_session_id    varchar(36) NOT NULL,
    user_id            varchar(36) NOT NULL,
    joined_date        timestamp   NOT NULL,
    completed_date     timestamp,
    received_score     int,

    created_date       timestamp   NOT NULL,
    last_modified_date timestamp DEFAULT NULL,
    version            int,
    PRIMARY KEY (id),
    CONSTRAINT fk_quiz_session_member_quiz_session_id FOREIGN KEY (quiz_session_id) REFERENCES quiz_session (id),
    CONSTRAINT fk_quiz_session_member_user_id FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE quiz_question
(
    id                 varchar(36) NOT NULL,
    type               varchar(20) NOT NULL,
    content            text        NOT NULL,
    options            jsonb,
    correct_answer     jsonb,
    status             varchar(20) NOT NULL,
    difficulty_level   varchar(20) NOT NULL,

    created_date       timestamp   NOT NULL,
    created_by         varchar(36) DEFAULT NULL,
    last_modified_date timestamp   DEFAULT NULL,
    last_modified_by   varchar(36) DEFAULT NULL,
    version            int,
    PRIMARY KEY (id)
);

CREATE TABLE quiz_session_question
(
    id                 varchar(36) NOT NULL,
    quiz_session_id    varchar(36) NOT NULL,
    quiz_question_id   varchar(36) NOT NULL,
    score              int         NOT NULL,

    created_date       timestamp   NOT NULL,
    last_modified_date timestamp DEFAULT NULL,
    version            int,
    PRIMARY KEY (id),
    CONSTRAINT fk_quiz_session_question_quiz_session_id FOREIGN KEY (quiz_session_id) REFERENCES quiz_session (id),
    CONSTRAINT fk_quiz_session_question_quiz_question_id FOREIGN KEY (quiz_question_id) REFERENCES quiz_question (id)
);

CREATE TABLE quiz_session_answer
(
    id                       varchar(36) NOT NULL,
    quiz_session_member_id   varchar(36) NOT NULL,
    quiz_session_question_id varchar(36) NOT NULL,
    answer                   jsonb NULL,
    received_score           int         NOT NULL,
    submitted_date           timestamp   NOT NULL,

    created_date             timestamp   NOT NULL,
    created_by               varchar(36) DEFAULT NULL,
    last_modified_date       timestamp   DEFAULT NULL,
    last_modified_by         varchar(36) DEFAULT NULL,
    version                  int,
    PRIMARY KEY (id),
    CONSTRAINT fk_quiz_session_answer_quiz_session_member_id FOREIGN KEY (quiz_session_member_id) REFERENCES quiz_session_member (id),
    CONSTRAINT fk_quiz_session_answer_quiz_session_question_id FOREIGN KEY (quiz_session_question_id) REFERENCES quiz_session_question (id)
);
