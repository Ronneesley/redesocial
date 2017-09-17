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
/*inserindo categorias*/
INSERT INTO `categorias` VALUES 
(1, 'Saúde'),
(2, 'Educação'),
(3, 'Carreira'),
(4, 'Tecnologia');
/*inserindo postagens*/
INSERT INTO `postagens` VALUES 
(1,897,'Algo que goste...','2017-08-08 01:00:00',1453,1),
(2,578,'Vendo Sabonete','2016-05-05 00:00:00',1221,5),
(3,1000,'Algo que odeie...','2017-08-08 00:00:00',1999,4),
(4,980,'Saudades do Doge','2017-08-08 00:00:00',2001,1);
/*inserindo aportes*/
INSERT INTO `aportes` VALUES 
(1, 'Artigo aprovado!', 1, 4),
(2, 'Mais uma publicação', 2, 3),
(3, 'Viram isso?', 3, 2),
(4, 'Novidade!!', 4, 1);
/*inserindo artigos*/
INSERT INTO `artigos` VALUES
(1,'PORTUGUES', 'ISTOE', '2530-1123', 'JONATAS', '2017-04-16', 'INFORMATICA', 'NANODEGREE', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante. Etiam ut massa eu odio bibendum ornare nec ac leo. Suspendisse sit amet nisi pulvinar, mollis felis ut, dapibus nunc. Sed eu convallis leo. Nunc et fringilla turpis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas scelerisque scelerisque porta.', 'www.istoe.com.br', LOAD_FILE("d:/git/redesocial/banco_de_dados/dados_ficticios_para_views/imagem.jpg"), 1, 1),
(2,'PORTUGUES', 'VEJA', '2250-1003', 'JONATAS', '2017-07-10', 'INFORMATICA', 'APPS', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante. Etiam ut massa eu odio bibendum ornare nec ac leo. Suspendisse sit amet nisi pulvinar, mollis felis ut, dapibus nunc. Sed eu convallis leo. Nunc et fringilla turpis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas scelerisque scelerisque porta.', 'www.veja.com.br', LOAD_FILE("d:/git/redesocial/banco_de_dados/dados_ficticios_para_views/imagem.jpg"), 2, 2),
(3,'PORTUGUES', 'EXAME', '2125-0023', 'JONATAS', '2017-09-06', 'INFORMATICA', 'PHP', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante. Etiam ut massa eu odio bibendum ornare nec ac leo. Suspendisse sit amet nisi pulvinar, mollis felis ut, dapibus nunc. Sed eu convallis leo. Nunc et fringilla turpis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas scelerisque scelerisque porta.', 'www.exame.com.br', LOAD_FILE("d:/git/redesocial/banco_de_dados/dados_ficticios_para_views/imagem.jpg"), 3, 3),
(4,'PORTUGUES', 'REVISTA1', '8888-9999', 'JONATAS', '2017-09-15', 'INFORMATICA', 'JQUERY', 'Proin vel turpis fringilla', 'www.revista1.com.br', LOAD_FILE("d:/git/redesocial/banco_de_dados/dados_ficticios_para_views/imagem.jpg"), 1, 2),
(5,'PORTUGUES', 'REVISTA2', '9999-9999', 'JONATAS', '2017-09-15', 'INFORMATICA', 'HTML', 'Proin vel turpis fringilla', 'www.revista2.com.br', LOAD_FILE("d:/git/redesocial/banco_de_dados/dados_ficticios_para_views/imagem.jpg"), 1, 1);