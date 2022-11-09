-- MySQL Workbench Forward Engineering
drop table post;
drop table user;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pgDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pgDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pgDB` DEFAULT CHARACTER SET utf8 ;
USE `pgDB` ;

-- -----------------------------------------------------
-- Table `pgDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pgDB`.`user` (
  `user_email` VARCHAR(50) NOT NULL,
  `user_nickname` VARCHAR(20) NOT NULL,
  `user_pw` VARCHAR(30) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_birth` DATE NOT NULL,
  `user_postCnt` INT NULL DEFAULT 0,
  `user_reportCnt` INT NULL DEFAULT 0,
  `user_public` INT NOT NULL DEFAULT 0,
  `user_mbti` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`user_email`, `user_nickname`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pgDB`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pgDB`.`post` (
  `post_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `post_contents` VARCHAR(256) NOT NULL,
  `post_likeNum` INT NULL DEFAULT 0,
  `post_refNum` INT NULL DEFAULT 0,
  `post_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`post_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `pgDB`.`user` (`user_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '		';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
