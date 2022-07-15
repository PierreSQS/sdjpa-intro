DROP DATABASE IF EXISTS jt_hibernate_jpa_bookdb;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF EXISTS `bookuser`@`%`;
CREATE DATABASE IF NOT EXISTS jt_hibernate_jpa_bookdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `bookadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'bookadmin';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `jt_hibernate_jpa_bookdb`.* TO `bookadmin`@`%`;
CREATE USER IF NOT EXISTS `bookuser`@`%` IDENTIFIED WITH mysql_native_password BY 'bookuser';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `jt_hibernate_jpa_bookdb`.* TO `bookuser`@`%`;
FLUSH PRIVILEGES;