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
