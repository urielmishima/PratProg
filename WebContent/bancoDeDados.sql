-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pratprogaula02
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pratprogaula02
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pratprogaula02`;
CREATE SCHEMA IF NOT EXISTS `pratprogaula02` DEFAULT CHARACTER SET utf8 ;
USE `pratprogaula02` ;

-- -----------------------------------------------------
-- Table `pratprogaula02`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pratprogaula02`.`pais` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `populacao` BIGINT(20) NOT NULL,
  `area` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `pratprogaula02`.`usuario` (
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO pais (id, nome, populacao, area)
	VALUES
    (1, 'China', 1306313812, 9596960),
    (2, 'Rússia', 143420309, 17075200),
    (3, 'Coreia do Sul', 48422644, 98480),
    (4, 'Pitcairn', 46, 47),
    (5, 'Atol Johnston', 396, 2.8),
    (6, 'Gronelândia', 56375, 2166086);
    
INSERT INTO usuario (username, password)
	VALUES
    ('root@root', 'root');
    
    
