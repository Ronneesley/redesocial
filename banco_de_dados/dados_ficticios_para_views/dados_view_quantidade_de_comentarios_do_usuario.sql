/*Inserção de país*/
INSERT INTO `paises`(nome) VALUES ('EUA');
/*Inserção de Estado*/
INSERT INTO `estados`(nome,pais) VALUES ('Colorado',1);
/*Inserção de Cidade*/
INSERT INTO `cidades`(nome,estado) VALUES ('Denver',1);
/*Inserção de usuários*/
INSERT INTO `usuarios` VALUES 
(1,'David','fincher@',NULL,'hollywood','1978-01-01','M','2017-09-05 14:36:39',1,NULL,1),
(2,'Marla','marla@',NULL,'mArLa','1999-01-06','F','2015-09-05 15:38:48',1,NULL,1),
(3,'Max','payne@',NULL,'batata','1999-09-16','M','2010-09-05 15:38:49',1,NULL,1),
(4,'John','mr_wick@',NULL,'pen','1989-01-05','M','2013-09-05 15:38:49',1,NULL,1),
(5,'Tyler','tyler@fc.com',NULL,'fightclub','1999-10-29','M','2014-09-05 10:38:49',1,NULL,1);
/*Inserção de postagens*/
INSERT INTO `postagens` VALUES
(1,'1000','First Rule...','2017-08-08 00:00:00','1999','1'),
(2,'897','Second Rule...','2017-08-08 01:00:00','1453','1'),
(3,'578','Vendo Sabonete','2016-05-05 00:00:00','1221','5'),
(4,'29','Painkillers S2','2015-08-08 00:00:00','199','3'),
(5,'2435','Baba Yaga','2017-08-08 10:10:10','2500','1'),
(6,'69','Você não é especial','2017-07-07 00:00:00','12321','5');
/*Inserção de comentarios*/