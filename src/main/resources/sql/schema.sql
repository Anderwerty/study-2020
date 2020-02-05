-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bank` ;

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 ;
USE `bank` ;


DROP TABLE IF EXISTS `accounts`;
DROP TABLE IF EXISTS `users` ;

CREATE TABLE users(
`id` INT NOT NULL AUTO_INCREMENT,
`email` VARCHAR(255) NOT NULL UNIQUE,
`password` VARCHAR(255) NOT NULL UNIQUE,
`telephone_number` VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY(`id`)
);

CREATE TABLE  accounts(
`id` INT NOT NULL AUTO_INCREMENT,
`card_number` VARCHAR(255) NOT NULL UNIQUE,
`user_id` INT NOT NULL,
`money` INT NOT NULL DEFAULT 0,
PRIMARY KEY(`id`),
FOREIGN KEY (`user_id`) REFERENCES users(`id`)
);
