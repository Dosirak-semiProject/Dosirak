DROP DATABASE IF EXISTS DOSIRAK;
CREATE DATABASE DOSIRAK;

CREATE USER 'dosirak'@'%' IDENTIFIED BY 'dosirak';
GRANT ALL PRIVILEGES ON DOSIRAK.* TO 'dosirak'@'%';

show grants for 'dosirak'@'%';
