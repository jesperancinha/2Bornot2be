CREATE TABLE IF NOT EXISTS USERS(login VARCHAR(64) PRIMARY KEY, passwd VARCHAR(64));
CREATE TABLE IF NOT EXISTS USER_ROLES(login VARCHAR(64), role VARCHAR(32));
DELETE from USER_ROLES;
DELETE from USERS;
INSERT into USERS values('admin', 'admin');
INSERT into USER_ROLES values('admin', 'Manager');
