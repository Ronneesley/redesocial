/*inserindo paises*/
INSERT INTO `paises` VALUES 
(1,'Brasil');
/*inserindo estados*/
INSERT INTO `estados` VALUES 
(1,'Goiás',1),
(2,'Minas Gerais',1),
(3,'Tocantins',1),
(4,'São Paulo',1);
/*inserindo cidades*/
INSERT INTO `cidades` VALUES 
(1,'Ceres',1),
(2,'Rialma',1),
(3,'Goiânia',1),
(4,'Guaxupé',2),
(5,'Jacuí',2),
(6,'Palmas',3),
(7,'Gurupi',3),
(8,'São Paulo',4),
(9,'Franca',4);
/*inserindo usuarios*/
INSERT INTO `usuarios` VALUES 
(1,'Amanda','amanda@',NULL,'lennyface','1989-01-05','F','2013-09-05 15:38:49',1,NULL,1),
(2,'Jackson','jax@',NULL,'sons','1999-01-06','M','2015-09-05 15:38:48',1,NULL,2),
(3,'Max','payne@',NULL,'painkillers','1999-09-16','M','2010-09-05 15:38:49',1,NULL,3),
(4,'Chloe','chloe@',NULL,'lis','1978-01-01','F','2017-09-05 14:36:39',1,NULL,4),
(5,'Tyler','tyler@',NULL,'fightclub','1999-10-29','M','2014-09-05 10:38:49',1,NULL,5),
(6,'João','joao@',NULL,'teste1','1999-01-06','M','2015-09-04 10:35:48',1,NULL,6),
(7,'Maria','maria@',NULL,'teste2','1998-01-06','F','2015-09-04 10:45:48',1,NULL,7),
(8,'Pedro','pedro@',NULL,'teste6','1937-04-03','M','2017-08-08 08:35:15',1,NULL,8),
(9,'Marta','marta@',NULL,'teste3','1997-04-20','F','2015-09-04 10:37:48',1,NULL,9),
(10,'José','jose@',NULL,'teste4','1997-10-25','M','2015-09-04 10:47:48',1,NULL,1),
(11,'Miriam','miriam@',NULL,'teste5','1996-12-20','F','2015-09-04 10:49:48',1,NULL,2),
(12,'Jônatas','jonatas@',NULL,'teste6','1981-09-28','M','2015-08-03 00:00:00',1,NULL,2),
(13,'Joseane','joseane@',NULL,'teste7','1982-11-01','F','2015-08-03 00:00:00',1,NULL,2),
(14,'Nice','nice@',NULL,'teste8','1979-10-05','F','2015-08-02 00:00:00',1,NULL,3),
(15,'Rone','rone',NULL,'teste9','1986-04-08','M','2015-09-05 00:00:00',1,NULL,6);
/*inserir evento*/
INSERT INTO `redesocial`.`eventos` (`id`, `nome`, `descricao`, `certificado`, `inicio`, `fim`, `responsavel`, `inicio_inscricao`, `encerramento_inscricao`, `instituicao`, `endereco`) 
VALUES ('1', 'evento01', 'evento', '1', '00-00-0000 00:00:00', '00-00-0000 00:00:00', '1', '00-00-0000 00:00:00', '00-00-0000 00:00:00', '1', 'local');
INSERT INTO `redesocial`.`eventos` (`id`, `nome`, `descricao`, `certificado`, `inicio`, `fim`, `responsavel`, `inicio_inscricao`, `encerramento_inscricao`, `instituicao`, `endereco`) 
VALUES ('2', 'evento02', 'evento', '1', '00-00-0000 00:00:00', '00-00-0000 00:00:00', '2', '00-00-0000 00:00:00', '00-00-0000 00:00:00', '1', 'local');
/*inserir instiruição*/
INSERT INTO `redesocial`.`instituicao` (`id`, `nome`, `cidade`, `usuario`, `endereco`) VALUES ('1', 'IF', '1', '1', 'IF Goiano');
/*inserir presença no evento*/
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '1');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '2');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '3');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '4');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '5');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '6');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '7');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '8');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '9');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '10');




--presenca_atividades
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '1', '10');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '10');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '3', '10');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '1', '11');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '1', '9');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '1', '7');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '1', '6');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '1', '5');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '1', '4');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '4');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '8');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '2', '7');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '2', '6');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '2', '9');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '2', '13');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '12');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '2', '11');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '3');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '5');