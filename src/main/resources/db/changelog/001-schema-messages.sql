DROP TABLE IF EXISTS messages;

CREATE TABLE messages
(
    id   INT PRIMARY KEY,
    text VARCHAR(250) NOT NULL
);

INSERT INTO messages (id, text)
VALUES (1, 'Hello'),
       (2, 'Bonjour'),
       (3, 'Aloha'),
       (4, 'Shalom'),
       (5, 'Guten Tag');