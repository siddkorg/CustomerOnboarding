CREATE DATABASE IF NOT EXISTS onboarding;

USE onboarding;

CREATE TABLE customer_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) DEFAULT '',
    username VARCHAR(255) NOT NULL,
    age INT DEFAULT 0,
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
    currency VARCHAR(255) NOT NULL
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Pre requisite table created for account overview';


INSERT INTO customer_account_overview(username, balance, type, account, currency)  VALUES ("david19l",1000.34,"saving","NL68XYZA9012918502","EUR");
INSERT INTO customer_account_overview(username, balance, type, account, currency)  VALUES ("james21k",4000.34,"saving","NL42XYZA9012918502","EUR");
INSERT INTO customer_account_overview(username, balance, type, account, currency)  VALUES ("lea42o88",9900.34,"saving","NL79XYZA9012918502","EUR");

INSERT INTO customer_details(email, username, age, country, address, account, status) VALUES ("dav@xyz.com","david19l",19, "NL", "21-1181CD", "NL68XYZA9012918502","COMPLETE");
INSERT INTO customer_details(email, username, age, country, address, account, status)VALUES ("james21l@xyz.com","james21k",20,"NL", "45-1312PC", "NL42XYZA9012918502","PENDING");
INSERT INTO customer_details(email, username, age, country, address, account, status)VALUES ("lea421@xyz.com","lea42o88", 63,"NL", "1-1181GP", "NL79XYZA9012918502","COMPLETE");