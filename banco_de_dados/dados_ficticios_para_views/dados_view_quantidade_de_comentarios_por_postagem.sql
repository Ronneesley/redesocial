/* Inserção de 1 usuário */ 
INSERT INTO `usuarios` (nome, email, senha, data_nascimento, sexo, data_cadastro, status, cidade) VALUES ('Daniel','qualquer','batata','1999-01-06','M','2017-09-05 15:38:37',1,1);
/* Inserção de 3 Postagens */
INSERT INTO `postagens`(curtidas, descricao, data, visualizacoes, usuario) VALUES (0, "Como ABC?", now(), 0, 1);
INSERT INTO `postagens`(curtidas, descricao, data, visualizacoes, usuario) VALUES (0, "Você viu?", now(), 0, 1);
INSERT INTO `postagens`(curtidas, descricao, data, visualizacoes, usuario) VALUES (0, "Olha isso!", now(), 0, 1);
/* Inserção de 7 comentários na postagem 1*/
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 1);
/* Inserção de 5 comentários na postagem 2 */
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 2);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 2);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 2);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 2);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 2);
/* Inserção de 10 comentários na postagem 3 */ 
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);
INSERT INTO `comentarios`(descricao, curtidas, data, postagem) VALUES ("Teste", 0, now(), 3);