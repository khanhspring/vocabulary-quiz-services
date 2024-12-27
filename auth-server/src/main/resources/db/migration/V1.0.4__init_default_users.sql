INSERT INTO "user" (id, username, email, "password", status, first_name, last_name, created_date, created_by,
                    last_modified_date, last_modified_by, "version")
VALUES ('00000000-0000-0000-0000-000000000001', 'user1', 'user1@gmail.com',
        '$2a$10$UIuw9SAfzpivUFHbb1jv5e4rnzOI3M6AWld3bPjqdTNxYdVNpdDP2', -- 123456a@
        'Active', 'An', 'Nguyen', CURRENT_TIMESTAMP,
        NULL, CURRENT_TIMESTAMP, NULL, 0),
       ('00000000-0000-0000-0000-000000000002', 'user2', 'user2@gmail.com',
        '$2a$10$UIuw9SAfzpivUFHbb1jv5e4rnzOI3M6AWld3bPjqdTNxYdVNpdDP2', -- 123456a@
        'Active', 'Khanh', 'Tran', CURRENT_TIMESTAMP,
        NULL, CURRENT_TIMESTAMP, NULL, 0),
       ('00000000-0000-0000-0000-000000000003', 'user3', 'user3@gmail.com',
        '$2a$10$UIuw9SAfzpivUFHbb1jv5e4rnzOI3M6AWld3bPjqdTNxYdVNpdDP2', -- 123456a@
        'Active', 'Trang', 'Nguyen', CURRENT_TIMESTAMP,
        NULL, CURRENT_TIMESTAMP, NULL, 0),
       ('00000000-0000-0000-0000-000000000004', 'user4', 'user4@gmail.com',
        '$2a$10$UIuw9SAfzpivUFHbb1jv5e4rnzOI3M6AWld3bPjqdTNxYdVNpdDP2', -- 123456a@
        'Active', 'Nam', 'Hoang', CURRENT_TIMESTAMP,
        NULL, CURRENT_TIMESTAMP, NULL, 0);