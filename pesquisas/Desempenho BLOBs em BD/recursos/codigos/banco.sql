CREATE SCHEMA `redesocial_teste`;
USE `redesocial_teste`;

CREATE  TABLE `redesocial_teste`.`url` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(80) NOT NULL ,
  `data` DATETIME NOT NULL ,
  `url` VARCHAR(150) NOT NULL ,
  PRIMARY KEY (`id`) );

CREATE  TABLE `redesocial_teste`.`arquivo` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(80) NOT NULL ,
  `data` DATETIME NOT NULL ,
  `arquivo` BLOB NOT NULL ,
  PRIMARY KEY (`id`) );

