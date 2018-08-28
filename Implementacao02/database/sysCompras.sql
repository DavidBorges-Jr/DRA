-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sysCompras
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sysCompras
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sysCompras` DEFAULT CHARACTER SET latin1 ; 
USE `sysCompras` ;

-- -----------------------------------------------------
-- Table `sysCompras`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysCompras`.`compra` (
  `comid` INT(11) NOT NULL AUTO_INCREMENT,
  `comdata` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`comid`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sysCompras`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysCompras`.`produto` (
  `proid` INT(11) NOT NULL AUTO_INCREMENT,
  `prodescricao` VARCHAR(145) NULL DEFAULT NULL,
  `provalor` DOUBLE NULL DEFAULT NULL,
  `proqtde` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`proid`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sysCompras`.`itemcompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysCompras`.`itemcompra` (
  `itemcomid` INT(11) NOT NULL,
  `itemproid` INT(11) NOT NULL,
  `itemqtde` INT NULL,
  `itemvalordiacompra` DOUBLE NULL,
  PRIMARY KEY (`itemcomid`, `itemproid`),
  INDEX `fk_compra_has_produto_produto1_idx` (`itemproid` ASC),
  INDEX `fk_compra_has_produto_compra_idx` (`itemcomid` ASC),
  CONSTRAINT `fk_compra_has_produto_compra`
    FOREIGN KEY (`itemcomid`)
    REFERENCES `sysCompras`.`compra` (`comid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_has_produto_produto1`
    FOREIGN KEY (`itemproid`)
    REFERENCES `sysCompras`.`produto` (`proid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

