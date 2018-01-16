-- MySQL Script generated by MySQL Workbench
-- Tue Jan 16 10:51:10 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BoardRoomBooking
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BoardRoomBooking` ;

-- -----------------------------------------------------
-- Schema BoardRoomBooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BoardRoomBooking` DEFAULT CHARACTER SET utf8 ;
USE `BoardRoomBooking` ;

-- -----------------------------------------------------
-- Table `BoardRoomBooking`.`Branches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BoardRoomBooking`.`Branches` ;

CREATE TABLE IF NOT EXISTS `BoardRoomBooking`.`Branches` (
  `id` INT NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BoardRoomBooking`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BoardRoomBooking`.`Users` ;

CREATE TABLE IF NOT EXISTS `BoardRoomBooking`.`Users` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `firstName` VARCHAR(45) NULL,
  `password` VARCHAR(256) NULL,
  `branchId` INT NOT NULL,
  `isAdmin` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Users_Branches1_idx` (`branchId` ASC),
  CONSTRAINT `fk_Users_Branches1`
    FOREIGN KEY (`branchId`)
    REFERENCES `BoardRoomBooking`.`Branches` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BoardRoomBooking`.`BoardRooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BoardRoomBooking`.`BoardRooms` ;

CREATE TABLE IF NOT EXISTS `BoardRoomBooking`.`BoardRooms` (
  `id` INT NOT NULL,
  `branch_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `branch_id`),
  INDEX `fk_BoardRooms_Branches1_idx` (`branch_id` ASC),
  CONSTRAINT `fk_BoardRooms_Branches1`
    FOREIGN KEY (`branch_id`)
    REFERENCES `BoardRoomBooking`.`Branches` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BoardRoomBooking`.`BookingRequests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BoardRoomBooking`.`BookingRequests` ;

CREATE TABLE IF NOT EXISTS `BoardRoomBooking`.`BookingRequests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `room_id` INT NOT NULL,
  `status` INT NULL DEFAULT 0,
  `booking_date` DATETIME NULL,
  `hours` TIME NULL,
  `purpose` VARCHAR(256) NULL,
  INDEX `fk_Bookings_Users1_idx` (`user_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Bookings_BoardRooms1_idx` (`room_id` ASC),
  CONSTRAINT `fk_Bookings_Users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `BoardRoomBooking`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bookings_BoardRooms1`
    FOREIGN KEY (`room_id`)
    REFERENCES `BoardRoomBooking`.`BoardRooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
