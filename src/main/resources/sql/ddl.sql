CREATE DATABASE IF NOT EXISTS PageAnalyzer;
USE PageAnalyzer;

CREATE TABLE IF NOT EXISTS Page (
  `page_id` INTEGER AUTO_INCREMENT NOT NULL,
  `page_url` NVARCHAR(255) NOT NULL,
  PRIMARY KEY (`page_id`));

CREATE TABLE IF NOT EXISTS PageLog (
  `page_log_id` INTEGER AUTO_INCREMENT NOT NULL,
  `page_id` INTEGER NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  `ip_address` NVARCHAR(255) NOT NULL,
  `agent` NVARCHAR(255) NULL,
  PRIMARY KEY (`page_log_id`),
  FOREIGN KEY (page_id) REFERENCES Page(page_id)
);

CREATE  TABLE USERS (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE USER_ROLES (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES USERS (username));


INSERT INTO USERS(username,password,enabled)
VALUES ('baris','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO USER_ROLES (username, role)
VALUES ('baris', 'ROLE_ADMIN');

SELECT p.*, pl.*
FROM Page p
    inner join PageLog pl on p.page_id = pl.page_id
WHERE p.page_id = 7;

