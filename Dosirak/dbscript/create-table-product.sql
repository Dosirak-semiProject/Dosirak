CREATE DATABASE dosirak;
GRANT ALL PRIVILEGES ON dosirak.* TO 'ohgiraffers'@'%';
USE dosirak;
DROP TABLE tbl_product;
DROP DATABASE dosirak;
CREATE TABLE tbl_product
(
    PRODUCT_CODE          INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PRODUCT_NAME          VARCHAR(20) UNIQUE                  NOT NULL,
    product_price         INTEGER(20)                         NOT NULL,
    product_status        VARCHAR(20)                         NOT NULL,
    product_summary       VARCHAR(20)                         NOT NULL,
    product_category_code int(10)                             NOT NULL,
    FOREIGN KEY (product_category_code) REFERENCES tbl_product_category (product_main_category_code)
) ENGINE = INNODB;
INSERT INTO tbl_product
    VALUE ('1', '헬시 도시락', '12000', '판매중', '맛난거', '1');
INSERT INTO tbl_product
    VALUE ('8', '샐러드', '13000', '판매중단', '안맛난거', '8');
INSERT INTO tbl_product
    VALUE ('3', ' 도시락', '1000', '판매중', '맛난거', '8');
INSERT INTO tbl_product
    VALUE ('4', '암 도시락', '12000', '판매중', '맛난거', '4');
INSERT INTO tbl_product
    VALUE ('5', '혈당 도시락', '12000', '판매중', '맛난거', '7');



DROP TABLE tbl_product_category;
CREATE TABLE IF NOT EXISTS tbl_product_category
(
    product_main_category_code INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product_main_category_name VARCHAR(20)                         NOT NULL,
    product_sub_category_code  INT(255),
    FOREIGN KEY (product_sub_category_code) REFERENCES tbl_product_category (product_main_category_code)
) ENGINE = INNODB;
INSERT INTO tbl_product_category
VALUES ('1', '건강 도시락', null);
INSERT INTO tbl_product_category
VALUES ('2', '정성 도시락', null);
INSERT INTO tbl_product_category
VALUES ('3', '간편식', null);
INSERT INTO tbl_product_category
VALUES ('4', '암환자 회복식단', '1');
INSERT INTO tbl_product_category
VALUES ('5', '신장 관리식단', '1');
INSERT INTO tbl_product_category
VALUES ('6', '혈압 관리식단', '1');
INSERT INTO tbl_product_category
VALUES ('7', '혈당 관리식단', '1');
INSERT INTO tbl_product_category
VALUES ('8', '샐러드', '3');
INSERT INTO tbl_product_category
VALUES ('9', '닭 가슴살', '3');

USE DOSIRAK;
DROP TABLE IF EXISTS ADMIN CASCADE;

CREATE TABLE IF NOT EXISTS ADMIN
(
    ID         VARCHAR(20) PRIMARY KEY COMMENT '관리자아이디',
    NAME       VARCHAR(5)          NOT NULL COMMENT '이름',
    BIRTH      DATE COMMENT '생년월일',
    GENDER     CHAR COMMENT '성별',
    CONTACT    VARCHAR(5) COMMENT '내선번호',
    EMAIL      VARCHAR(50)         NOT NULL COMMENT '이메일',
    DEPARTMENT VARCHAR(10) COMMENT '부서',
    POSITION   VARCHAR(10) COMMENT '직급',
    AUTHORITY  CHAR                NOT NULL COMMENT '권한등급'  DEFAULT 3,
    PWD        VARCHAR(255) UNIQUE NOT NULL COMMENT '비밀번호',
    JOINDATE   DATE                NOT NULL COMMENT '입사날짜',
    WITHDRAWAL BOOLEAN             NOT NULL COMMENT '퇴직여부'  DEFAULT FALSE,
    ROLE       VARCHAR(50)         NOT NULL COMMENT '사용자구분' DEFAULT 'ADMIN'
) ENGINE = INNODB COMMENT '관리자';

INSERT INTO ADMIN (ID, NAME, BIRTH, GENDER, CONTACT, EMAIL, DEPARTMENT, POSITION, AUTHORITY, PWD, JOINDATE, WITHDRAWAL,
                   ROLE)
VALUES ('choijihyun7', '최지현', '1975-02-10', '여', '101', 'choijihyun7@gmail.com', '마케팅', '팀장', '2',
        '$2a$10$Un1IY9KPrmNH.Dc3c7dQ.e1DQTH8IZErLi4L4MCv/2SOUq0FYA4se', '2024-04-19', FALSE, 'ADMIN'),
       ('hanyeeun5', '한예은', '1998-05-25', '여', '104', 'hanyeeun5@gmail.com', '마케팅', '팀원', '3',
        '$2a$10$kG4kMTVOijM1yW3YaxO1sOpm/6tQ.khie7XWv.1yjLSce/y2W1dU.', '2024-04-19', FALSE, 'ADMIN'),
       ('hhwo146', '홍현우', '1970-06-30', '남', '400', 'hhwo146@naver.com', '인사재무', '임원', '1',
        '$2a$10$rhWYjJFJwazvWRqDBrp.Lus1t1jSCkyJthDgfBNfENX3RHyzXAite', '2024-04-19', FALSE, 'ADMIN'),
       ('hwangyunseo9', '황윤서', '1994-08-15', '여', '203', 'hwangyunseo9@daum.net', '운영', '팀원', '3',
        '$2a$10$BIwiyW0k6ozFwghjqRPZcetLxrHEWKlJL3A6ziHQOVWjDHJdSiJPi', '2024-04-19', FALSE, 'ADMIN'),
       ('imjunho67', '임준호', '1993-08-08', '남', '403', 'imjunho67@naver.com', '인사재무', '팀원', '3',
        '$2a$10$QjlGH.huZo0zxlkNeKix6OlALvHJ25Tyzo6GzvS5Sm3f7IyVYF32.', '2024-04-19', FALSE, 'ADMIN'),
       ('imseongmin82', '임성민', '1992-08-25', '남', '404', 'imseongmin82@daum.net', '인사재무', '팀원', '3',
        '$2a$10$dUrEbTmrjpKkdnbPluRA6eRhrjv7yHsl0WTZGcgjfUTLHY3Rc6F0u', '2024-04-19', FALSE, 'ADMIN'),
       ('jeongseongwoo14', '정성우', '1973-06-20', '남', '401', 'jeongseongwoo14@naver.com', '인사재무', '팀장', '2',
        '$2a$10$L.WufiCzVWsGjl.6Kx./FeOpldZuLPW46XGgPeo.FC1/SgkPAHASG', '2024-04-19', FALSE, 'ADMIN'),
       ('jeongseoyeon11', '정서연', '1985-06-15', '여', '302', 'jeongseoyeon11@gmail.com', '고객서비스', '부서장', '2',
        '$2a$10$b1Ew/FbLdkcKuVuv4dnqKOfgUK0u8iuRbOGYvpHLOW0m3VO7ce3S6', '2024-04-19', FALSE, 'ADMIN'),
       ('jmsevwx4', '정민서', '1976-09-25', '여', '500', 'jmsevwx4@naver.com', '시스템', '임원', '1',
        '$2a$10$CkgsgJ81QACem01RJv6oqekubwQbAnNX8G3JliXyqMkZFjYy7I5Qu', '2024-04-19', FALSE, 'ADMIN'),
       ('kanghaeun99', '강하은', '1983-02-15', '여', '502', 'kanghaeun99@naver.com', '시스템', '부서장', '2',
        '$2a$10$fROuVZ8Nh9LtGuGjvi3jHerpbYLUarhnkFPI9JhEBIW2CQ0XGHova', '2024-04-19', FALSE, 'ADMIN'),
       ('kimdoyoon12', '김도윤', '1991-11-20', '남', '504', 'kimdoyoon12@daum.net', '시스템', '팀원', '3',
        '$2a$10$37OjgDAkLCTLK8bKFiZZY.7yo65T00UmxsQDUqJnpHd24zaO8zacK', '2024-04-19', FALSE, 'ADMIN'),
       ('kimminjun34', '김민준', '1985-08-30', '남', '202', 'kimminjun34@naver.com', '운영', '부서장', '2',
        '$2a$10$axa0VVJlMxNR126tAfb.f.JthnNrMbM5u1faohjjqqKwfa36CDW4S', '2024-04-19', FALSE, 'ADMIN'),
       ('kjiy198', '김지연', '1975-05-01', '여', '100', 'kjiy198@naver.com', '마케팅', '임원', '1',
        '$2a$10$oHNzIO03/qsNEKaJw13zJuQqfMKO1csX4pOjW1oyc6oNukE82inmy', '2024-04-19', FALSE, 'ADMIN'),
       ('leejiwon88', '이지원', '1991-06-08', '여', '103', 'leejiwon88@daum.net', '마케팅', '팀원', '3',
        '$2a$10$MeoVpoiLQxASvm8pKa9Ok./ouuzRumsuzM5hJeabYJtOJnApdhIw6', '2024-04-19', FALSE, 'ADMIN'),
       ('leeseojin22', '이서진', '1980-10-30', '남', '501', 'leeseojin22@gmail.com', '시스템', '팀장', '2',
        '$2a$10$ZMZ04MUZh5GYVTJukA5XsuuqTHD6NokIDyEfnCHWXiK06sjxwWN96', '2024-04-19', FALSE, 'ADMIN'),
       ('ly2824h8', '이서연', '1978-11-20', '남', '300', 'ly2824h8@naver.com', '고객서비스', '임원', '1',
        '$2a$10$wvTAml/cIGpxMmGLamiOvOspxfCqmySIWvyQ6LYLZZGdX9rpcgBvS', '2024-04-19', FALSE, 'ADMIN'),
       ('moonjihun3', '문지훈', '1974-10-12', '남', '402', 'moonjihun3@gmail.com', '인사재무', '부서장', '2',
        '$2a$10$POqLfUoIPYYPh4oEWzVk6uQqr7Sx2cyr3cE3sROyiTumDTDWUagzy', '2024-04-19', FALSE, 'ADMIN'),
       ('ojiwon77', '오지원', '1997-07-03', '남', '204', 'ojiwon77@naver.com', '운영', '팀원', '3',
        '$2a$10$fgovX18vircQzzzEJwQVD.WPQu4SnY8anYiezfcXbIKwp96/kM7z6', '2024-04-19', FALSE, 'ADMIN'),
       ('parkjiyeon1', '박지연', '1983-04-22', '여', '102', 'parkjiyeon1@naver.com', '마케팅', '부서장', '2',
        '$2a$10$.juD4WsGTOBeL3pNqJkowuuDjmves8uzGwuZqV0C9VkM3X/BwcrdS', '2024-04-19', FALSE, 'ADMIN'),
       ('parkjunho92', '박준호', '1982-08-10', '남', '201', 'parkjunho92@naver.com', '운영', '팀장', '2',
        '$2a$10$Ri6frvYamxBsFdsOPZFAwOpJJ.KhaC7t8J8AwjR8wu5wBZO8liTE2', '2024-04-19', FALSE, 'ADMIN'),
       ('pmji37', '박민지', '1972-08-15', '여', '200', 'pmji37@naver.com', '운영', '임원', '1',
        '$2a$10$2CkSuDH/7lZRskg8.diVD.YTaYqkRFp8CQ6SRVwWdnbsvGAc683BK', '2024-04-19', FALSE, 'ADMIN'),
       ('seojiwoo23', '서지우', '1992-10-30', '남', '303', 'seojiwoo23@daum.net', '고객서비스', '팀원', '3',
        '$2a$10$OIylpLbh4xqbYAofAMV0Ru871OTOdAVCsf2NwfqA20EaNtnOmYf6m', '2024-04-19', FALSE, 'ADMIN'),
       ('sinminseo8', '신민서', '1996-04-23', '여', '304', 'sinminseo8@gmail.com', '고객서비스', '팀원', '3',
        '$2a$10$FDODUbEzinVcOJOVuHdrhu3VgfpXxTHz/DYG/Ag3zaOOOeMEx1Gd.', '2024-04-19', FALSE, 'ADMIN'),
       ('sonjimin44', '손지민', '1978-12-05', '여', '301', 'sonjimin44@naver.com', '고객서비스', '팀장', '2',
        '$2a$10$HJrx6isBbbNNROuEuKJmHe8yuZu3z4n9RgpO9IZ8FvIJ1XJXyPjyO', '2024-04-19', FALSE, 'ADMIN'),
       ('yoonseoyeon6', '윤서연', '1992-05-05', '여', '503', 'yoonseoyeon6@naver.com', '시스템', '팀원', '3',
        '$2a$10$bEAvfO9NXRelA3TVa8Un7O8BsC9lnB9138sRET0UodL8QxM8b.3yW', '2024-04-19', FALSE, 'ADMIN');

select *
from ADMIN;

USE DOSIRAK;
DROP TABLE IF EXISTS USER CASCADE;

CREATE TABLE IF NOT EXISTS USER
(
    ID         VARCHAR(20) UNIQUE NOT NULL COMMENT '회원아이디',
    NAME       VARCHAR(5)         NOT NULL COMMENT '이름',
    BIRTH      DATE               NOT NULL COMMENT '생년월일',
    GENDER     CHAR               NOT NULL COMMENT '성별',
    PHONE      VARCHAR(20)        NOT NULL COMMENT '휴대폰번호',
    EMAIL      VARCHAR(50) UNIQUE NOT NULL COMMENT '이메일',
    ADDRESS1   VARCHAR(50) COMMENT '주소1',
    ADDRESS2   VARCHAR(50) COMMENT '주소2',
    ADDRESS3   VARCHAR(50) COMMENT '주소3',
    AGREE      VARCHAR(10) COMMENT '마케팅동의',
    PWD        VARCHAR(255)       NOT NULL COMMENT '비밀번호',
    JOINDATE   DATE               NOT NULL COMMENT '가입날짜',
    WITHDRAWAL BOOLEAN            NOT NULL COMMENT '탈퇴여부'  DEFAULT FALSE,
    ROLE       VARCHAR(50)        NOT NULL COMMENT '사용자구분' DEFAULT 'USER'
) ENGINE = INNODB COMMENT '회원';

INSERT INTO USER (ID, NAME, BIRTH, GENDER, PHONE, EMAIL, ADDRESS1, ADDRESS2, ADDRESS3, AGREE, PWD, JOINDATE, WITHDRAWAL,
                  ROLE)
VALUES ('cool12', '최승현', '1990-03-29', '남', '01023456789', 'cool12@nate.com', '48058', '부산광역시 해운대구 해운대로 77', '405호',
        '문자, 이메일', '$2a$10$4XV/8bY3TLHvxJmH7h6f4.DED8JmYm3EXwLkgpvLHpsyQ/lkcI/3q', '2024-04-26', 0, 'USER'),
       ('don789', '신동우', '1982-08-17', '남', '01012345678', 'don789@naver.com', '42156', '울산광역시 중구 성남로 876', '102호',
        '문자, 이메일', '$2a$10$WRUi07pZ5xwFk69tNMjYPOh2WwN8IYTxHElHFXBuVSUfd8fW90LIW', '2024-04-30', 0, 'USER'),
       ('gaonkim44', '김가온', '1981-10-25', '여', '01098765432', 'gaonkim44@naver.com', '12345', '서울특별시 강남구 강남대로 777',
        '403호', '문자', '$2a$10$Zo1hGy2sKPDNGYgakHqm7uqVMaS994MtkhKSET68R/tfVv0mUOjc2', '2024-04-22', 0, 'USER'),
       ('gayu99', '윤가연', '1981-01-15', '여', '01087654321', 'gayu99@naver.com', '30123', '세종특별자치시 조치원읍 용두로 444', '303호',
        '문자, 이메일', '$2a$10$EsT/Xl4PrbvAWKNAce0QueHJC1VfwKKanDyFuMneyH6lp1rH50/qy', '2024-04-16', 0, 'USER'),
       ('haunoh98', '오하은', '1987-04-20', '여', '01087654321', 'haunoh98@gmail.com', '41234', '경기도 파주시 금릉로 666', '202호',
        '문자, 이메일', '$2a$10$UBp3TrIy5JVMXBT11G61HupaOO8jXQeuFLQ5iwYuvewd5Xuv/psOe', '2024-04-21', 0, 'USER'),
       ('hdonguk1', '한동욱', '1972-04-05', '남', '01098761234', 'hdonguk1@naver.com', '44708', '울산광역시 남구 삼산로 22', '301호',
        '이메일', '$2a$10$hLLq5mGixNMzaDkUYv93tuEGOLlJdyHrtGavimQuKvPLMr3YYOKri', '2024-04-28', 0, 'USER'),
       ('hkwang88', '곽영훈', '1989-06-07', '남', '01098765432', 'hkwang88@daum.net', '41232', '부산광역시 사하구 다대로 987', '201호',
        '문자', '$2a$10$2/cHN1FyKLw2PPNcz6L2NuF.y4n2YsD5YSzXGN6a/nieOgBkRxirG', '2024-04-25', 0, 'USER'),
       ('hohwan45', '안준호', '1992-07-19', '남', '01098765432', 'hohwan45@gmail.com', '07507', '서울특별시 강서구 양천로 9', '101호',
        '이메일', '$2a$10$H3KAxjNFvr5AjWML6WWRg.P2Bkl2Ng5qUiJ/j.ok/N3qYS861Krly', '2024-04-21', 0, 'USER'),
       ('jhyukoh10', '오준혁', '1978-03-03', '남', '01098765432', 'jhyukoh10@hanmail.net', '30123', '세종특별자치시 나성로 555',
        '202호', '이메일', '$2a$10$7o6YCbEqKSalNjXJrf/xW.PhX.P7NCxq7stBpc4FLT56XlHntYDhW', '2024-04-24', 0, 'USER'),
       ('jihlim77', '임지혜', '1979-12-08', '여', '01087654321', 'jihlim77@gmail.com', '12345', '경기도 의정부시 평화로 777', '501호',
        '문자, 이메일', '$2a$10$9PXXlo0R4MfhsxMzbceKXOiEi16XJHreZdK5zF0bmlRVuV6/bKQcS', '2024-04-20', 0, 'USER'),
       ('jihyun1', '김지현', '1990-09-04', '여', '01087654321', 'jihyun1@daum.net', '41123', '경기도 고양시 덕양구 화정로 777', '201호',
        '문자', '$2a$10$jQb8H5rTEsebHVmdSPWUSuJCS7UCHHFAFY.JiKl1ZEYMpj64GqX7K', '2024-04-19', 0, 'USER'),
       ('jinwo21', '손진우', '1983-11-11', '남', '01034567890', 'jinwo21@daum.net', '30077', '세종특별자치시 세종로 333', '202호',
        '이메일', '$2a$10$CcIFdWxi6yHj0IRIgvpSzegG9a5a9u0HjedRLfSPu0ZVx6wObReDG', '2024-04-15', 0, 'USER'),
       ('jiwon98', '한지원', '1975-03-07', '여', '01065432187', 'jiwon98@gmail.com', '12156', '경기도 안산시 상록구 반월로 555', '102호',
        '문자', '$2a$10$OtXF19MG4v.zR/e4cheCCukgw6FJgH9pdE/oTU8fHdQVHaaIHkFbW', '2024-04-26', 0, 'USER'),
       ('jiwoo2', '최지우', '1992-06-09', '여', '01087654321', 'jiwoo2@naver.com', '60123', '부산광역시 연제구 중앙대로 111', '502호',
        '문자, 이메일', '$2a$10$hc7/0HDV11u9oawK3/06SOwhZ.vTcbuYEyUo.OiIUzpKIikXhIwK.', '2024-04-29', 0, 'USER'),
       ('jiwoon21', '곽지원', '1982-08-18', '여', '01098765432', 'jiwoon21@gmail.com', '30123', '대전광역시 중구 대종로 333', '102호',
        '문자', '$2a$10$iCyCd9gqyvPZcOXxjVWPme4w1lN1Zu6NGvDjXtK7ROj2DHqQyDy7K', '2024-04-23', 0, 'USER'),
       ('jiyo999', '백지윤', '1984-07-26', '여', '01087654321', 'jiyo999@naver.com', '61187', '부산광역시 동래구 충렬대로 111', '401호',
        '문자, 이메일', '$2a$10$N9XKTYeD7U7RnUfraF6G0.Zm9Rzk7MXQDe6DuMlVLY3iQjfrLmBaK', '2024-04-30', 0, 'USER'),
       ('jmin56', '정민석', '1985-09-07', '남', '01054321678', 'jmin56@gmail.com', '12345', '인천광역시 연수구 송도대로 123번길 8',
        '501호', '문자', '$2a$10$xkpOtLvlgjzX3xXMIMqkL.tEWz6cz.pW7F7un4ZZ9Dmquz5XSLJJe', '2024-04-19', 0, 'USER'),
       ('juaan123', '안주아', '1976-02-03', '여', '01098764567', 'juaan123@gmail.com', '41234', '경기도 안산시 단원구 고잔로 888',
        '101호', '이메일', '$2a$10$Cr1u6p2TYLkmPKW/9md8Tur5bzdzLhqCrp6pVe0E.F5HrsPlFAoUG', '2024-04-27', 0, 'USER'),
       ('junho25', '이준호', '1988-05-02', '남', '01098765432', 'junho25@naver.com', '16654', '경기도 수원시 영통구 매탄로 67번길 21',
        '201호', '문자, 이메일', '$2a$10$Cwj6cUfJhQOqm4olfmCKPOdhqkwOW9OPrao19Y6giMjfM0gwOc8PW', '2024-04-30', 0, 'USER'),
       ('jwbaek99', '백준원', '1974-11-09', '남', '01087654321', 'jwbaek99@gmail.com', '41267', '대구광역시 수성구 수성로 321', '303호',
        '문자, 이메일', '$2a$10$EvyP31rRCU8EaQeZwsXlE.d1SkomkYzZ3qEHthhSWXLWweDiOhRTq', '2024-04-20', 0, 'USER'),
       ('kmg34', '김민기', '1986-10-12', '남', '01087654321', 'kmg34@naver.com', '41167', '경기도 수원시 장안구 권광로 666', '303호',
        '문자', '$2a$10$IYuTqTbZ0wM6Co7y/wiUSOKZ9lfnr1D91Mk5PLjblRKlIuY6jvVMm', '2024-04-23', 0, 'USER'),
       ('ldongh34', '임동현', '1995-06-30', '남', '01087654321', 'ldongh34@gmail.com', '43123', '경기도 안양시 동안구 시민대로 456번길 33',
        '401호', '문자, 이메일', '$2a$10$zYqujVK4br6OjTNGLOleieL0ve3l.f7hjk.iGHJA4N/f2x/vrC90e', '2024-04-23', 0, 'USER'),
       ('mjjeon45', '전민재', '1991-12-25', '남', '01076543218', 'mjjeon45@naver.com', '42176', '인천광역시 남동구 구월로 789', '102호',
        '문자', '$2a$10$vQghXb06X0/SAqCj3lfobupIAr9lxlLv4M2uEe3ri8P/p7q1XS8D.', '2024-04-16', 0, 'USER'),
       ('seohyun3', '정서현', '1986-11-22', '여', '01043218765', 'seohyun3@gmail.com', '30276', '대전광역시 서구 둔산로 222', '101호',
        '문자', '$2a$10$16xhcpU/Uf330goHifgQauRTFtx5YFh18YBAiDM0dJFZHL6VJeUgS', '2024-04-18', 0, 'USER'),
       ('seokk67', '강준서', '1979-12-01', '남', '01067895432', 'seokk67@naver.com', '61002', '광주광역시 서구 농성로 55', '203호',
        '이메일', '$2a$10$6uZlhjFLhnR5b1PahYEDAuRAl3/VD6kPKly.Z1ZKWPcbjhv6lxFlS', '2024-04-27', 0, 'USER'),
       ('seoyun90', '박서연', '1977-05-14', '여', '01098765432', 'seoyun90@gmail.com', '40876', '인천광역시 부평구 부평대로 999',
        '202호', '문자', '$2a$10$JFwSOEGXIIpcZEUf/1HsWuHAjjxwO5KGS2MvT3aQ3Ix7tRY161TV2', '2024-04-22', 0, 'USER'),
       ('sjseoh71', '서승진', '1997-04-30', '남', '01087654321', 'sjseoh71@gmail.com', '41234', '대전광역시 동구 동서대로 234', '404호',
        '문자, 이메일', '$2a$10$onhm9uZOAitgjaOPxwMDW.ZZTEgqbDXKWzBkhL4pSTMpgSygzYWu.', '2024-04-18', 0, 'USER'),
       ('smh555', '황성민', '1987-02-14', '남', '01043218765', 'smh555@naver.com', '05571', '서울 송파구 올림픽로 8', '102호', '문자',
        '$2a$10$Zi3490XOo9wPuNhqU0r63eiG/50WVvgzDoxxd2NHXu5e5HHHkZa6C', '2024-04-22', 0, 'USER'),
       ('soomi22', '강수민', '1996-07-31', '여', '01098765432', 'soomi22@hanmail.net', '61187', '울산광역시 북구 화봉로 333', '401호',
        '문자, 이메일', '$2a$10$DQ6jCm8qLxBZSEzAj0gz1eus/rGJSEpaACC1Fpn3NxS6ByGBIqZKy', '2024-04-27', 0, 'USER'),
       ('soyhwang8', '황소연', '1994-10-02', '여', '01012345678', 'soyhwang8@daum.net', '41123', '경기도 시흥시 마유로 888', '302호',
        '문자, 이메일', '$2a$10$fe1PrzJI4bE/1qLHKIQM2.hGv0//nHK6ec6b.RPi5LYUIfFPDZHLS', '2024-04-17', 0, 'USER'),
       ('starry2', '김성우', '1993-07-15', '남', '01012345678', 'starry2@gmail.com', '06133', '서울 강남구 테헤란로 123번길 45',
        '101호', '문자', '$2a$10$1a95mXsTFpRtOLjA6oScj.402sx9BrIOe0LyhBXAWJFDNYZKPK8te', '2024-04-21', 0, 'USER'),
       ('subini34', '전수빈', '1993-05-03', '여', '01098761234', 'subini34@daum.net', '40123', '인천광역시 서구 연희로 222', '201호',
        '이메일', '$2a$10$JqMzek9dU1ZBn9cR416WvOtf9QK5kqbVQ25wmJ62N4Tedey7oLQsC', '2024-04-29', 0, 'USER'),
       ('susu45', '신수아', '1976-06-27', '여', '01098765432', 'susu45@hanmail.net', '30123', '세종특별자치시 조치원읍 용두로 555',
        '102호', '이메일', '$2a$10$1igiK6Wz0l0wa3LTgTkSO.kbeZCCOUOgbH3VcWCh1gDobAPYSL5dq', '2024-04-19', 0, 'USER'),
       ('yeeun78', '이예은', '1983-02-28', '여', '01023456789', 'yeeun78@naver.com', '42156', '대구광역시 달서구 월배로 888', '404호',
        '이메일', '$2a$10$vAg8OrVbPg5tQFaA3sgbNu3snGspHZ5p6A/Pi2PinJyXsl4kSotC2', '2024-04-28', 0, 'USER'),
       ('yerin33', '서예린', '1991-03-12', '여', '01087654321', 'yerin33@naver.com', '61188', '울산광역시 울주군 온산읍 공단로 444',
        '303호', '문자, 이메일', '$2a$10$WI4.y9s5YMF60PA44/oMKOV7526TW1ulYZ/W6SniI.et9pb4HNkRK', '2024-04-18', 0, 'USER'),
       ('yjpark11', '박영준', '1976-10-18', '남', '01087654321', 'yjpark11@daum.net', '41967', '대구광역시 중구 국채보상로 100', '302호',
        '문자', '$2a$10$E5jA67iWnaIwO4G4BLEUZOlOGO5mdrAlr0DNWadHd1d9GGIAq6mAi', '2024-04-29', 0, 'USER'),
       ('yjy987', '윤준영', '1998-08-23', '남', '01087654321', 'yjy987@hanmail.net', '34119', '대전광역시 유성구 대학로 145', '102호',
        '문자', '$2a$10$Rtdhzwbd6gWYOJAiA5wmQuIY9wW7nZQq7lIog.ZQtCu72ym/GeFW6', '2024-04-24', 0, 'USER'),
       ('yoons22', '조윤서', '1999-08-11', '여', '01098765432', 'yoons22@gmail.com', '41256', '대구광역시 남구 중앙대로 999', '103호',
        '문자', '$2a$10$k077g9Hio5fJzfpx6BeIrek5XmkpZf0OND6Q4CVbNANHHRwALcVZK', '2024-04-25', 0, 'USER'),
       ('young876', '조영호', '1980-01-20', '남', '01098765432', 'young876@hanmail.net', '41235', '경기도 고양시 일산동구 호수로 567',
        '205호', '문자', '$2a$10$c8.9Ts6Wok7zsOTQj/jX3uCy3EqPYmpUoIYwEONRSn.s22JHFfkBq', '2024-04-17', 0, 'USER'),
       ('yujin56', '손유진', '1988-04-17', '여', '01098765432', 'yujin56@naver.com', '03083', '서울특별시 종로구 창경궁로 666', '201호',
        '문자', '$2a$10$fF9Wzfku0MzKHzIo56U0quvn3sCQNu0CSf9kzHBptsVOp3CTqqOva', '2024-04-15', 0, 'USER');

select *
from USER;
CREATE TABLE IF NOT EXISTS `CART` (
                                      `CARTITEM_COUNT` INT NOT NULL COMMENT '장바구니에 담긴 상품의 수량',
                                      `ID` VARCHAR(20) NOT NULL COMMENT '사용자 ID',
                                      `PRODUCT_CODE` INT COMMENT '상품 코드',
                                      `SUITBOX_CODE` INT COMMENT '맞춤 상품 코드',
                                      FOREIGN KEY (`ID`) REFERENCES `USER`(`ID`),
                                      FOREIGN KEY (`PRODUCT_CODE`) REFERENCES `tbl_product`(`PRODUCT_CODE`)
) COMMENT '장바구니';

CREATE TABLE IF NOT EXISTS `ORDER` (
                                       `ORDER_CODE` INT PRIMARY KEY AUTO_INCREMENT COMMENT '주문 코드',
                                       `ORDER_STATUS` VARCHAR(1) CHECK(`ORDER_STATUS` IN ('O', 'X', 'C')) NOT NULL COMMENT '주문 상태',
                                       `ID` VARCHAR(20) NOT NULL COMMENT '사용자 ID',
                                       `ORDER_RECIPIENT` VARCHAR(5) COMMENT '수령인',
                                       `ORDER_CONTACT` VARCHAR(11) COMMENT '주문자 연락처',
                                       `ORDER_ADDRESS` VARCHAR(100) COMMENT '주문자 주소',
                                       FOREIGN KEY (`ID`) REFERENCES `USER`(`ID`)
)AUTO_INCREMENT = 30003001 COMMENT '주문';
-- 완료 O: Completed
-- 취소 X: Canceled
-- 확정 C: Confirmed Purchase

CREATE TABLE IF NOT EXISTS `PAY` (
                                     `ORDER_CODE` INT NOT NULL COMMENT '주문 코드',
                                     `PAY_PRICE` INT NOT NULL COMMENT '결제 가격',
                                     `PAY_DATE` DATE NOT NULL COMMENT '결제 일자',
                                     `PAY_STATUS` VARCHAR(1) CHECK(`PAY_STATUS` IN ('O', 'F', 'X')) COMMENT '결제 상태',
                                     `PAY_METHOD` VARCHAR(7) NOT NULL COMMENT '결제 수단',
                                     FOREIGN KEY (`ORDER_CODE`) REFERENCES `ORDER`(`ORDER_CODE`)
) COMMENT '결제';
-- 완료 O: Completed
-- 실패 F: Failed
-- 취소 X: Canceled

CREATE TABLE IF NOT EXISTS `REFUND` (
                                        `REFUND_CODE` INT PRIMARY KEY AUTO_INCREMENT COMMENT '환불 코드',
                                        `ORDER_CODE` INT NOT NULL COMMENT '주문 코드',
                                        `REFUND_PRICE` INT NOT NULL COMMENT '환불 가격',
                                        `REFUND_DATE` DATE NOT NULL COMMENT '환불 일자',
                                        `REFUND_REASON` VARCHAR(200) COMMENT '환불 이유',
                                        `REFUND_STATUS` VARCHAR(1) DEFAULT 'R' CHECK( `REFUND_STATUS` IN ('R', 'A', 'D')) COMMENT '환불 상태',
                                        FOREIGN KEY (`ORDER_CODE`) REFERENCES `ORDER`(`ORDER_CODE`)
)AUTO_INCREMENT = 40004001 COMMENT '환불';
-- 환불요청 R: Refund Request
-- 환불처리중 P: Processing
-- 환불승인 A: Approved
-- 환불거부 D: Denied

CREATE TABLE IF NOT EXISTS `DELIVERY` (
                                          `ORDER_CODE` INT NOT NULL COMMENT '주문 코드',
                                          `DELIVERY_CODE` INT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '배송 코드',
                                          `DELIVERY_STATUS` VARCHAR(7) NOT NULL COMMENT '배송 상태',
                                          FOREIGN KEY (`ORDER_CODE`) REFERENCES `ORDER`(`ORDER_CODE`)
)AUTO_INCREMENT = 50005001 COMMENT '배송';

CREATE TABLE IF NOT EXISTS `DETAIL` (
                                        `DETAIL_CODE` INT AUTO_INCREMENT PRIMARY KEY COMMENT '상세 주문 코드',
                                        `DETAIL_STATUS` VARCHAR(1) DEFAULT 'O' CHECK( `DETAIL_STATUS` IN ('O', 'X')) COMMENT '주문 상세 상태',
                                        `DETAILITEM_COUNT` INT NOT NULL COMMENT '상세 주문 수량',
                                        `DETAILITEM_PRODUCT_CODE` INT COMMENT '상세 상품 코드',
                                        `DETAILITEM_SUITBOX_CODE` INT COMMENT '상세 맞춤 상품 코드',
                                        `ORDER_CODE` INT NOT NULL COMMENT '주문 코드',
                                        FOREIGN KEY (`DETAILITEM_PRODUCT_CODE`) REFERENCES `tbl_product`(`PRODUCT_CODE`),
                                        FOREIGN KEY (`ORDER_CODE`) REFERENCES `ORDER`(`ORDER_CODE`)
)AUTO_INCREMENT = 60006001 COMMENT '주문상세';
-- 완료 O: Complete
-- 취소 X: Canceled

CREATE TABLE IF NOT EXISTS `IMG` (
                                     `IMG_CODE` INT AUTO_INCREMENT PRIMARY KEY COMMENT '이미지 코드',
                                     `IMG_URL` VARCHAR(20) COMMENT '이미지 경로',
                                     `REFUND_CODE` INT COMMENT '환불 코드',
                                     FOREIGN KEY (`REFUND_CODE`) REFERENCES `REFUND`(`REFUND_CODE`)
)AUTO_INCREMENT = 70007001 COMMENT '이미지 파일';

INSERT INTO `ORDER` (`ORDER_STATUS`, `ID`)
VALUES
    ("O", "starry2"),
    ("O", "junho25"),
    ("C", "hanan85");

INSERT INTO `PAY`
VALUES
    (30003001, 42500, '2024-01-11', 'O', "카카오페이"),
    (30003002, 300000, '2023-11-10', 'O', "카카오페이"),
    (30003003, 33000, '2024-04-12', 'O', "카카오페이");

INSERT INTO `REFUND` (`ORDER_CODE`, `REFUND_PRICE`, `REFUND_DATE`, `REFUND_REASON`, `REFUND_STATUS`)
VALUES
    (30003002, 300000, '2023-11-12', "맛없음, 퍼석퍼석함", DEFAULT);

INSERT INTO `DELIVERY` (ORDER_CODE, DELIVERY_STATUS)
VALUES
    (30003001, "배송지연"),
    (30003002, "배송취소"),
    (30003003, "배송완료");

INSERT INTO `CART` (`CARTITEM_COUNT`, `ID`, `PRODUCT_CODE`)
VALUES
    (3, "starry2", 10001001),
    (5, "starry2", 10001003),
    (50, "junho25", 10001002),
    (6, "hanan85", 10001003);

INSERT INTO `DETAIL` (`DETAIL_STATUS`, `ORDER_CODE`, `DETAILITEM_PRODUCT_CODE`, `DETAILITEM_COUNT`)
VALUES
    (DEFAULT, 30003001, 10001001, 3),
    (DEFAULT, 30003001, 10001003, 5),
    (DEFAULT, 30003002, 10001002, 50),
    (DEFAULT, 30003003, 10001003, 6);

