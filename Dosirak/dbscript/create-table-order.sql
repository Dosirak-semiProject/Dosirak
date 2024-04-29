DROP TABLE IF EXISTS DETAIL;
DROP TABLE IF EXISTS DELIVERY;
DROP TABLE IF EXISTS REFUND;
DROP TABLE IF EXISTS PAY;
DROP TABLE IF EXISTS CART;
DROP TABLE IF EXISTS SUIT_BOX;
DROP TABLE IF EXISTS MENU;
DROP TABLE IF EXISTS PRODUCT_IMG;
DROP TABLE IF EXISTS TBL_PRODUCT;
DROP TABLE IF EXISTS TBL_PRODUCT_CATEGORY;
DROP TABLE IF EXISTS `ORDER`;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS ADMIN;

CREATE TABLE IF NOT EXISTS ADMIN (
    ID VARCHAR(20) PRIMARY KEY COMMENT '관리자아이디',
    NAME VARCHAR(5) NOT NULL COMMENT '이름',
    BIRTH DATE COMMENT '생년월일',
    GENDER CHAR COMMENT '성별',
    CONTACT VARCHAR(5) COMMENT '내선번호',
    EMAIL VARCHAR(50) NOT NULL COMMENT '이메일',
    DEPARTMENT VARCHAR(10) COMMENT '부서',
    POSITION VARCHAR(10) COMMENT '직급',
    AUTHORITY CHAR NOT NULL COMMENT '권한등급' DEFAULT 3,
    PWD VARCHAR(255) UNIQUE NOT NULL COMMENT '비밀번호',
    JOINDATE DATE NOT NULL COMMENT '입사날짜',
    WITHDRAWAL BOOLEAN NOT NULL COMMENT '퇴직여부' DEFAULT FALSE,
    ROLE VARCHAR(50) NOT NULL COMMENT '사용자구분' DEFAULT 'ADMIN'
) ENGINE=INNODB COMMENT '관리자';

CREATE TABLE IF NOT EXISTS USER (
    ID VARCHAR(20) UNIQUE NOT NULL COMMENT '회원아이디',
    NAME VARCHAR(5) NOT NULL COMMENT '이름',
    BIRTH DATE NOT NULL COMMENT '생년월일',
    GENDER CHAR NOT NULL COMMENT '성별',
    PHONE VARCHAR(20) NOT NULL COMMENT '휴대폰번호',
    EMAIL VARCHAR(50) UNIQUE NOT NULL COMMENT '이메일',
    ADDRESS1 VARCHAR(50) COMMENT '주소1',
    ADDRESS2 VARCHAR(50) COMMENT '주소2',
    ADDRESS3 VARCHAR(50) COMMENT '주소3',
    AGREE VARCHAR(10) COMMENT '마케팅동의',
    PWD VARCHAR(255) NOT NULL COMMENT '비밀번호',
    JOINDATE DATE NOT NULL COMMENT '가입날짜',
    WITHDRAWAL BOOLEAN NOT NULL COMMENT '탈퇴여부' DEFAULT FALSE,
    ROLE VARCHAR(50) NOT NULL COMMENT '사용자구분' DEFAULT 'USER'
) ENGINE=INNODB COMMENT '회원';

CREATE TABLE IF NOT EXISTS `ORDER` (
    ORDER_CODE INT PRIMARY KEY AUTO_INCREMENT COMMENT '주문 코드',
    ORDER_STATUS VARCHAR(1) DEFAULT 'O' CHECK(ORDER_STATUS IN ('O', 'X', 'C')) NOT NULL COMMENT '주문 상태',
    ID VARCHAR(20) NOT NULL COMMENT '사용자 ID',
    ORDER_RECIPIENT VARCHAR(5) COMMENT '수령인',
    ORDER_CONTACT VARCHAR(11) COMMENT '주문자 연락처',
    ORDER_ADDRESS1 VARCHAR(100) COMMENT '주문자 주소1',
    ORDER_ADDRESS2 VARCHAR(100) COMMENT '주문자 주소2',
    ORDER_ADDRESS3 VARCHAR(100) COMMENT '주문자 주소3',
    FOREIGN KEY (ID) REFERENCES USER (ID)
)AUTO_INCREMENT = 30003001 COMMENT '주문';
-- 완료 O: Completed
-- 취소 X: Canceled
-- 확정 C: Confirmed Purchase

CREATE TABLE IF NOT EXISTS TBL_PRODUCT_CATEGORY(
    PRODUCT_MAIN_CATEGORY_CODE INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PRODUCT_MAIN_CATEGORY_NAME VARCHAR(20) NOT NULL,
    PRODUCT_SUB_CATEGORY_CODE INT(255),
    FOREIGN KEY (PRODUCT_SUB_CATEGORY_CODE) REFERENCES TBL_PRODUCT_CATEGORY (PRODUCT_MAIN_CATEGORY_CODE)
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS TBL_PRODUCT(
    PRODUCT_CODE INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PRODUCT_NAME VARCHAR(20) UNIQUE NOT NULL,
    PRODUCT_PRICE INTEGER(20) NOT NULL,
    PRODUCT_STATUS VARCHAR(20) NOT NULL,
    PRODUCT_SUMMARY VARCHAR(20) NOT NULL,
    PRODUCT_CATEGORY_CODE INT(10) NOT NULL ,
    FOREIGN KEY (PRODUCT_CATEGORY_CODE) REFERENCES TBL_PRODUCT_CATEGORY (PRODUCT_MAIN_CATEGORY_CODE)
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS PRODUCT_IMG (
    IMG_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '이미지 코드',
    PRODUCT_CODE INT COMMENT '상품 코드',
    SAVED_NAME VARCHAR(255) NOT NULL COMMENT '저장이름 코드',
    SAVE_PATH VARCHAR(255) NOT NULL COMMENT '저장 경로',
    FOREIGN KEY (PRODUCT_CODE) REFERENCES TBL_PRODUCT (PRODUCT_CODE)
)AUTO_INCREMENT = 70007001 COMMENT '이미지 파일';
-- 구현중

CREATE TABLE IF NOT EXISTS MENU (
    MENU_CODE INT PRIMARY KEY AUTO_INCREMENT,
    MENU_NAME VARCHAR(20) NOT NULL,
    MENU_CATEGORY ENUM ('rice','main','side','kimchi') NOT NULL,
    MENU_EXTRACASH INT NOT NULL,
    MENU_STATUS ENUM ('Y', 'S', 'N') NOT NULL,
    MENU_CARBO FLOAT NOT NULL,
    MENU_SUGAR FLOAT NOT NULL,
    MENU_PROTEIN FLOAT NOT NULL,
    MENU_FAT FLOAT NOT NULL,
    MENU_SATURATEDFAT FLOAT NOT NULL,
    MENU_TRANSFAT FLOAT NOT NULL,
    MENU_CHOLESTEROL FLOAT NOT NULL,
    MENU_NATRIUM FLOAT NOT NULL,
    MENU_CALORY INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS SUIT_BOX (
    SUITBOX_CODE INT(10) AUTO_INCREMENT PRIMARY KEY,
    RICE_CODE INT NOT NULL,
    MAIN_CODE INT NOT NULL,
    SIDE_CODE INT NOT NULL,
    KIMCHI_CODE INT NOT NULL,
    FOREIGN KEY (RICE_CODE) REFERENCES MENU (MENU_CODE),
    FOREIGN KEY (MAIN_CODE) REFERENCES MENU (MENU_CODE),
    FOREIGN KEY (SIDE_CODE) REFERENCES MENU (MENU_CODE),
    FOREIGN KEY (KIMCHI_CODE) REFERENCES MENU (MENU_CODE)
);

CREATE TABLE IF NOT EXISTS CART (
    CARTITEM_COUNT INT NOT NULL COMMENT '장바구니에 담긴 상품의 수량',
    ID VARCHAR(20) NOT NULL COMMENT '사용자 ID',
    PRODUCT_CODE INT COMMENT '상품 코드',
    SUITBOX_CODE INT COMMENT '맞춤 상품 코드',
    FOREIGN KEY (ID) REFERENCES USER(ID),
    FOREIGN KEY (PRODUCT_CODE) REFERENCES TBL_PRODUCT (PRODUCT_CODE),
    FOREIGN KEY (SUITBOX_CODE) REFERENCES SUIT_BOX (SUITBOX_CODE)
) COMMENT '장바구니';

CREATE TABLE IF NOT EXISTS PAY (
    ORDER_CODE INT NOT NULL COMMENT '주문 코드',
    PAY_PRICE INT NOT NULL COMMENT '결제 가격',
    PAY_DATE DATE NOT NULL COMMENT '결제 일자',
    PAY_STATUS VARCHAR(1) CHECK(PAY_STATUS IN ('O', 'F', 'X')) COMMENT '결제 상태',
    PAY_METHOD VARCHAR(7) NOT NULL COMMENT '결제 수단',
    FOREIGN KEY (ORDER_CODE) REFERENCES `ORDER` (ORDER_CODE)
) COMMENT '결제';
-- 완료 O: Completed
-- 실패 F: Failed
-- 취소 X: Canceled

CREATE TABLE IF NOT EXISTS REFUND (
    REFUND_CODE INT PRIMARY KEY AUTO_INCREMENT COMMENT '환불 코드',
    ORDER_CODE INT NOT NULL COMMENT '주문 코드',
    REFUND_PRICE INT NOT NULL COMMENT '환불 가격',
    REFUND_DATE DATE NOT NULL COMMENT '환불 일자',
    REFUND_REASON VARCHAR(200) COMMENT '환불 이유',
    REFUND_STATUS VARCHAR(1) DEFAULT 'R' CHECK( REFUND_STATUS IN ('R', 'A', 'D', 'P')) COMMENT '환불 상태',
    FOREIGN KEY (ORDER_CODE) REFERENCES `ORDER` (ORDER_CODE)
)AUTO_INCREMENT = 40004001 COMMENT '환불';
-- 환불요청 R: Refund Request
-- 환불처리중 P: Processing
-- 환불승인 A: Approved
-- 환불거부 D: Denied

CREATE TABLE IF NOT EXISTS DELIVERY (
    ORDER_CODE INT NOT NULL COMMENT '주문 코드',
    DELIVERY_CODE INT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '배송 코드',
    DELIVERY_STATUS VARCHAR(7) DEFAULT 'P' CHECK ( DELIVERY_STATUS IN ('P', 'I', 'C', 'D')) NOT NULL COMMENT '배송 상태',
    FOREIGN KEY (ORDER_CODE) REFERENCES `ORDER` (ORDER_CODE)
)AUTO_INCREMENT = 50005001 COMMENT '배송';
-- 배송준비중 p prepare
-- 배송중 I ing
-- 배송완료 c complete
-- 배송지연 D delay

CREATE TABLE IF NOT EXISTS DETAIL (
    DETAIL_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '상세 주문 코드',
    DETAIL_STATUS VARCHAR(1) DEFAULT 'O' CHECK( DETAIL_STATUS IN ('O', 'X')) COMMENT '주문 상세 상태',
    DETAILITEM_COUNT INT NOT NULL COMMENT '상세 주문 수량',
    PRODUCT_CODE INT COMMENT '상품 코드',
    SUITBOX_CODE INT COMMENT '맞춤 상품 코드',
    ORDER_CODE INT NOT NULL COMMENT '주문 코드',
    FOREIGN KEY (PRODUCT_CODE) REFERENCES TBL_PRODUCT (PRODUCT_CODE),
    FOREIGN KEY (SUITBOX_CODE) REFERENCES SUIT_BOX (SUITBOX_CODE),
    FOREIGN KEY (ORDER_CODE) REFERENCES `ORDER` (ORDER_CODE)
)AUTO_INCREMENT = 60006001 COMMENT '주문상세';
-- 완료 O: Complete
-- 취소 X: Canceled

INSERT INTO ADMIN (ID, NAME, BIRTH, GENDER, CONTACT, EMAIL, DEPARTMENT, POSITION, AUTHORITY, PWD, JOINDATE, WITHDRAWAL, ROLE) VALUES
    ('choijihyun7', '최지현', '1975-02-10', '여', '101', 'choijihyun7@gmail.com', '마케팅', '팀장', '2', '$2a$10$Un1IY9KPrmNH.Dc3c7dQ.e1DQTH8IZErLi4L4MCv/2SOUq0FYA4se', '2021-04-12', FALSE, 'ADMIN'),
    ('hanyeeun5', '한예은', '1998-05-25', '여', '104', 'hanyeeun5@gmail.com', '마케팅', '팀원', '3', '$2a$10$kG4kMTVOijM1yW3YaxO1sOpm/6tQ.khie7XWv.1yjLSce/y2W1dU.', '2023-10-23', FALSE, 'ADMIN'),
    ('hhwo146', '홍현우', '1970-06-30', '남', '400', 'hhwo146@naver.com', '인사재무', '임원', '1', '$2a$10$rhWYjJFJwazvWRqDBrp.Lus1t1jSCkyJthDgfBNfENX3RHyzXAite', '2020-06-07', FALSE, 'ADMIN'),
    ('hwangyunseo9', '황윤서', '1994-08-15', '여', '203', 'hwangyunseo9@daum.net', '운영', '팀원', '3', '$2a$10$BIwiyW0k6ozFwghjqRPZcetLxrHEWKlJL3A6ziHQOVWjDHJdSiJPi', '2022-04-23', FALSE, 'ADMIN'),
    ('imjunho67', '임준호', '1993-08-08', '남', '403', 'imjunho67@naver.com', '인사재무', '팀원', '3', '$2a$10$QjlGH.huZo0zxlkNeKix6OlALvHJ25Tyzo6GzvS5Sm3f7IyVYF32.', '2021-10-11', FALSE, 'ADMIN'),
    ('imseongmin82', '임성민', '1992-08-25', '남', '404', 'imseongmin82@daum.net', '인사재무', '팀원', '3', '$2a$10$dUrEbTmrjpKkdnbPluRA6eRhrjv7yHsl0WTZGcgjfUTLHY3Rc6F0u', '2021-04-23', FALSE, 'ADMIN'),
    ('jeongseongwoo14', '정성우', '1973-06-20', '남', '401', 'jeongseongwoo14@naver.com', '인사재무', '팀장', '2', '$2a$10$L.WufiCzVWsGjl.6Kx./FeOpldZuLPW46XGgPeo.FC1/SgkPAHASG', '2020-05-25', FALSE, 'ADMIN'),
    ('jeongseoyeon11', '정서연', '1985-06-15', '여', '302', 'jeongseoyeon11@gmail.com', '고객서비스', '부서장', '2', '$2a$10$b1Ew/FbLdkcKuVuv4dnqKOfgUK0u8iuRbOGYvpHLOW0m3VO7ce3S6', '2017-06-10', FALSE, 'ADMIN'),
    ('jmsevwx4', '정민서', '1976-09-25', '여', '500', 'jmsevwx4@naver.com', '시스템', '임원', '1', '$2a$10$CkgsgJ81QACem01RJv6oqekubwQbAnNX8G3JliXyqMkZFjYy7I5Qu', '2009-03-21', FALSE, 'ADMIN'),
    ('kanghaeun99', '강하은', '1983-02-15', '여', '502', 'kanghaeun99@naver.com', '시스템', '부서장', '2', '$2a$10$fROuVZ8Nh9LtGuGjvi3jHerpbYLUarhnkFPI9JhEBIW2CQ0XGHova', '2010-07-01', FALSE, 'ADMIN'),
    ('kimdoyoon12', '김도윤', '1991-11-20', '남', '504', 'kimdoyoon12@daum.net', '시스템', '팀원', '3', '$2a$10$37OjgDAkLCTLK8bKFiZZY.7yo65T00UmxsQDUqJnpHd24zaO8zacK', '2023-03-18', FALSE, 'ADMIN'),
    ('kimminjun34', '김민준', '1985-08-30', '남', '202', 'kimminjun34@naver.com', '운영', '부서장', '2', '$2a$10$axa0VVJlMxNR126tAfb.f.JthnNrMbM5u1faohjjqqKwfa36CDW4S', '2006-02-15', FALSE, 'ADMIN'),
    ('kjiy198', '김지연', '1975-05-01', '여', '100', 'kjiy198@naver.com', '마케팅', '임원', '1', '$2a$10$oHNzIO03/qsNEKaJw13zJuQqfMKO1csX4pOjW1oyc6oNukE82inmy', '2014-09-04', FALSE, 'ADMIN'),
    ('leejiwon88', '이지원', '1991-06-08', '여', '103', 'leejiwon88@daum.net', '마케팅', '팀원', '3', '$2a$10$MeoVpoiLQxASvm8pKa9Ok./ouuzRumsuzM5hJeabYJtOJnApdhIw6', '2011-01-12', FALSE, 'ADMIN'),
    ('leeseojin22', '이서진', '1980-10-30', '남', '501', 'leeseojin22@gmail.com', '시스템', '팀장', '2', '$2a$10$ZMZ04MUZh5GYVTJukA5XsuuqTHD6NokIDyEfnCHWXiK06sjxwWN96', '2010-12-10', FALSE, 'ADMIN'),
    ('ly2824h8', '이서연', '1978-11-20', '남', '300', 'ly2824h8@naver.com', '고객서비스', '임원', '1', '$2a$10$wvTAml/cIGpxMmGLamiOvOspxfCqmySIWvyQ6LYLZZGdX9rpcgBvS', '2009-11-08', FALSE, 'ADMIN'),
    ('moonjihun3', '문지훈', '1974-10-12', '남', '402', 'moonjihun3@gmail.com', '인사재무', '부서장', '2', '$2a$10$POqLfUoIPYYPh4oEWzVk6uQqr7Sx2cyr3cE3sROyiTumDTDWUagzy', '2011-09-24', FALSE, 'ADMIN'),
    ('ojiwon77', '오지원', '1997-07-03', '남', '204', 'ojiwon77@naver.com', '운영', '팀원', '3', '$2a$10$fgovX18vircQzzzEJwQVD.WPQu4SnY8anYiezfcXbIKwp96/kM7z6', '2010-01-25', FALSE, 'ADMIN'),
    ('parkjiyeon1', '박지연', '1983-04-22', '여', '102', 'parkjiyeon1@naver.com', '마케팅', '부서장', '2', '$2a$10$.juD4WsGTOBeL3pNqJkowuuDjmves8uzGwuZqV0C9VkM3X/BwcrdS', '2008-10-09', FALSE, 'ADMIN'),
    ('parkjunho92', '박준호', '1982-08-10', '남', '201', 'parkjunho92@naver.com', '운영', '팀장', '2', '$2a$10$Ri6frvYamxBsFdsOPZFAwOpJJ.KhaC7t8J8AwjR8wu5wBZO8liTE2', '2009-07-15', FALSE, 'ADMIN'),
    ('pmji37', '박민지', '1972-08-15', '여', '200', 'pmji37@naver.com', '운영', '임원', '1', '$2a$10$2CkSuDH/7lZRskg8.diVD.YTaYqkRFp8CQ6SRVwWdnbsvGAc683BK', '2011-03-21', FALSE, 'ADMIN'),
    ('seojiwoo23', '서지우', '1992-10-30', '남', '303', 'seojiwoo23@daum.net', '고객서비스', '팀원', '3', '$2a$10$OIylpLbh4xqbYAofAMV0Ru871OTOdAVCsf2NwfqA20EaNtnOmYf6m', '2010-07-19', FALSE, 'ADMIN'),
    ('sinminseo8', '신민서', '1996-04-23', '여', '304', 'sinminseo8@gmail.com', '고객서비스', '팀원', '3', '$2a$10$FDODUbEzinVcOJOVuHdrhu3VgfpXxTHz/DYG/Ag3zaOOOeMEx1Gd.', '2009-11-11', FALSE, 'ADMIN'),
    ('sonjimin44', '손지민', '1978-12-05', '여', '301', 'sonjimin44@naver.com', '고객서비스', '팀장', '2', '$2a$10$HJrx6isBbbNNROuEuKJmHe8yuZu3z4n9RgpO9IZ8FvIJ1XJXyPjyO', '2011-02-03', FALSE, 'ADMIN'),
    ('yoonseoyeon6', '윤서연', '1992-05-05', '여', '503', 'yoonseoyeon6@naver.com', '시스템', '팀원', '3', '$2a$10$bEAvfO9NXRelA3TVa8Un7O8BsC9lnB9138sRET0UodL8QxM8b.3yW', '2010-01-17', FALSE, 'ADMIN');

INSERT INTO USER (ID, NAME, BIRTH, GENDER, PHONE, EMAIL, ADDRESS1, ADDRESS2, ADDRESS3, AGREE, PWD, JOINDATE, WITHDRAWAL, ROLE) VALUES
    ('cool12', '최승현', '1990-03-29', '남', '01023456789', 'cool12@nate.com', '48058', '부산광역시 해운대구 해운대로 77', '405호', '문자, 이메일', '$2a$10$4XV/8bY3TLHvxJmH7h6f4.DED8JmYm3EXwLkgpvLHpsyQ/lkcI/3q', '2024-04-26', 0, 'USER'),
    ('don789', '신동우', '1982-08-17', '남', '01012345678', 'don789@naver.com', '42156', '울산광역시 중구 성남로 876', '102호', '문자, 이메일', '$2a$10$WRUi07pZ5xwFk69tNMjYPOh2WwN8IYTxHElHFXBuVSUfd8fW90LIW', '2024-04-30', 0, 'USER'),
    ('gaonkim44', '김가온', '1981-10-25', '여', '01098765432', 'gaonkim44@naver.com', '12345', '서울특별시 강남구 강남대로 777', '403호', '문자', '$2a$10$Zo1hGy2sKPDNGYgakHqm7uqVMaS994MtkhKSET68R/tfVv0mUOjc2', '2024-04-22', 0, 'USER'),
    ('gayu99', '윤가연', '1981-01-15', '여', '01087654321', 'gayu99@naver.com', '30123', '세종특별자치시 조치원읍 용두로 444', '303호', '문자, 이메일', '$2a$10$EsT/Xl4PrbvAWKNAce0QueHJC1VfwKKanDyFuMneyH6lp1rH50/qy', '2024-04-16', 0, 'USER'),
    ('haunoh98', '오하은', '1987-04-20', '여', '01087654321', 'haunoh98@gmail.com', '41234', '경기도 파주시 금릉로 666', '202호', '문자, 이메일', '$2a$10$UBp3TrIy5JVMXBT11G61HupaOO8jXQeuFLQ5iwYuvewd5Xuv/psOe', '2024-04-21', 0, 'USER'),
    ('hdonguk1', '한동욱', '1972-04-05', '남', '01098761234', 'hdonguk1@naver.com', '44708', '울산광역시 남구 삼산로 22', '301호', '이메일', '$2a$10$hLLq5mGixNMzaDkUYv93tuEGOLlJdyHrtGavimQuKvPLMr3YYOKri', '2024-04-28', 0, 'USER'),
    ('hkwang88', '곽영훈', '1989-06-07', '남', '01098765432', 'hkwang88@daum.net', '41232', '부산광역시 사하구 다대로 987', '201호', '문자', '$2a$10$2/cHN1FyKLw2PPNcz6L2NuF.y4n2YsD5YSzXGN6a/nieOgBkRxirG', '2024-04-25', 0, 'USER'),
    ('hohwan45', '안준호', '1992-07-19', '남', '01098765432', 'hohwan45@gmail.com', '07507', '서울특별시 강서구 양천로 9', '101호', '이메일', '$2a$10$H3KAxjNFvr5AjWML6WWRg.P2Bkl2Ng5qUiJ/j.ok/N3qYS861Krly', '2024-04-21', 0, 'USER'),
    ('jhyukoh10', '오준혁', '1978-03-03', '남', '01098765432', 'jhyukoh10@hanmail.net', '30123', '세종특별자치시 나성로 555', '202호', '이메일', '$2a$10$7o6YCbEqKSalNjXJrf/xW.PhX.P7NCxq7stBpc4FLT56XlHntYDhW', '2024-04-24', 0, 'USER'),
    ('jihlim77', '임지혜', '1979-12-08', '여', '01087654321', 'jihlim77@gmail.com', '12345', '경기도 의정부시 평화로 777', '501호', '문자, 이메일', '$2a$10$9PXXlo0R4MfhsxMzbceKXOiEi16XJHreZdK5zF0bmlRVuV6/bKQcS', '2024-04-20', 0, 'USER'),
    ('jihyun1', '김지현', '1990-09-04', '여', '01087654321', 'jihyun1@daum.net', '41123', '경기도 고양시 덕양구 화정로 777', '201호', '문자', '$2a$10$jQb8H5rTEsebHVmdSPWUSuJCS7UCHHFAFY.JiKl1ZEYMpj64GqX7K', '2024-04-19', 0, 'USER'),
    ('jinwo21', '손진우', '1983-11-11', '남', '01034567890', 'jinwo21@daum.net', '30077', '세종특별자치시 세종로 333', '202호', '이메일', '$2a$10$CcIFdWxi6yHj0IRIgvpSzegG9a5a9u0HjedRLfSPu0ZVx6wObReDG', '2024-04-15', 0, 'USER'),
    ('jiwon98', '한지원', '1975-03-07', '여', '01065432187', 'jiwon98@gmail.com', '12156', '경기도 안산시 상록구 반월로 555', '102호', '문자', '$2a$10$OtXF19MG4v.zR/e4cheCCukgw6FJgH9pdE/oTU8fHdQVHaaIHkFbW', '2024-04-26', 0, 'USER'),
    ('jiwoo2', '최지우', '1992-06-09', '여', '01087654321', 'jiwoo2@naver.com', '60123', '부산광역시 연제구 중앙대로 111', '502호', '문자, 이메일', '$2a$10$hc7/0HDV11u9oawK3/06SOwhZ.vTcbuYEyUo.OiIUzpKIikXhIwK.', '2024-04-29', 0, 'USER'),
    ('jiwoon21', '곽지원', '1982-08-18', '여', '01098765432', 'jiwoon21@gmail.com', '30123', '대전광역시 중구 대종로 333', '102호', '문자', '$2a$10$iCyCd9gqyvPZcOXxjVWPme4w1lN1Zu6NGvDjXtK7ROj2DHqQyDy7K', '2024-04-23', 0, 'USER'),
    ('jiyo999', '백지윤', '1984-07-26', '여', '01087654321', 'jiyo999@naver.com', '61187', '부산광역시 동래구 충렬대로 111', '401호', '문자, 이메일', '$2a$10$N9XKTYeD7U7RnUfraF6G0.Zm9Rzk7MXQDe6DuMlVLY3iQjfrLmBaK', '2024-04-30', 0, 'USER'),
    ('jmin56', '정민석', '1985-09-07', '남', '01054321678', 'jmin56@gmail.com', '12345', '인천광역시 연수구 송도대로 123번길 8', '501호', '문자', '$2a$10$xkpOtLvlgjzX3xXMIMqkL.tEWz6cz.pW7F7un4ZZ9Dmquz5XSLJJe', '2024-04-19', 0, 'USER'),
    ('juaan123', '안주아', '1976-02-03', '여', '01098764567', 'juaan123@gmail.com', '41234', '경기도 안산시 단원구 고잔로 888', '101호', '이메일', '$2a$10$Cr1u6p2TYLkmPKW/9md8Tur5bzdzLhqCrp6pVe0E.F5HrsPlFAoUG', '2024-04-27', 0, 'USER'),
    ('junho25', '이준호', '1988-05-02', '남', '01098765432', 'junho25@naver.com', '16654', '경기도 수원시 영통구 매탄로 67번길 21', '201호', '문자, 이메일', '$2a$10$Cwj6cUfJhQOqm4olfmCKPOdhqkwOW9OPrao19Y6giMjfM0gwOc8PW', '2024-04-30', 0, 'USER'),
    ('jwbaek99', '백준원', '1974-11-09', '남', '01087654321', 'jwbaek99@gmail.com', '41267', '대구광역시 수성구 수성로 321', '303호', '문자, 이메일', '$2a$10$EvyP31rRCU8EaQeZwsXlE.d1SkomkYzZ3qEHthhSWXLWweDiOhRTq', '2024-04-20', 0, 'USER'),
    ('kmg34', '김민기', '1986-10-12', '남', '01087654321', 'kmg34@naver.com', '41167', '경기도 수원시 장안구 권광로 666', '303호', '문자', '$2a$10$IYuTqTbZ0wM6Co7y/wiUSOKZ9lfnr1D91Mk5PLjblRKlIuY6jvVMm', '2024-04-23', 0, 'USER'),
    ('ldongh34', '임동현', '1995-06-30', '남', '01087654321', 'ldongh34@gmail.com', '43123', '경기도 안양시 동안구 시민대로 456번길 33', '401호', '문자, 이메일', '$2a$10$zYqujVK4br6OjTNGLOleieL0ve3l.f7hjk.iGHJA4N/f2x/vrC90e', '2024-04-23', 0, 'USER'),
    ('mjjeon45', '전민재', '1991-12-25', '남', '01076543218', 'mjjeon45@naver.com', '42176', '인천광역시 남동구 구월로 789', '102호', '문자', '$2a$10$vQghXb06X0/SAqCj3lfobupIAr9lxlLv4M2uEe3ri8P/p7q1XS8D.', '2024-04-16', 0, 'USER'),
    ('seohyun3', '정서현', '1986-11-22', '여', '01043218765', 'seohyun3@gmail.com', '30276', '대전광역시 서구 둔산로 222', '101호', '문자', '$2a$10$16xhcpU/Uf330goHifgQauRTFtx5YFh18YBAiDM0dJFZHL6VJeUgS', '2024-04-18', 0, 'USER'),
    ('seokk67', '강준서', '1979-12-01', '남', '01067895432', 'seokk67@naver.com', '61002', '광주광역시 서구 농성로 55', '203호', '이메일', '$2a$10$6uZlhjFLhnR5b1PahYEDAuRAl3/VD6kPKly.Z1ZKWPcbjhv6lxFlS', '2024-04-27', 0, 'USER'),
    ('seoyun90', '박서연', '1977-05-14', '여', '01098765432', 'seoyun90@gmail.com', '40876', '인천광역시 부평구 부평대로 999', '202호', '문자', '$2a$10$JFwSOEGXIIpcZEUf/1HsWuHAjjxwO5KGS2MvT3aQ3Ix7tRY161TV2', '2024-04-22', 0, 'USER'),
    ('sjseoh71', '서승진', '1997-04-30', '남', '01087654321', 'sjseoh71@gmail.com', '41234', '대전광역시 동구 동서대로 234', '404호', '문자, 이메일', '$2a$10$onhm9uZOAitgjaOPxwMDW.ZZTEgqbDXKWzBkhL4pSTMpgSygzYWu.', '2024-04-18', 0, 'USER'),
    ('smh555', '황성민', '1987-02-14', '남', '01043218765', 'smh555@naver.com', '05571', '서울 송파구 올림픽로 8', '102호', '문자', '$2a$10$Zi3490XOo9wPuNhqU0r63eiG/50WVvgzDoxxd2NHXu5e5HHHkZa6C', '2024-04-22', 0, 'USER'),
    ('soomi22', '강수민', '1996-07-31', '여', '01098765432', 'soomi22@hanmail.net', '61187', '울산광역시 북구 화봉로 333', '401호', '문자, 이메일', '$2a$10$DQ6jCm8qLxBZSEzAj0gz1eus/rGJSEpaACC1Fpn3NxS6ByGBIqZKy', '2024-04-27', 0, 'USER'),
    ('soyhwang8', '황소연', '1994-10-02', '여', '01012345678', 'soyhwang8@daum.net', '41123', '경기도 시흥시 마유로 888', '302호', '문자, 이메일', '$2a$10$fe1PrzJI4bE/1qLHKIQM2.hGv0//nHK6ec6b.RPi5LYUIfFPDZHLS', '2024-04-17', 0, 'USER'),
    ('starry2', '김성우', '1993-07-15', '남', '01012345678', 'starry2@gmail.com', '06133', '서울 강남구 테헤란로 123번길 45', '101호', '문자', '$2a$10$1a95mXsTFpRtOLjA6oScj.402sx9BrIOe0LyhBXAWJFDNYZKPK8te', '2024-04-21', 0, 'USER'),
    ('subini34', '전수빈', '1993-05-03', '여', '01098761234', 'subini34@daum.net', '40123', '인천광역시 서구 연희로 222', '201호', '이메일', '$2a$10$JqMzek9dU1ZBn9cR416WvOtf9QK5kqbVQ25wmJ62N4Tedey7oLQsC', '2024-04-29', 0, 'USER'),
    ('susu45', '신수아', '1976-06-27', '여', '01098765432', 'susu45@hanmail.net', '30123', '세종특별자치시 조치원읍 용두로 555', '102호', '이메일', '$2a$10$1igiK6Wz0l0wa3LTgTkSO.kbeZCCOUOgbH3VcWCh1gDobAPYSL5dq', '2024-04-19', 0, 'USER'),
    ('yeeun78', '이예은', '1983-02-28', '여', '01023456789', 'yeeun78@naver.com', '42156', '대구광역시 달서구 월배로 888', '404호', '이메일', '$2a$10$vAg8OrVbPg5tQFaA3sgbNu3snGspHZ5p6A/Pi2PinJyXsl4kSotC2', '2024-04-28', 0, 'USER'),
    ('yerin33', '서예린', '1991-03-12', '여', '01087654321', 'yerin33@naver.com', '61188', '울산광역시 울주군 온산읍 공단로 444', '303호', '문자, 이메일', '$2a$10$WI4.y9s5YMF60PA44/oMKOV7526TW1ulYZ/W6SniI.et9pb4HNkRK', '2024-04-18', 0, 'USER'),
    ('yjpark11', '박영준', '1976-10-18', '남', '01087654321', 'yjpark11@daum.net', '41967', '대구광역시 중구 국채보상로 100', '302호', '문자', '$2a$10$E5jA67iWnaIwO4G4BLEUZOlOGO5mdrAlr0DNWadHd1d9GGIAq6mAi', '2024-04-29', 0, 'USER'),
    ('yjy987', '윤준영', '1998-08-23', '남', '01087654321', 'yjy987@hanmail.net', '34119', '대전광역시 유성구 대학로 145', '102호', '문자', '$2a$10$Rtdhzwbd6gWYOJAiA5wmQuIY9wW7nZQq7lIog.ZQtCu72ym/GeFW6', '2024-04-24', 0, 'USER'),
    ('yoons22', '조윤서', '1999-08-11', '여', '01098765432', 'yoons22@gmail.com', '41256', '대구광역시 남구 중앙대로 999', '103호', '문자', '$2a$10$k077g9Hio5fJzfpx6BeIrek5XmkpZf0OND6Q4CVbNANHHRwALcVZK', '2024-04-25', 0, 'USER'),
    ('young876', '조영호', '1980-01-20', '남', '01098765432', 'young876@hanmail.net', '41235', '경기도 고양시 일산동구 호수로 567', '205호', '문자', '$2a$10$c8.9Ts6Wok7zsOTQj/jX3uCy3EqPYmpUoIYwEONRSn.s22JHFfkBq', '2024-04-17', 0, 'USER'),
    ('yujin56', '손유진', '1988-04-17', '여', '01098765432', 'yujin56@naver.com', '03083', '서울특별시 종로구 창경궁로 666', '201호', '문자', '$2a$10$fF9Wzfku0MzKHzIo56U0quvn3sCQNu0CSf9kzHBptsVOp3CTqqOva', '2024-04-15', 0, 'USER');

INSERT INTO `ORDER` (ORDER_STATUS, ID, ORDER_RECIPIENT, ORDER_CONTACT, ORDER_ADDRESS1, ORDER_ADDRESS2, ORDER_ADDRESS3) VALUES
    ('O', 'cool12', '최승현', '01023456789', '48058', '부산광역시 해운대구 해운대로 77', '405호'),
    ('O', 'don789', '신동우', '01012345678', '42156', '울산광역시 중구 성남로 876', '102호'),
    ('O', 'hkwang88', '곽영훈', '01098765432', '41232', '부산광역시 사하구 다대로 987', '201호'),
    ('O', 'hohwan45', '안준호', '01098765432', '07507', '서울특별시 강서구 양천로 9', '101호'),
    ('X', 'seokk67', '강준서', '01067895432', '61002', '광주광역시 서구 농성로 55', '203호'),
    ('X', 'sjseoh71', '서승진', '01087654321', '41234', '대전광역시 동구 동서대로 234', '404호'),
    ('O', 'jhyukoh10', '오준혁', '01098765432', '30123', '세종특별자치시 나성로 555', '202호'),
    ('C', 'yjpark11', '박영준', '01087654321', '41967', '대구광역시 중구 국채보상로 100', '302호'),
    ('C', 'yjy987', '윤준영', '01087654321', '34119', '대전광역시 유성구 대학로 145', '102호'),
    ('O', 'jihlim77', '임지혜', '01087654321', '12345', '경기도 의정부시 평화로 777', '501호'),
    ('O', 'jihyun1', '김지현', '01087654321', '41123', '경기도 고양시 덕양구 화정로 777', '201호'),
    ('O', 'jinwo21', '손진우', '01034567890', '30077', '세종특별자치시 세종로 333', '202호'),
    ('O', 'jiwon98', '한지원', '01065432187', '12156', '경기도 안산시 상록구 반월로 555', '102호'),
    ('O', 'jiwoo2', '최지우', '01087654321', '60123', '부산광역시 연제구 중앙대로 111', '502호'),
    ('O', 'jiwoon21', '곽지원', '01098765432', '30123', '대전광역시 중구 대종로 333', '102호'),
    ('O', 'jiyo999', '백지윤', '01087654321', '61187', '부산광역시 동래구 충렬대로 111', '401호'),
    ('O', 'jmin56', '정민석', '01054321678', '12345', '인천광역시 연수구 송도대로 123번길 8', '501호'),
    ('O', 'kmg34', '김민기', '01087654321', '41167', '경기도 수원시 장안구 권광로 666', '303호'),
    ('O', 'ldongh34', '임동현', '01087654321', '43123', '경기도 안양시 동안구 시민대로 456번길 33', '401호'),
    ('O', 'mjjeon45', '전민재', '01076543218', '42176', '인천광역시 남동구 구월로 789', '102호'),
    ('O', 'soomi22', '강수민', '01098765432', '61187', '울산광역시 북구 화봉로 333', '401호'),
    ('O', 'soyhwang8', '황소연', '01012345678', '41123', '경기도 시흥시 마유로 888', '302호'),
    ('C', 'starry2', '김성우', '01012345678', '06133', '서울 강남구 테헤란로 123번길 45', '101호'),
    ('C', 'subini34', '전수빈', '01098761234', '40123', '인천광역시 서구 연희로 222', '201호'),
    ('C', 'susu45', '신수아', '01098765432', '30123', '세종특별자치시 조치원읍 용두로 555', '102호'),
    ('O', 'juaan123', '안주아', '01098764567', '41234', '경기도 안산시 단원구 고잔로 888', '101호'),
    ('O', 'junho25', '이준호', '01098765432', '16654', '경기도 수원시 영통구 매탄로 67번길 21', '201호'),
    ('O', 'jwbaek99', '백준원', '01087654321', '41267', '대구광역시 수성구 수성로 321', '303호'),
    ('C', 'yeeun78', '이예은', '01023456789', '42156', '대구광역시 달서구 월배로 888', '404호'),
    ('C', 'yerin33', '서예린', '01087654321', '61188', '울산광역시 울주군 온산읍 공단로 444', '303호'),
    ('C', 'yoons22', '조윤서', '01098765432', '41256', '대구광역시 남구 중앙대로 999', '103호'),
    ('O', 'gaonkim44', '김가온', '01098765432', '12345', '서울특별시 강남구 강남대로 777', '403호'),
    ('O', 'gayu99', '윤가연', '01087654321', '30123', '세종특별자치시 조치원읍 용두로 444', '303호'),
    ('O', 'haunoh98', '오하은', '01087654321', '41234', '경기도 파주시 금릉로 666', '202호'),
    ('O', 'hdonguk1', '한동욱', '01098761234', '44708', '울산광역시 남구 삼산로 22', '301호'),
    ('C', 'young876', '조영호', '01098765432', '41235', '경기도 고양시 일산동구 호수로 567', '205호'),
    ('C', 'yujin56', '손유진', '01098765432', '03083', '서울특별시 종로구 창경궁로 666', '201호'),
    ('X', 'seohyun3', '정서현', '01043218765', '30276', '대전광역시 서구 둔산로 222', '101호'),
    ('X', 'seoyun90', '박서연', '01098765432', '40876', '인천광역시 부평구 부평대로 999', '202호'),
    ('X', 'jiwon98', '한지원', '01065432187', '12156', '경기도 안산시 상록구 반월로 555', '102호');

INSERT INTO TBL_PRODUCT_CATEGORY VALUES
    ('1','건강 도시락',null),
    ('2','정성 도시락',null),
    ('3','간편식',null),
    ('4','암환자 회복식단','1'),
    ('5','신장 관리식단','1'),
    ('6','혈압 관리식단','1'),
    ('7','혈당 관리식단','1'),
    ('8','샐러드','3'),
    ('9','닭 가슴살','3');

INSERT INTO TBL_PRODUCT VALUES
    ('1','헬시 도시락','12000','판매중','맛난거','1'),
    ('2','샐러드','13000','판매중단','안맛난거','2'),
    ('3','닭 가슴살 도시락','1000','판매중','맛난거','9'),
    ('4','암 도시락','12000','판매중','맛난거','4'),
    ('5','혈당 도시락','12000','판매중','맛난거','7');

INSERT INTO PRODUCT_IMG (PRODUCT_CODE, SAVED_NAME, SAVE_PATH) VALUES
    (1, '29955198-782f-490e-b3de-bdb67d2d7232.png', '/productUpload/original'),
    (2, '29955198-782f-490e-b3de-bdb67d2d7232.png', '/productUpload/original'),
    (3, '29955198-782f-490e-b3de-bdb67d2d7232.png', '/productUpload/original'),
    (4, '29955198-782f-490e-b3de-bdb67d2d7232.png', '/productUpload/original'),
    (5, '29955198-782f-490e-b3de-bdb67d2d7232.png', '/productUpload/original');

# INSERT INTO PRODUCT_IMG (PRODUCT_CODE, SAVED_NAME, SAVE_PATH) VALUES
# (1, '29955198-782f-490e-b3de-bdb67d2d7232.png', 'C:/Dosirak/original/productUpload/'),
# (2, '29955198-782f-490e-b3de-bdb67d2d7232.png', 'C:/Dosirak/original/productUpload/'),
# (3, '29955198-782f-490e-b3de-bdb67d2d7232.png', 'C:/Dosirak/original/productUpload/'),
# (4, '29955198-782f-490e-b3de-bdb67d2d7232.png', 'C:/Dosirak/original/productUpload/'),
# (5, '29955198-782f-490e-b3de-bdb67d2d7232.png', 'C:/Dosirak/original/productUpload/');

INSERT INTO MENU (MENU_NAME, MENU_CATEGORY, MENU_EXTRACASH, MENU_STATUS, MENU_CARBO, MENU_SUGAR, MENU_PROTEIN, MENU_FAT,
                  MENU_SATURATEDFAT, MENU_TRANSFAT, MENU_CHOLESTEROL, MENU_NATRIUM, MENU_CALORY) VALUES
    ('현미밥', 'rice', 0, 'Y', 40.0, 0.5, 3.0, 0.5, 0.1, 0.0, 0.0, 0.0, 200),
    ('보리밥', 'rice', 0, 'S', 45.0, 1.0, 3.5, 0.8, 0.2, 0.0, 0.0, 0.0, 220),
    ('검정콩밥', 'rice', 200, 'Y', 42.0, 0.8, 4.0, 0.6, 0.1, 0.0, 0.0, 0.0, 210),
    ('오곡밥', 'rice', 200, 'Y', 38.0, 0.7, 3.8, 0.4, 0.0, 0.0, 0.0, 0.0, 190),
    ('카무트밥', 'rice', 300, 'N', 40.0, 1.0, 3.5, 0.7, 0.1, 0.0, 0.0, 0.0, 210),
    ('기장밥', 'rice', 200, 'S', 43.0, 0.6, 4.2, 0.5, 0.1, 0.0, 0.0, 0.0, 200),
    ('귀리밥', 'rice', 200, 'S', 39.0, 0.4, 4.0, 0.5, 0.1, 0.0, 0.0, 0.0, 190),
    ('흑미밥', 'rice', 0, 'Y', 41.0, 0.6, 4.1, 0.6, 0.1, 0.0, 0.0, 0.0, 200),
    ('곤약밥', 'rice', 200, 'Y', 35.0, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 30),
    -- main 카테고리
    ('갈비찜', 'main', 500, 'Y', 20.0, 5.0, 25.0, 15.0, 5.0, 0.0, 100.0, 1000.0, 400),
    ('함박스테이크', 'main', 0, 'N', 30.0, 2.0, 20.0, 15.0, 6.0, 0.0, 90.0, 800.0, 350),
    ('닭갈비', 'main', 200, 'S', 25.0, 10.0, 30.0, 10.0, 3.0, 0.0, 80.0, 1200.0, 380),
    ('고추장 삼겹살', 'main', 500, 'Y', 15.0, 3.0, 20.0, 25.0, 10.0, 0.0, 110.0, 1500.0, 450),
    ('생선까스', 'main', 200, 'S', 35.0, 2.0, 15.0, 20.0, 5.0, 0.0, 70.0, 900.0, 380),
    ('우삼겹숙주볶음', 'main', 200, 'Y', 20.0, 5.0, 25.0, 20.0, 8.0, 0.0, 120.0, 1300.0, 420),
    ('두부감자조림', 'main', 0, 'Y', 25.0, 5.0, 10.0, 15.0, 3.0, 0.0, 60.0, 800.0, 300),
    ('살치살 새우 찹스테이크', 'main', 700, 'Y', 25.0, 2.0, 30.0, 20.0, 7.0, 0.0, 100.0, 1100.0, 430),
    ('연어 스테이크', 'main', 1000, 'N', 20.0, 3.0, 30.0, 15.0, 4.0, 0.0, 80.0, 900.0, 380),
    -- side 카테고리
    ('소고기 장조림', 'side', 300, 'N', 15.0, 5.0, 15.0, 10.0, 4.0, 0.0, 80.0, 900.0, 300),
    ('어묵 잔멸치 볶음', 'side', 0, 'S', 20.0, 3.0, 10.0, 5.0, 2.0, 0.0, 60.0, 800.0, 250),
    ('소시지 야채볶음', 'side', 200, 'S', 25.0, 2.0, 10.0, 15.0, 6.0, 0.0, 70.0, 1000.0, 320),
    ('동그랑땡', 'side', 0, 'Y', 30.0, 1.0, 15.0, 10.0, 3.0, 0.0, 50.0, 700.0, 280),
    ('호박전', 'side', 0, 'Y', 20.0, 3.0, 5.0, 10.0, 2.0, 0.0, 40.0, 600.0, 200),
    ('계란말이', 'side', 0, 'N', 10.0, 2.0, 10.0, 10.0, 2.0, 0.0, 90.0, 700.0, 250),
    ('깻잎 장아찌', 'side', 0, 'Y', 5.0, 1.0, 2.0, 5.0, 1.0, 0.0, 20.0, 300.0, 100),
    ('어묵 볶음', 'side', 0, 'Y', 25.0, 4.0, 8.0, 5.0, 2.0, 0.0, 40.0, 500.0, 220),
    ('감자채볶음', 'side', 0, 'S', 30.0, 2.0, 5.0, 10.0, 3.0, 0.0, 30.0, 400.0, 180),
    ('미나리무침', 'side', 0, 'Y', 10.0, 3.0, 3.0, 5.0, 1.0, 0.0, 20.0, 200.0, 80),
    -- kimchi 카테고리
    ('배추김치', 'kimchi', 0, 'Y', 5.0, 2.0, 1.0, 0.5, 0.2, 0.0, 0.0, 1000.0, 30),
    ('깍두기', 'kimchi', 0, 'Y', 4.0, 1.5, 0.8, 0.3, 0.1, 0.0, 0.0, 900.0, 25),
    ('오이소박이', 'kimchi', 0, 'Y', 6.0, 3.0, 1.5, 0.7, 0.3, 0.0, 0.0, 1100.0, 35),
    ('갓김치', 'kimchi', 0, 'S', 4.0, 1.0, 1.0, 0.4, 0.2, 0.0, 0.0, 950.0, 30),
    ('나박김치', 'kimchi', 0, 'S', 5.0, 2.0, 1.2, 0.6, 0.3, 0.0, 0.0, 1000.0, 30),
    ('열무김치', 'kimchi', 0, 'Y', 4.0, 1.5, 1.0, 0.5, 0.2, 0.0, 0.0, 950.0, 30),
    ('무생채', 'kimchi', 0, 'N', 3.0, 1.0, 0.8, 0.3, 0.1, 0.0, 0.0, 850.0, 20),
    ('총각김치', 'kimchi', 0, 'Y', 5.0, 2.5, 1.0, 0.5, 0.2, 0.0, 0.0, 1000.0, 30);

INSERT INTO SUIT_BOX (RICE_CODE, MAIN_CODE, SIDE_CODE, KIMCHI_CODE) VALUES
    (1, 15, 19, 34),
    (4, 12, 22, 35),
    (5, 13, 23, 32),
    (2, 12, 21, 31),
    (3, 11, 25, 36),
    (4, 17, 23, 33),
    (1, 13, 27, 34);

INSERT INTO PAY VALUES
    (30003001, 12000, '2024-04-15', 'O', '카카오페이'),
    (30003002, 13000, '2024-04-16', 'O', '신용카드'),
    (30003003, 14000, '2024-04-17', 'F', '무통장 입금'),
    (30003004, 15000, '2024-04-18', 'O', '카카오페이'),
    (30003005, 11000, '2024-04-19', 'O', '신용카드'),
    (30003006, 10000, '2024-04-20', 'O', '무통장 입금'),
    (30003007, 13000, '2024-04-21', 'F', '카카오페이'),
    (30003008, 15000, '2024-04-22', 'O', '무통장 입금'),
    (30003009, 12000, '2024-04-23', 'O', '카카오페이'),
    (30003010, 11000, '2024-04-24', 'O', '신용카드'),
    (30003011, 14000, '2024-04-25', 'O', '무통장 입금'),
    (30003012, 13000, '2024-04-26', 'O', '카카오페이'),
    (30003013, 15000, '2024-04-27', 'O', '신용카드'),
    (30003014, 11000, '2024-04-28', 'O', '무통장 입금'),
    (30003015, 14000, '2024-04-29', 'O', '카카오페이'),
    (30003016, 12000, '2024-04-30', 'O', '신용카드'),
    (30003017, 10000, '2024-05-01', 'O', '무통장 입금'),
    (30003018, 11000, '2024-05-02', 'O', '카카오페이'),
    (30003019, 15000, '2024-05-03', 'O', '신용카드'),
    (30003020, 14000, '2024-05-04', 'O', '무통장 입금'),
    (30003021, 12000, '2024-05-05', 'O', '카카오페이'),
    (30003022, 15000, '2024-05-06', 'O', '신용카드'),
    (30003023, 12000, '2024-05-07', 'O', '무통장 입금'),
    (30003024, 13000, '2024-05-08', 'O', '카카오페이'),
    (30003025, 14000, '2024-05-09', 'O', '신용카드'),
    (30003026, 12000, '2024-05-10', 'O', '무통장 입금'),
    (30003027, 15000, '2024-05-11', 'O', '카카오페이'),
    (30003028, 13000, '2024-05-12', 'O', '신용카드'),
    (30003029, 14000, '2024-05-13', 'O', '무통장 입금'),
    (30003030, 11000, '2024-05-14', 'O', '카카오페이'),
    (30003031, 12000, '2024-05-15', 'O', '신용카드'),
    (30003032, 13000, '2024-05-16', 'O', '무통장 입금'),
    (30003033, 15000, '2024-05-17', 'O', '카카오페이'),
    (30003034, 14000, '2024-05-18', 'O', '신용카드'),
    (30003035, 12000, '2024-05-19', 'O', '무통장 입금'),
    (30003036, 11000, '2024-05-20', 'O', '카카오페이'),
    (30003037, 13000, '2024-05-21', 'O', '신용카드'),
    (30003038, 14000, '2024-05-22', 'O', '무통장 입금'),
    (30003039, 12000, '2024-05-23', 'O', '카카오페이'),
    (30003040, 15000, '2024-05-24', 'O', '신용카드');

INSERT INTO REFUND VALUES
    (40004001, 30003001, 12000, '2024-04-17', '상품 불만족', 'A'),
    (40004002, 30003002, 13000, '2024-04-18', '배송 지연', 'R'),
    (40004003, 30003003, 14000, '2024-04-19', '상품 결함', 'A'),
    (40004004, 30003004, 15000, '2024-04-20', '변심', 'R'),
    (40004005, 30003005, 11000, '2024-04-21', '상품 불만족', 'A'),
    (40004006, 30003006, 10000, '2024-04-22', '배송 지연', 'R'),
    (40004007, 30003007, 13000, '2024-04-23', '상품 결함', 'A'),
    (40004008, 30003008, 15000, '2024-04-24', '변심', 'R'),
    (40004009, 30003009, 12000, '2024-04-25', '상품 불만족', 'A'),
    (40004010, 30003010, 11000, '2024-04-26', '배송 지연', 'R');

INSERT INTO DELIVERY VALUES
    (30003001, 50005001, 'P'),
    (30003002, 50005002, 'I'),
    (30003003, 50005003, 'C'),
    (30003004, 50005004, 'D'),
    (30003005, 50005005, 'P'),
    (30003006, 50005006, 'I'),
    (30003007, 50005007, 'C'),
    (30003008, 50005008, 'D'),
    (30003009, 50005009, 'P'),
    (30003010, 50005010, 'I'),
    (30003011, 50005011, 'C'),
    (30003012, 50005012, 'D'),
    (30003013, 50005013, 'P'),
    (30003014, 50005014, 'I'),
    (30003015, 50005015, 'C'),
    (30003016, 50005016, 'D'),
    (30003017, 50005017, 'P'),
    (30003018, 50005018, 'I'),
    (30003019, 50005019, 'C'),
    (30003020, 50005020, 'D'),
    (30003021, 50005021, 'P'),
    (30003022, 50005022, 'I'),
    (30003023, 50005023, 'C'),
    (30003024, 50005024, 'D'),
    (30003025, 50005025, 'P'),
    (30003026, 50005026, 'I'),
    (30003027, 50005027, 'C'),
    (30003028, 50005028, 'D'),
    (30003029, 50005029, 'P'),
    (30003030, 50005030, 'I'),
    (30003031, 50005031, 'C'),
    (30003032, 50005032, 'D'),
    (30003033, 50005033, 'P'),
    (30003034, 50005034, 'I'),
    (30003035, 50005035, 'C'),
    (30003036, 50005036, 'D'),
    (30003037, 50005037, 'P'),
    (30003038, 50005038, 'I'),
    (30003039, 50005039, 'C'),
    (30003040, 50005040, 'D');

INSERT INTO DETAIL (DETAILITEM_COUNT, DETAIL_STATUS, PRODUCT_CODE, SUITBOX_CODE, ORDER_CODE) VALUES
    (3, 'O', 1, NULL, 30003001),
    (4, 'O', 2, 1, 30003002),
    (2, 'O', 3, 2, 30003003),
    (5, 'X', 4, NULL, 30003004),
    (3, 'O', 5, 3, 30003005),
    (1, 'O', 1, 4, 30003006),
    (4, 'O', 2, NULL, 30003007),
    (2, 'X', 3, 5, 30003008),
    (5, 'O', 4, 1, 30003009),
    (3, 'X', 5, 2, 30003010),
    (2, 'O', 1, NULL, 30003011),
    (4, 'X', 2, 3, 30003012),
    (5, 'O', 3, 4, 30003013),
    (3, 'O', 4, 5, 30003014),
    (1, 'O', 5, 1, 30003015),
    (3, 'O', 1, 2, 30003016),
    (4, 'O', 2, 3, 30003017),
    (2, 'X', 3, 4, 30003018),
    (5, 'O', 4, NULL, 30003019),
    (3, 'O', 5, 1, 30003020),
    (4, 'O', 1, 2, 30003021),
    (2, 'O', 2, NULL, 30003022),
    (5, 'X', 3, 3, 30003023),
    (3, 'O', 4, 4, 30003024),
    (2, 'O', 5, NULL, 30003025),
    (4, 'X', 1, 1, 30003026),
    (3, 'O', 2, 2, 30003027),
    (1, 'O', 3, NULL, 30003028),
    (4, 'O', 4, 5, 30003029),
    (5, 'O', 5, NULL, 30003030),
    (3, 'O', 1, 4, 30003031),
    (2, 'X', 2, 5, 30003032),
    (5, 'O', 3, NULL, 30003033),
    (3, 'X', 4, 1, 30003034),
    (2, 'O', 5, 2, 30003035),
    (4, 'O', 1, NULL, 30003036),
    (5, 'O', 2, 3, 30003037),
    (3, 'O', 3, 4, 30003038),
    (2, 'O', 4, 5, 30003039),
    (4, 'X', 5, 1, 30003040);
