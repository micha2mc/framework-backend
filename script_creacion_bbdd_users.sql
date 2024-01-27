SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `usersdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `usersdb` ;

DROP TABLE IF EXISTS `usersdb`.`users`;
CREATE TABLE `users` (
	`nid` INT NOT NULL AUTO_INCREMENT,
	`username` varchar(50) NOT NULL,
	`password` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`enable` TINYINT(1) NOT NULL DEFAULT 1,
	PRIMARY KEY (`nid`),
	UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `usersdb`.`authorities`;
CREATE TABLE `authorities` (
    `nid` INT NOT NULL AUTO_INCREMENT,
    `authority` VARCHAR(45) NOT NULL UNIQUE,
    PRIMARY KEY (`nid`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `usersdb`.`reviews`;
CREATE TABLE `reviews` (
	`nid` INT NOT NULL AUTO_INCREMENT,
	`idMovie` INT NOT NULL,
	`assessment` text,
    `note` INT ,
    `date` DATE NOT NULL,
    `id_user` INT NOT NULL,
	PRIMARY KEY (`nid`, id_user),
    INDEX `fk_reviews_user_idx` (`id_user` ASC) VISIBLE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `usersdb`.`Users_has_Authorities`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `usersdb`.`users_has_authorities`;
CREATE TABLE `users_has_authorities` (
	`id_user_fk` INT NOT NULL,
	`id_authorities_fk` INT NOT NULL,
	PRIMARY KEY (`id_user_fk`,`id_authorities_fk`),
    INDEX `fk_users_has_authorities_authorities1_idx` (`id_authorities_fk` ASC) VISIBLE,
    INDEX `fk_users_has_authorities_users1_idx` (`id_user_fk` ASC) VISIBLE
) ENGINE = InnoDB;



ALTER TABLE `users_has_authorities` ADD CONSTRAINT `users_authorities_fk0` FOREIGN KEY (`id_user_fk`) REFERENCES `users`(`nid`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `users_has_authorities` ADD CONSTRAINT `users_authorities_fk1` FOREIGN KEY (`id_authorities_fk`) REFERENCES `authorities`(`nid`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `reviews` ADD CONSTRAINT `reviews_users_fk0` FOREIGN KEY (`id_user`) REFERENCES `users` (`nid`) ON DELETE CASCADE ON UPDATE CASCADE;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO usersdb.authorities (authority) VALUES ('ROLE_ADMIN');
INSERT INTO usersdb.authorities (authority) VALUES ('ROLE_USER');

INSERT INTO `usersdb`.`users` (username, password, email, enable) VALUES ('Admin', '12345', 'micha2mc@gmail.com', 1);
INSERT INTO `usersdb`.`users_has_authorities` VALUES (1, 1);




