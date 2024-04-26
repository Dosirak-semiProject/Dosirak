USE dosirak;

DROP TABLE IF EXISTS tbl_product CASCADE;
CREATE TABLE IF NOT EXISTS tbl_product(
    PRODUCT_CODE    INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PRODUCT_NAME    VARCHAR(20) UNIQUE                  NOT NULL,
    product_price   INTEGER(20)                         NOT NULL,
    product_status  VARCHAR(20)                         NOT NULL,
    product_summary VARCHAR(20)                         NOT NULL,
    product_category_code int(10) NOT NULL ,
    FOREIGN KEY (product_category_code) REFERENCES tbl_product_category(product_main_category_code)
) ENGINE = INNODB;

INSERT INTO tbl_product VALUE ('1','헬시 도시락','12000','판매중','맛난거','1');
INSERT INTO tbl_product VALUE ('2','샐러드','13000','판매중단','안맛난거','2');
INSERT INTO tbl_product VALUE ('3','닭 가슴살 도시락','1000','판매중','맛난거','9');
INSERT INTO tbl_product VALUE ('4','암 도시락','12000','판매중','맛난거','4');
INSERT INTO tbl_product VALUE ('5','혈당 도시락','12000','판매중','맛난거','7');

DROP TABLE IF EXISTS tbl_product_category CASCADE;
CREATE TABLE IF NOT EXISTS tbl_product_category(
    product_main_category_code     INT(255) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product_main_category_name     VARCHAR(20)                  NOT NULL,
    product_sub_category_code INT(255)                         ,
    FOREIGN KEY (product_sub_category_code) REFERENCES tbl_product_category (product_main_category_code)
) ENGINE = INNODB;
INSERT INTO tbl_product_category VALUES ('1','건강 도시락',null);
INSERT INTO tbl_product_category VALUES ('2','정성 도시락',null);
INSERT INTO tbl_product_category VALUES ('3','간편식',null);
INSERT INTO tbl_product_category VALUES ('4','암환자 회복식단','1');
INSERT INTO tbl_product_category VALUES ('5','신장 관리식단','1');
INSERT INTO tbl_product_category VALUES ('6','혈압 관리식단','1');
INSERT INTO tbl_product_category VALUES ('7','혈당 관리식단','1');
INSERT INTO tbl_product_category VALUES ('8','샐러드','3');
INSERT INTO tbl_product_category VALUES ('9','닭 가슴살','3');


DROP TABLE IF EXISTS tbl_detail CASCADE;
CREATE TABLE IF NOT EXISTS tbl_detail(
    detailitem_count INT(255)           NOT NULL,
    detailitem_code  VARCHAR(20) UNIQUE NOT NULL,
    suitbox_code     INT(20)            NOT NULL,
    detail_code      int(20) primary key,
    order_code       INT(12)            not null,
    FOREIGN KEY (order_code) REFERENCES tbl_order (order_code)
) ENGINE = INNODB;

DROP TABLE IF EXISTS tbl_order CASCADE;
CREATE TABLE IF NOT EXISTS tbl_order(
    order_code      INT(12) primary key NOT NULL,
    order_status    VARCHAR(5) UNIQUE   NOT NULL,
    order_recipient VARCHAR(5)          NOT NULL,
    order_contact   int(20) NOT NULL ,
    oder_address VARCHAR(100) NOT NULL ,
    user_id VARCHAR(20) not null ,
    FOREIGN KEY (user_id) REFERENCES USER (ID)
) ENGINE = INNODB;
drop table product_img;
CREATE TABLE IF NOT EXISTS PRODUCT_IMG (
                                           IMG_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '이미지 코드',
                                           PRODUCT_CODE INT COMMENT '상품 코드',
                                           SAVED_NAME VARCHAR(255) NOT NULL COMMENT '저장이름 코드',
                                           SAVE_PATH VARCHAR(255) NOT NULL COMMENT '저장 경로',
                                           FOREIGN KEY (PRODUCT_CODE) REFERENCES tbl_product(PRODUCT_CODE)
)AUTO_INCREMENT = 70007001 COMMENT '이미지 파일';




USE DOSIRAK;
DROP TABLE IF EXISTS ASK CASCADE;

CREATE TABLE IF NOT EXISTS ASK (
                                   ASK_CODE INT AUTO_INCREMENT KEY COMMENT '문의코드',
                                   ASK_TITLE VARCHAR(225) NOT NULL COMMENT '문의제목',
                                   ASK_CONTENT TEXT(500) NOT NULL COMMENT '문의내용',
                                   ASK_DATE DATE NOT NULL COMMENT '문의날짜',
                                   USER_ID VARCHAR(20) NOT NULL COMMENT '회원아이디',
                                   ASK_EDITDATE DATE COMMENT '수정일시',
                                   ASK_DELETE BOOLEAN COMMENT '삭제여부',
                                   ASK_CATEGORY_CODE INT(5) COMMENT '문의분류코드',
                                   foreign key (USER_ID) references USER (ID),
                                   foreign key (ASK_CATEGORY_CODE) references ask_category (ASK_CATEGORY_CODE)
) ENGINE=INNODB COMMENT '1대1문의';

INSERT INTO ASK (ASK_CODE, ASK_TITLE, ASK_CONTENT, ASK_DATE, USER_ID,ASK_EDITDATE, ASK_DELETE, ASK_CATEGORY_CODE) VALUES
                                                                                                         (1,'문의합니다.','문의합니다.','2024-01-01','starry2','2024-01-02',0,1);



USE DOSIRAK;
DROP TABLE IF EXISTS ASK_CATEGORY CASCADE;

CREATE TABLE IF NOT EXISTS ASK_CATEGORY (
                                            ASK_CATEGORY_CODE INT(20) PRIMARY KEY COMMENT '문의분류코드',
                                            ASK_CATEGORY_NAME VARCHAR(50) NOT NULL COMMENT '문의분류이름'
) ENGINE=INNODB COMMENT '문의분류';

insert into ask_category (ask_category_code, ask_category_name) values
                                                                    (1, '회원'),
                                                                    (2, '주문/결제'),
                                                                    (3, '배송/반품'),
                                                                    (4, '교환/취소/환불'),
                                                                    (5, '서비스/기타');

