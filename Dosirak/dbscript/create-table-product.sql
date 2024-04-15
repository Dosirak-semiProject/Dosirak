CREATE DATABASE dosirak;
GRANT ALL PRIVILEGES ON dosirak.* TO 'ohgiraffers'@'%';
USE dosirak;
DROP TABLE  tbl_product ;
CREATE TABLE  tbl_product
(
    PRODUCT_CODE    INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PRODUCT_NAME    VARCHAR(20) UNIQUE                  NOT NULL,
    product_price   INTEGER(20)                         NOT NULL,
    product_status  VARCHAR(20)                         NOT NULL,
    product_summary VARCHAR(20)                         NOT NULL,
    product_category_code int(10) NOT NULL ,
    product_subcategory_code INT(255),
    FOREIGN KEY (product_category_code) REFERENCES tbl_product_category(product_main_category_code),
    FOREIGN KEY (product_subcategory_code) REFERENCES tbl_product_category(product_subcategory_code)
) ENGINE = INNODB;
INSERT INTO tbl_product
    VALUE ('1','헬시 도시락','12000','판매중','맛난거','1','1');
INSERT INTO tbl_product
    VALUE ('2','샐러드','13000','판매중단','안맛난거','2','5');


DROP TABLE tbl_product_category;
CREATE TABLE IF NOT EXISTS tbl_product_category
(
    product_subcategory_code     INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product_subcategory_name     VARCHAR(20)                  NOT NULL,
    product_main_category_code INT(255)                         ,
    product_main_category_name VARCHAR(20),
    FOREIGN KEY (product_main_category_code) REFERENCES tbl_product_category (product_subcategory_code)
) ENGINE = INNODB;
INSERT INTO tbl_product_category
VALUES ('1','암환자 회복식단','1','건강관리식단');
INSERT INTO tbl_product_category
VALUES ('2','신장 관리식단','1','건강관리식단');
INSERT INTO tbl_product_category
VALUES ('3','혈압 관리식단','1','건강관리식단');
INSERT INTO tbl_product_category
VALUES ('4','혈당 관리식단','1','건강관리식단');
INSERT INTO tbl_product_category
VALUES ('5','샐러드','2','간편식');
INSERT INTO tbl_product_category
VALUES ('6','닭 가슴살','2','간편식');


CREATE TABLE IF NOT EXISTS tbl_detail
(
    detailitem_count INT(255)           NOT NULL,
    detailitem_code  VARCHAR(20) UNIQUE NOT NULL,
    suitbox_code     INT(20)            NOT NULL,
    detail_code      int(20) primary key,
    order_code       INT(12)            not null,
    FOREIGN KEY (order_code) REFERENCES tbl_order (order_code)
) ENGINE = INNODB;
CREATE TABLE IF NOT EXISTS tbl_order
(
    order_code      INT(12) primary key NOT NULL,
    order_status    VARCHAR(5) UNIQUE   NOT NULL,
    order_recipient VARCHAR(5)          NOT NULL,
    order_contact   int(20) NOT NULL ,
    oder_address VARCHAR(100) NOT NULL ,
    user_id VARCHAR(20) not null ,
    FOREIGN KEY (user_id) REFERENCES USER (ID)
) ENGINE = INNODB;


CREATE TABLE IF NOT EXISTS USER
(
    ID         VARCHAR(20) UNIQUE NOT NULL COMMENT '회원아이디',
    NAME       VARCHAR(5)         NOT NULL COMMENT '이름',
    BIRTH      DATE               NOT NULL COMMENT '생년월일',
    GENDER     CHAR               NOT NULL COMMENT '성별',
    PHONE      VARCHAR(20)        NOT NULL COMMENT '휴대폰번호',
    EMAIL      VARCHAR(50)        NOT NULL COMMENT '이메일',
    ADDRESS1   VARCHAR(50) COMMENT '주소1',
    ADDRESS2   VARCHAR(50) COMMENT '주소2',
    ADDRESS3   VARCHAR(50) COMMENT '주소3',
    AGREE      VARCHAR(10) COMMENT '마케팅동의',
    PWD        VARCHAR(50)        NOT NULL COMMENT '비밀번호',
    JOINDATE   DATE               NOT NULL COMMENT '가입날짜',
    WITHDRAWAL BOOLEAN            NOT NULL COMMENT '탈퇴여부'  DEFAULT FALSE,
    ROLE       VARCHAR(50)        NOT NULL COMMENT '사용자구분' DEFAULT 'USER'
) ENGINE = INNODB COMMENT '회원';

INSERT INTO USER
VALUES ('starry2', '김성우', '1993-07-15', '남', '01012345678', 'starry2@gmail.com', '06133', '서울 강남구 테헤란로 123', '101호',
        '문자', 'starry2', '2024-04-21', FALSE, 'USER');
INSERT INTO USER
VALUES ('junho25', '이준호', '1988-05-02', '남', '01098765432', 'junho25@naver.com', '16546', '경기 수원시 영통구 매탄로 69', '201호',
        '문자, 이메일', 'junho25', '2024-04-30', FALSE, 'USER');

select *
from USER;

CREATE TABLE IF NOT EXISTS ADMIN
(
    ID         VARCHAR(20) PRIMARY KEY COMMENT '관리자아이디',
    NAME       VARCHAR(5)         NOT NULL COMMENT '이름',
    BIRTH      DATE COMMENT '생년월일',
    GENDER     CHAR COMMENT '성별',
    CONTACT    VARCHAR(5) COMMENT '내선번호',
    EMAIL      VARCHAR(50)        NOT NULL COMMENT '이메일',
    DEPARTMENT VARCHAR(10) COMMENT '부서',
    POSITION   VARCHAR(10) COMMENT '직급',
    AUTHORITY  CHAR               NOT NULL COMMENT '권한등급'  DEFAULT 3,
    PWD        VARCHAR(50) UNIQUE NOT NULL COMMENT '비밀번호',
    JOINDATE   DATE               NOT NULL COMMENT '입사날짜',
    WITHDRAWAL BOOLEAN            NOT NULL COMMENT '퇴직여부'  DEFAULT FALSE,
    ROLE       VARCHAR(50)        NOT NULL COMMENT '사용자구분' DEFAULT 'ADMIN'
) ENGINE = INNODB COMMENT '관리자';

INSERT INTO ADMIN
VALUES ('jh6805', '임지훈', '1968-05-12', '남', '100', 'jh6805@naver.com', '마케팅', '임원', 1, 'jh6805', '2012-12-20', FALSE,
        'ADMIN');
INSERT INTO ADMIN
VALUES ('choijihyun72', '최지현', '1975-02-10', '여', '101', 'choijihyun72@naver.com', '마케팅', '팀장', 2, 'choijihyun72',
        '2014-07-21', FALSE, 'ADMIN');

select *
from ADMIN;



