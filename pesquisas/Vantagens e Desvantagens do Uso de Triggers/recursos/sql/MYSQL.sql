drop database triggers;
create database triggers;
use triggers;

-- -----------------------------------------------------
-- Table `triggers`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triggers`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(200) NOT NULL,
  `senhaUsuario` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `triggers`.`auditoriaSenha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triggers`.`auditoriaSenha` (
  `idSenha` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(200) NULL DEFAULT NULL,
  `newSenha` VARCHAR(60) NULL DEFAULT NULL,
  `oldSenha` VARCHAR(60) NULL DEFAULT NULL,
  `dataAlteracao` DATETIME NULL DEFAULT NULL,
  `hostAlteracao` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`idSenha`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TRIGGER senha_usuario 
BEFORE UPDATE ON usuario FOR EACH ROW
INSERT INTO auditoriaSenha
SET nomeUsuario = OLD.nomeUsuario,
newSenha = NEW.senhaUsuario,
oldSenha = OLD.senhaUsuario,
dataAlteracao = NOW(),
hostALteracao = SESSION_USER();