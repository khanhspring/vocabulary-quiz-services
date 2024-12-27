INSERT INTO quiz_question (id, "type", "content", "options", correct_answer, status, difficulty_level,
                           created_date, created_by, last_modified_date, last_modified_by, "version")
VALUES ('00000000-0000-0000-0000-000000000001', 'MultiChoice', 'What is the synonym of "happy"?',
        '{"a": "Sad", "b": "Joyful", "c": "Angry", "d": "Bored"}', '["a"]', 'Approved', 'Easy',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000002', 'MultiChoice', 'What does the word "benevolent" mean?',
        '{"a": "Kind", "b": "Cruel", "c": "Lazy", "d": "Boring"}', '["a"]', 'Approved', 'Medium',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000003', 'MultiChoice', 'Choose the correct meaning of "ubiquitous".',
        '{"a": "Rare", "b": "Everywhere", "c": "Unique", "d": "Expensive"}', '["b"]', 'Approved', 'Hard',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000004', 'MultiChoice', 'What is the antonym of "ancient"?',
        '{"a": "Modern", "b": "Old", "c": "Historical", "d": "Timeless"}', '["a"]', 'Approved', 'Easy',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000005', 'MultiChoice', 'Which word means "to enhance or improve"?',
        '{"a": "Diminish", "b": "Augment", "c": "Deplete", "d": "Reduce"}', '["b"]', 'Approved', 'Medium',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000006', 'MultiChoice', 'Find the word closest in meaning to "obstinate".',
        '{"a": "Flexible", "b": "Stubborn", "c": "Friendly", "d": "Generous"}', '["b"]', 'Approved', 'Hard',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000007', 'MultiChoice', 'What is the meaning of the word "ephemeral"?',
        '{"a": "Lasting a long time", "b": "Short-lived", "c": "Unknown", "d": "Strong"}', '["b"]', 'Approved', 'Medium',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000008', 'MultiChoice', 'What is the synonym of "meticulous"?',
        '{"a": "Careless", "b": "Thorough", "c": "Rude", "d": "Lazy"}', '["b"]', 'Approved', 'Medium',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000009', 'MultiChoice', 'Choose the correct meaning of "inevitable".',
        '{"a": "Uncertain", "b": "Avoidable", "c": "Unavoidable", "d": "Doubtful"}', '["c"]', 'Approved', 'Medium',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1),
       ('00000000-0000-0000-0000-000000000010', 'MultiChoice', 'What does the word "serendipity" mean?',
        '{"a": "Planned success", "b": "Fortunate accident", "c": "Persistent failure", "d": "Unexpected loss"}', '["b"]',
        'Approved', 'Hard',
        CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, 1);;

INSERT INTO quiz_session_question (id, quiz_session_id, quiz_question_id, score, created_date,
                                   last_modified_date, "version")
VALUES (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000001', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000002', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000003', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000004', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000005', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000006', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000007', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000008', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000009', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000001',
        '00000000-0000-0000-0000-000000000010', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);

INSERT INTO quiz_session_question (id, quiz_session_id, quiz_question_id, score, created_date,
                                   last_modified_date, "version")
VALUES (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000001', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000002', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000003', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000004', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000005', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000006', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000007', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000008', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000009', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000002',
        '00000000-0000-0000-0000-000000000010', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);


INSERT INTO quiz_session_question (id, quiz_session_id, quiz_question_id, score, created_date,
                                   last_modified_date, "version")
VALUES (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000001', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000002', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000003', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000004', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000005', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000006', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000007', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000008', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000009', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000003',
        '00000000-0000-0000-0000-000000000010', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);


INSERT INTO quiz_session_question (id, quiz_session_id, quiz_question_id, score, created_date,
                                   last_modified_date, "version")
VALUES (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000001', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000002', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000003', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000004', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000005', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000006', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000007', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000008', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000009', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000004',
        '00000000-0000-0000-0000-000000000010', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);


INSERT INTO quiz_session_question (id, quiz_session_id, quiz_question_id, score, created_date,
                                   last_modified_date, "version")
VALUES (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000001', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000002', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000003', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000004', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000005', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000006', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000007', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000008', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000009', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000005',
        '00000000-0000-0000-0000-000000000010', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);


INSERT INTO quiz_session_question (id, quiz_session_id, quiz_question_id, score, created_date,
                                   last_modified_date, "version")
VALUES (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000001', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000002', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000003', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000004', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000005', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000006', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000007', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000008', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000009', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       (gen_random_uuid(), '00000000-0000-0000-0000-000000000006',
        '00000000-0000-0000-0000-000000000010', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);