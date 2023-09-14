INSERT INTO users (email, password)
VALUES ('sza@malpa.com', 'password');

INSERT INTO user_authorities (user_id, authority)
VALUES ((SELECT id FROM users WHERE email = 'sza@malpa.com'), 'ROLE_ADMIN');
