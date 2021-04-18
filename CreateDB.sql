SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bond_app
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bond_app` ;

-- -----------------------------------------------------
-- Schema bond_app
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bond_app` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bond_app` ;

-- -----------------------------------------------------
-- Table `roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roles` ;

CREATE TABLE IF NOT EXISTS `roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `UK_nb4h0p6txrmfc0xbrd1kglp9t` ON `roles` (`name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `email` VARCHAR(40) NULL DEFAULT NULL,
  `name` VARCHAR(40) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `username` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `UKr43af9ap4edm43mmtq01oddj6` ON `users` (`username` ASC) VISIBLE;

CREATE UNIQUE INDEX `UK6dotkott2kjsp8vw4d0m25fb7` ON `users` (`email` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_roles` ;

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6`
    FOREIGN KEY (`role_id`)
    REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`));

CREATE INDEX `FKh8ciramu9cc9q3qcqiv4ue8a6` ON `user_roles` (`role_id` ASC) VISIBLE;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
