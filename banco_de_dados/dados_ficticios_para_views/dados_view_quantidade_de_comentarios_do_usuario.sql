/*Inserção de país*/
INSERT INTO `paises`(nome) VALUES ('EUA');
/*Inserção de Estado*/
INSERT INTO `estados`(nome,pais) VALUES ('Colorado',1),('Texas',1);
/*Inserção de Cidade*/
INSERT INTO `cidades`(nome,estado) VALUES ('Denver',1),('Houston',2),('Austin',2);
/*Inserção de usuários*/
INSERT INTO `usuarios` VALUES 
(1,'Amanda','amanda@',NULL,'lennyface','1989-01-05','F','2013-09-05 15:38:49',1,NULL,1),
(2,'Jackson','jax@',NULL,'sons','1999-01-06','M','2015-09-05 15:38:48',1,NULL,1),
(3,'Max','payne@',NULL,'painkillers','1999-09-16','M','2010-09-05 15:38:49',1,NULL,1),
(4,'Chloe','chloe@',NULL,'lis','1978-01-01','F','2017-09-05 14:36:39',1,NULL,1),
(5,'Tyler','tyler@',NULL,'fightclub','1999-10-29','M','2014-09-05 10:38:49',1,NULL,1);
/*Inserção de postagens*/
INSERT INTO `postagens` VALUES
(1,'897','Algo que goste...','2017-08-08 01:00:00','1453',1),
(2,'578','Vendo Sabonete','2016-05-05 00:00:00','1221',5),
(3,'1000','Algo que odeie...','2017-08-08 00:00:00','1999',4),
(4,'980','Saudades do Doge','2017-08-08 00:00:00','1999',1);
/*Inserção de comentarios*/
INSERT INTO `comentarios` VALUES
(1,'FIRST','29','2015-08-08 00:00:00',3,NULL),
(2,'Quase fui o First','27','2015-08-08 00:00:00',3,NULL),
(3,'Amanda? lennyface','250','2015-08-08 00:00:00',1,NULL),
(4,'Clickbait','29','2015-08-08 00:00:00',3,NULL),
(5,'É artesanal mesmo?','27','2015-08-08 00:00:00',2,NULL),
(6,'Sim, eu que produzo.','26','2015-08-08 00:00:00',2,NULL),
(7,'R.I.P.','200','2015-08-08 00:00:00',4,NULL);