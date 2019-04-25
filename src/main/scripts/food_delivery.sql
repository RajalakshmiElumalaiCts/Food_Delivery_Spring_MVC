-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema food_delivery
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema food_delivery
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `food_delivery` DEFAULT CHARACTER SET utf8 ;
USE `food_delivery` ;

-- -----------------------------------------------------
-- Table `food_delivery`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_delivery`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(60) NULL,
  `address` TINYTEXT NULL,
  `phone` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `food_delivery`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_delivery`.`order` (
  `id` INT NOT NULL,
  `timestamp` TIMESTAMP(25) NULL,
  `price` DECIMAL(20) NULL,
  `status` VARCHAR(20) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `food_delivery`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `food_delivery`.`food_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_delivery`.`food_item` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT(1000) NULL,
  `price` DECIMAL(100) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `food_delivery`.`food_quantity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_delivery`.`food_quantity` (
  `quantity` INT NOT NULL,
  `food_item_id` INT NOT NULL,
  PRIMARY KEY (`quantity`, `food_item_id`),
  INDEX `fk_food_quantity_food_item1_idx` (`food_item_id` ASC) VISIBLE,
  CONSTRAINT `fk_food_quantity_food_item1`
    FOREIGN KEY (`food_item_id`)
    REFERENCES `food_delivery`.`food_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `food_delivery`.`food_item_has_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `food_delivery`.`food_item_has_order` (
  `food_item_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`food_item_id`, `order_id`),
  INDEX `fk_food_item_has_order_order1_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_food_item_has_order_food_item1_idx` (`food_item_id` ASC) VISIBLE,
  CONSTRAINT `fk_food_item_has_order_food_item1`
    FOREIGN KEY (`food_item_id`)
    REFERENCES `food_delivery`.`food_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_food_item_has_order_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `food_delivery`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
