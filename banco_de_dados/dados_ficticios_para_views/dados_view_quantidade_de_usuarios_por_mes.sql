/*Inserção de país*/
INSERT INTO `paises`(nome) VALUES ('Brasil');
/*Inserção de Estado*/
INSERT INTO `estados`(nome,pais) VALUES ('Goiás',1);
/*Inserção de Cidade*/
INSERT INTO `cidades`(nome,estado) VALUES ('Itapuranga',1);
/*Inserção de 20 usuários*/
INSERT INTO `usuarios` (nome, email, senha, data_nascimento, sexo, data_cadastro, status, cidade) VALUES 
							/* 5 usuários cadastrados no mês de setembro de 2017 */
							('Daniel','qualquer','batata','1999-01-06','M','2017-09-05 15:38:37',1,1),
							('Pedro','qualquer','batata','1999-01-06','M','2017-09-05 15:38:48',1,1),
							('Augusto','qualquer','batata','1999-01-06','M','2017-09-05 15:38:49',1,1),
							('Joao','qualquer','batata','1999-01-06','M','2017-09-05 15:38:49',1,1),
							('Antonio','qualquer','batata','1999-01-06','M','2017-09-05 15:38:49',1,1),
							/* 5 usuários cadastrados no mês de agosto de 2017 */
							('Emanuel','qualquer','batata','1999-01-06','M','2017-08-05 15:38:49',1,1),
							('Igor','qualquer','batata','1999-01-06','M','2017-08-05 15:38:49',1,1),
							('Davi','qualquer','batata','1999-01-06','M','2017-08-05 15:38:49',1,1),
							('Paulo','qualquer','batata','1999-01-06','M','2017-08-05 15:38:49',1,1),
							('Wesley','qualquer','batata','1999-01-06','M','2017-08-05 15:38:50',1,1),
							/* 2 usuários cadastrados em janeiro de 2016 */
							('Salmi','qualquer','batata','1999-01-06','M','2016-01-05 15:38:50',1,1),
							('Anny','qualquer','batata','1999-01-06','M','2016-01-05 15:38:50',1,1),
							/* 2 usuários cadastrados em setembro de 2015 */
							('Lara','qualquer','batata','1999-01-06','M','2015-09-05 15:38:50',1,1),
							('Everaldo','qualquer','batata','1999-01-06','M','2015-09-05 15:38:50',1,1),
							/* 2 usuários cadastrados em setembro de 2014 */ 
							('Risia','qualquer','batata','1999-01-06','M','2014-09-05 15:38:50',1,1),
							('Gabriel','qualquer','batata','1999-01-06','M','2014-09-05 15:38:50',1,1),
							/* 4 usuários cadastrados em setembro de 2013 */
							('Ronne','qualquer','batata','1999-01-06','M','2013-09-05 15:38:50',1,1),
							('Jaqueline','qualquer','batata','1999-01-06','M','2013-09-05 15:38:50',1,1),
							('Adriano','qualquer','batata','1999-01-06','M','2013-09-05 15:38:51',1,1),
							('Rangel','qualquer','batata','1999-01-06','M','2013-09-05 15:38:51',1,1);