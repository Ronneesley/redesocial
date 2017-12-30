/*Inserção de país*/
INSERT INTO `paises`(nome) VALUES ('EUA'),('BRA');
/*Inserção de Estado*/
INSERT INTO `estados`(nome,pais) VALUES ('Colorado',1),('Texas',1);
/*Inserção de Cidade*/
INSERT INTO `cidades`(nome,estado) VALUES ('Denver',1),('Houston',2),('Austin',2);
/*Inserção de usuários*/
/*INSERT INTO `usuarios` (id, nome, email, telefone, senha, data_nascimento, status, foto,cidade )VALUES */
INSERT INTO `usuarios` VALUES 
(1,'Chloe','chloe@',NULL,'lis','1978-01-01','F','2017-09-05 14:36:39',1,NULL,2),
(2,'Lindomar','subzero@',NULL,'subzerobrasileiro','1989-01-05','M','2013-09-05 15:38:49',1,NULL,1),
(3,'Tyler','tyler@',NULL,'fightclub','1999-10-29','M','2014-09-05 10:38:49',1,NULL,3);
/*Inserção de postagens*/
INSERT INTO `postagens` (id, curtidas, descricao, data, visualizacoes, usuario) VALUES
(1,'897','Regras','2017-08-08 01:00:00','1453',3),
(2,'578','Post Aleatorio','2016-05-05 00:00:00','1221',2);
/*Inserção de comentarios*/
INSERT INTO `comentarios` (id,descricao, curtidas,data, postagem, resposta, usuario) VALUES
(1,'A primeira regra do ... Voce nao fala sobre...','29','2015-08-08 00:00:00',1,NULL,3),
(2,'A segunda regra do ... VOCE NAO FALA SOBRE...','29','2015-08-08 00:00:00',1,NULL,3),
(3,'First','29','2015-08-08 00:00:00',2,NULL,1),
(4,'Se fosse admin, isso era ban.','29','2015-08-08 00:00:00',2,3,2),
(5,'Como nao sou, tenho que tolerar isso...','29','2015-08-08 00:00:00',2,NULL,2),
(6,'Lindomar, voce teria futuro no clube.','29','2015-08-08 00:00:00',2,NULL,3);