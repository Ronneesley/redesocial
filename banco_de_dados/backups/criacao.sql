/*
	Trata-se de um arquivo de rascunho que serve como exemplo para vocês
	Autor: Ronneesley Moura Teles, Data: 27/07/2017
*/

create database redesocial;

use redesocial;

create table usuarios(
	codigo int auto_increment primary key,
	nome varchar(100),
	email varchar(100),
	senha varchar(32)
);