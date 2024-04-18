USE DOSIRAK;
DROP TABLE IF EXISTS VERIFY CASCADE;

CREATE TABLE VERIFY (
    VERIFYPAGE VARCHAR(255) NOT NULL,
    VERIFYCODE VARCHAR(255) NOT NULL,
    VERIFYTIME DATETIME NOT NULL
);

INSERT INTO VERIFY VALUE (1, 1, NOW());
INSERT INTO VERIFY VALUE (1, 2, NOW());
INSERT INTO VERIFY VALUE (1, 3, NOW());
INSERT INTO VERIFY VALUE (1, 4, NOW());
INSERT INTO VERIFY VALUE (1, 5, NOW());

select * from VERIFY;