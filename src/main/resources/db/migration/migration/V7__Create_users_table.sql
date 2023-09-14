/*
--postgresql

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_authorities (
    user_id BIGINT REFERENCES users(id),
    authority VARCHAR(255),
    PRIMARY KEY (user_id, authority)
);

--mysql
*/


CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_authorities (
    user_id INT,
    authority VARCHAR(255),
    PRIMARY KEY (user_id, authority),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
