USE DOSIRAK;
DROP TABLE IF EXISTS ADMIN CASCADE;

CREATE TABLE survey_version (
    version_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '버전 식별코드',
    version_name VARCHAR(255) NOT NULL COMMENT '버전 별칭',
    version_explain VARCHAR(40) NOT NULL COMMENT '버전 설명',
    update_date DATE NOT NULL COMMENT '추가된 날짜',
    status BOOLEAN NOT NULL COMMENT '사용 상태'
);
-- survey_question 테이블 생성
CREATE TABLE survey_question (
    question_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '질문 코드',
    version_id INT COMMENT '설문 버전',
    question_order INT COMMENT '질문 순서',
    question_text VARCHAR(30) COMMENT '질문 내용',
    question_category CHAR(1) CHECK (question_category IN ('C', 'P', 'F', 'W')) COMMENT '질문 분류(C, P, F, W)',
    FOREIGN KEY (version_id) REFERENCES survey_version(version_id)
);
-- survey_answer 테이블 생성
CREATE TABLE survey_answer (
    answer_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '답변 코드',
    question_id INT COMMENT '질문 코드',
    answer_text VARCHAR(15) COMMENT '답변 내용',
    answer_value INT COMMENT '답변 값',
    FOREIGN KEY (question_id) REFERENCES survey_question(question_id)
);
-- survey_range 테이블 생성
CREATE TABLE survey_range (
    version_id INT,
    category CHAR(1) CHECK (category IN ('C', 'P', 'F', 'W')),
    range1 INT,
    range2 INT,
    range3 INT,
    range4 INT,
    PRIMARY KEY (version_id, category),
    FOREIGN KEY (version_id) REFERENCES survey_version(version_id),
    CHECK (range1 < range2 AND range2 < range3 AND range3 < range4)
);

INSERT INTO survey_version (version_name, version_explain, update_date, status) VALUES
    ('Version 1', '첫 번째 버전', '2024-04-23', true),
    ('Version 2', '두 번째 버전', '2024-04-23', true),
    ('Version 3', '세 번째 버전', '2024-04-23', false);

-- 버전 1에 대한 더미 데이터 삽입
INSERT INTO survey_question (version_id, question_order, question_text, question_category) VALUES
   (1, 1, '질문 1-1', 'C'),
   (1, 2, '질문 1-2', 'P'),
   (1, 3, '질문 1-3', 'F'),
   (1, 4, '질문 1-4', 'W'),
   (1, 5, '질문 1-5', 'C');

-- 버전 2에 대한 더미 데이터 삽입
INSERT INTO survey_question (version_id, question_order, question_text, question_category) VALUES
   (2, 1, '질문 2-1', 'P'),
   (2, 2, '질문 2-2', 'F'),
   (2, 3, '질문 2-3', 'W'),
   (2, 4, '질문 2-4', 'C'),
   (2, 5, '질문 2-5', 'P');

-- 버전 3에 대한 더미 데이터 삽입
INSERT INTO survey_question (version_id, question_order, question_text, question_category) VALUES
   (3, 1, '질문 3-1', 'F'),
   (3, 2, '질문 3-2', 'W'),
   (3, 3, '질문 3-3', 'C'),
   (3, 4, '질문 3-4', 'P'),
   (3, 5, '질문 3-5', 'F');
-- 질문 코드 1에 대한 더미 데이터 삽입
INSERT INTO survey_answer (question_id, answer_text, answer_value) VALUES
    (1, '답변 1-1', 1),
    (1, '답변 1-2', 2),
    (1, '답변 1-3', 3);

-- 질문 코드 2에 대한 더미 데이터 삽입
INSERT INTO survey_answer (question_id, answer_text, answer_value) VALUES
    (2, '답변 2-1', 1),
    (2, '답변 2-2', 2),
    (2, '답변 2-3', 3);

-- 질문 코드 3에 대한 더미 데이터 삽입
INSERT INTO survey_answer (question_id, answer_text, answer_value) VALUES
    (3, '답변 3-1', 1),
    (3, '답변 3-2', 2),
    (3, '답변 3-3', 3);

INSERT INTO SURVEY_RANGE (VERSION_ID, CATEGORY, RANGE1, RANGE2, RANGE3, RANGE4)VALUES
    (1, 'C', 3, 5, 7, 9),
    (1, 'P', 3, 5, 7, 9),
    (1, 'F', 3, 5, 7, 9),
    (1, 'W', 3, 5, 7, 9)
