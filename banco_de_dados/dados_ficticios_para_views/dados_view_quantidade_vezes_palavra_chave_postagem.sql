/* Inserção de Postagens - Tabela "postagens" */
INSERT INTO `redesocial`.`postagens` (`id`, `curtidas`, `descricao`, `data`, `visualizacoes`, `usuario`) VALUES ('1', '4', 'Informática é mais!', '2017-09-10', '15', '1');
INSERT INTO `redesocial`.`postagens` (`id`, `curtidas`, `descricao`, `data`, `visualizacoes`, `usuario`) VALUES ('2', '6', 'TI comanda.', '2017-09-10', '12', '2');
INSERT INTO `redesocial`.`postagens` (`id`, `curtidas`, `descricao`, `data`, `visualizacoes`, `usuario`) VALUES ('3', '7', 'Hoje iremos falar da Informática e dos ramos de TI. Tal área é muito legal. A Informática é a melhor opção.', '2017-09-10', '2', '3');
INSERT INTO `redesocial`.`postagens` (`id`, `curtidas`, `descricao`, `data`, `visualizacoes`, `usuario`) VALUES ('4', '10', 'Adorei participar da maratona de Programação!! Show!', '2017-09-10', '50', '4');

/* Inserção de Palavras-Chave - Tabela "palavra_chave`" */
INSERT INTO `redesocial`.`palavras_chave` (`id`, `descricao`) VALUES ('1', 'Informática');
INSERT INTO `redesocial`.`palavras_chave` (`id`, `descricao`) VALUES ('2', 'TI');
INSERT INTO `redesocial`.`palavras_chave` (`id`, `descricao`) VALUES ('3', 'Programação');

/* Inserção de Palavras-Chave com suas postagens - Tabela "postagens_palavras_chave`" */
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('1', '3');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('2', '3');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('3', '3');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('4', '1');
