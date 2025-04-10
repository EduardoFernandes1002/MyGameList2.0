-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gamelistTEST
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gamelistTEST` ;

-- -----------------------------------------------------
-- Schema gamelistTEST
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gamelistTEST` DEFAULT CHARACTER SET utf8mb4 ;
USE `gamelistTEST` ;

-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_permissao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_permissao` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_permissao` (
  `id_permissao` INT(11) NOT NULL AUTO_INCREMENT,
  `nm_permissao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_permissao`),
  UNIQUE INDEX `nmPermissao_UNIQUE` (`nm_permissao` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_usuario` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `id_permissao` INT(11) NOT NULL,
  `nm_usuario` VARCHAR(45) NOT NULL,
  `nm_apelido` VARCHAR(30) NOT NULL,
  `ds_email` VARCHAR(200) NOT NULL,
  `ds_senha` VARCHAR(40) NOT NULL,
  `nr_telefone` INT(11) NULL DEFAULT NULL,
  `dt_nascimento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `nm_apelido_UNIQUE` (`nm_apelido` ASC) VISIBLE,
  UNIQUE INDEX `ds_email_UNIQUE` (`ds_email` ASC) VISIBLE,
  UNIQUE INDEX `nr_telefone_UNIQUE` (`nr_telefone` ASC) VISIBLE,
  INDEX `fk_T_USUARIO_T_PERMISSAO1_idx` (`id_permissao` ASC) VISIBLE,
  CONSTRAINT `fk_T_USUARIO_T_PERMISSAO1`
    FOREIGN KEY (`id_permissao`)
    REFERENCES `gamelistTEST`.`t_permissao` (`id_permissao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_desenvolvedora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_desenvolvedora` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_desenvolvedora` (
  `id_desenvolvedora` INT(11) NOT NULL AUTO_INCREMENT,
  `nm_desenvolvedora` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_desenvolvedora`),
  UNIQUE INDEX `nm_desenvolvedora_UNIQUE` (`nm_desenvolvedora` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_distribuidora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_distribuidora` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_distribuidora` (
  `id_distribuidora` INT(11) NOT NULL AUTO_INCREMENT,
  `nm_distribuidora` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_distribuidora`),
  UNIQUE INDEX `nm_distribuidora_UNIQUE` (`nm_distribuidora` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_jogo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_jogo` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_jogo` (
  `id_jogo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_distribuidora` INT(11) NOT NULL,
  `id_desenvolvedora` INT(11) NOT NULL,
  `nm_jogo` VARCHAR(200) NOT NULL,
  `ds_sinopse` TEXT NOT NULL,
  `dt_lancamento` DATE NOT NULL,
  `ds_imagem` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_jogo`),
  UNIQUE INDEX `nm_jogo_UNIQUE` (`nm_jogo` ASC) VISIBLE,
  UNIQUE INDEX `ds_imagem_UNIQUE` (`ds_imagem` ASC) VISIBLE,
  INDEX `fk_T_JOGO_T_DISTRIBUIDORA1_idx` (`id_distribuidora` ASC) VISIBLE,
  INDEX `fk_T_JOGO_T_DESENVOLVEDORA1_idx` (`id_desenvolvedora` ASC) VISIBLE,
  CONSTRAINT `fk_T_JOGO_T_DESENVOLVEDORA1`
    FOREIGN KEY (`id_desenvolvedora`)
    REFERENCES `gamelistTEST`.`t_desenvolvedora` (`id_desenvolvedora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_T_DISTRIBUIDORA1`
    FOREIGN KEY (`id_distribuidora`)
    REFERENCES `gamelistTEST`.`t_distribuidora` (`id_distribuidora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_avaliacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_avaliacao` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_avaliacao` (
  `id_avaliacao` INT(11) NOT NULL AUTO_INCREMENT,
  `id_jogo` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `tx_comentario` TEXT NULL DEFAULT NULL,
  `nr_usuario_nota` DECIMAL(3,1) NOT NULL,
  `dt_comentario` DATE NULL,
  `dt_envio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_avaliacao`),
  CONSTRAINT `t_avaliacao_ibfk_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gamelistTEST`.`t_usuario` (`id_usuario`),
  CONSTRAINT `t_avaliacao_ibfk_4`
    FOREIGN KEY (`id_jogo`)
    REFERENCES `gamelistTEST`.`t_jogo` (`id_jogo`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_genero`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_genero` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_genero` (
  `id_genero` INT(11) NOT NULL AUTO_INCREMENT,
  `nm_genero` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_genero`),
  UNIQUE INDEX `nm_genero_UNIQUE` (`nm_genero` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_genero_do_jogo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_genero_do_jogo` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_genero_do_jogo` (
  `id_jogo` INT(11) NOT NULL,
  `id_genero` INT(11) NOT NULL,
  PRIMARY KEY (`id_jogo`, `id_genero`),
  INDEX `fk_T_JOGO_has_T_GENERO_T_GENERO1_idx` (`id_genero` ASC) VISIBLE,
  INDEX `fk_T_JOGO_has_T_GENERO_T_JOGO1_idx` (`id_jogo` ASC) VISIBLE,
  CONSTRAINT `fk_T_JOGO_has_T_GENERO_T_GENERO1`
    FOREIGN KEY (`id_genero`)
    REFERENCES `gamelistTEST`.`t_genero` (`id_genero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_has_T_GENERO_T_JOGO1`
    FOREIGN KEY (`id_jogo`)
    REFERENCES `gamelistTEST`.`t_jogo` (`id_jogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_lista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_lista` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_lista` (
  `id_lista` INT(11) NOT NULL AUTO_INCREMENT,
  `nr_jogos` INT(11) NOT NULL,
  `nm_lista` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_lista`),
  UNIQUE INDEX `nm_lista_UNIQUE` (`nm_lista` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_modo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_modo` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_modo` (
  `id_modo` INT(11) NOT NULL AUTO_INCREMENT,
  `nm_modo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_modo`),
  UNIQUE INDEX `nm_modo_UNIQUE` (`nm_modo` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_modo_de_jogo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_modo_de_jogo` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_modo_de_jogo` (
  `id_jogo` INT(11) NOT NULL,
  `id_modo` INT(11) NOT NULL,
  PRIMARY KEY (`id_jogo`, `id_modo`),
  INDEX `fk_T_JOGO_has_T_MODO_JOGO_T_MODO_JOGO1_idx` (`id_modo` ASC) VISIBLE,
  INDEX `fk_T_JOGO_has_T_MODO_JOGO_T_JOGO1_idx` (`id_jogo` ASC) VISIBLE,
  CONSTRAINT `fk_T_JOGO_has_T_MODO_JOGO_T_JOGO1`
    FOREIGN KEY (`id_jogo`)
    REFERENCES `gamelistTEST`.`t_jogo` (`id_jogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_has_T_MODO_JOGO_T_MODO_JOGO1`
    FOREIGN KEY (`id_modo`)
    REFERENCES `gamelistTEST`.`t_modo` (`id_modo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_plataforma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_plataforma` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_plataforma` (
  `id_plataforma` INT(11) NOT NULL AUTO_INCREMENT,
  `nm_plataforma` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_plataforma`),
  UNIQUE INDEX `nm_plataforma_UNIQUE` (`nm_plataforma` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_jogo_adicionado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_jogo_adicionado` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_jogo_adicionado` (
  `id_lista` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `id_jogo` INT(11) NOT NULL,
  INDEX `fk_t_jogo_adicionado_t_lista1_idx` (`id_lista` ASC) VISIBLE,
  INDEX `fk_t_jogo_adicionado_t_usuario1_idx` (`id_usuario` ASC) VISIBLE,
  INDEX `fk_t_jogo_adicionado_t_jogo1_idx` (`id_jogo` ASC) VISIBLE,
  CONSTRAINT `fk_t_jogo_adicionado_t_lista1`
    FOREIGN KEY (`id_lista`)
    REFERENCES `gamelistTEST`.`t_lista` (`id_lista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_jogo_adicionado_t_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gamelistTEST`.`t_usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_jogo_adicionado_t_jogo1`
    FOREIGN KEY (`id_jogo`)
    REFERENCES `gamelistTEST`.`t_jogo` (`id_jogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamelistTEST`.`t_plataformas_jogaveis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gamelistTEST`.`t_plataformas_jogaveis` ;

CREATE TABLE IF NOT EXISTS `gamelistTEST`.`t_plataformas_jogaveis` (
  `id_plataforma` INT(11) NOT NULL,
  `id_jogo` INT(11) NOT NULL,
  PRIMARY KEY (`id_plataforma`, `id_jogo`),
  INDEX `fk_t_plataforma_has_t_jogo_t_jogo1_idx` (`id_jogo` ASC) VISIBLE,
  INDEX `fk_t_plataforma_has_t_jogo_t_plataforma1_idx` (`id_plataforma` ASC) VISIBLE,
  CONSTRAINT `fk_t_plataforma_has_t_jogo_t_plataforma1`
    FOREIGN KEY (`id_plataforma`)
    REFERENCES `gamelistTEST`.`t_plataforma` (`id_plataforma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_plataforma_has_t_jogo_t_jogo1`
    FOREIGN KEY (`id_jogo`)
    REFERENCES `gamelistTEST`.`t_jogo` (`id_jogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
