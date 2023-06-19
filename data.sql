CREATE DATABASE IF NOT EXISTS onboarding;

USE onboarding;

CREATE TABLE customer_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) DEFAULT '',
    username VARCHAR(255) NOT NULL,
    dob  VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    account VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Pre requisite table created for existing customers';

CREATE TABLE customer_account_overview(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    balance double(11,2) DEFAULT NULL,
    type VARCHAR(255) NOT NULL,
    account VARCHAR(255) NOT NULL,
    currency VARCHAR(255) NOT NULL,
    datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Pre requisite table created for account overview';


INSERT INTO customer_account_overview(username, balance, type, account, currency)  VALUES ("KorgS01687",1000.34,"saving","NL95XYZA1687160664","EUR");
INSERT INTO customer_account_overview(username, balance, type, account, currency)  VALUES ("DravRS1687",4000.34,"saving","BE42XYZA16871607","EUR");
INSERT INTO customer_account_overview(username, balance, type, account, currency)  VALUES ("ChauNC1687",9900.34,"saving","DE22XYZA16871674419161","EUR");

INSERT INTO customer_details(email, username, dob, gender, country, address, account, status)VALUES ("sidd.korg@gmail.com","KorgS01687","1987-04-12", "NOT_PROVIDED","NL", "21-1181CD", "NL95XYZA1687160664","ACTIVE");
INSERT INTO customer_details(email, username, dob, gender, country, address, account, status)VALUES ("rsdravid@gmail.com","DravRS1687","1992-09-24", "M","BE", "45-1312PC", "BE42XYZA16871607","ACTIVE");
INSERT INTO customer_details(email, username, dob, gender, country, address, account, status)VALUES ("nc@gmail.com","ChauNC1687", "1982-04-22", "F","DE", "1-1181GP", "DE22XYZA16871674419161","ACTIVE");