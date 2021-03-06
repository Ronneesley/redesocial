/*Inserindo dados na tabela de paises*/
INSERT INTO paises 
(nome) 
VALUES 
('Brasil'), 
('Argentina'),
('Estados Unidos'),
('Portugal'),
('França'),
('Espanha'),
('Russia'),
('Chile'),
('Paraguaio'),
('Uruguai'),
('Peru'),
('Venezuela'),
('Afeganistao'), 
('África do Sul'),
('Albânia'),
('Alemanha'),
('Andorra'),
('Angola'),
('Antígua e Barbuda'),
('Arábia Saudita');

/*Inserindo dados na tabela de estados*/
INSERT INTO estados
(nome, pais)
VALUES
('Texas', '3'),
('Minas Gerais', '1'),
('Santa Fé', '2'),
('São Paulo', '1'),
('Flórida', '3'),
('Cantabria', '6'),
('Goias', '1'),
('Para', '1'),
('Parana', '1'),
('Pais Vasco', '6'),
('Andalucia', '6'),
('Bahia', '1'),
('Acre', '1'),
('Alagoas', '1'),
('Amapá', '1'),
('Amazonas', '1'),
('Ceará', '1'),
('Distrito Federal', '1'),
('Espírito Santo', '1'),
('Maranhão', '1');


/*Inserindo dados na tabela de cidades*/
INSERT INTO cidades
(nome, estado)
VALUES
('Uruana', '7'),
('Austin', '1'),
('Campinas', '4'),
('Belo Horizonte', '2'),
('São Paulo', '4'),
('Laredo', '6'),
('Colindres', '6'),
('Itapuranga', '7'),
('Ceres', '7'),
('Rialma', '7'),
('Carmo do Rio Verde', '7'),
('Redencao','8'),
('Rio Branco', '13'),
('Maceió', '14'),
('Macapá', '15'),
('Manaus', '16'),
('Fortaleza', '17'),
('Brasília', '18'),
('Vitória', '19'),
('São Luís', '20');



/*Inserindo dados na tabela de usuarios*/
INSERT INTO usuarios
(nome, email, telefone, senha, data_nascimento, sexo, data_cadastro, status, cidade)
VALUES
('Luciano Borba', 'ciano@gamil.com', '992934567', '123456789', '1998-12-01', 'M', '2017-09-05 15:38:37', '1', '3'),
('Lara Caroline', 'lara@gamil.com', '996912347', 'florzinha', '1993-09-03', 'F', '2017-10-09 12:02:39', '1', '2'),
('Ianka', 'ianka@hotmail.com', '984596076', 'unicórnio', '1956-04-12', 'F', '2017-08-05 09:31:37', '1', '3'),
('josé Maria', 'jm@gamil.com', '9749484848', '850380504', '1990-10-03', 'M', '2017-03-09 11:02:39', '1', '5'),
('Naira Azevedo', 'na@gamil.com', '965456789', 'naiaraazevedo', '1993-03-15', 'F', '2017-02-09 11:02:39', '1', '4'),
('Eduardo Oliveira', 'edu@gamil.com', '918463548', '2580198', '1980-11-25', 'M', '2017-01-24', '2', '6'),
('Joao Paulo', 'pedrapf@gamil.com', '987984512', 'cibalena', '1999-12-21', 'M', '2017-05-22', '1', '7'),
('Maria', 'maria@gamil.com', '945986537', 'maria23', '1975-05-28', 'M', '2017-06-30', '2', '1'),
('Jose Antonio', 'jo_a@gamil.com', '999554698', 'caramba', '1990-10-15', 'M', '2017-02-28', '1', '2'),
('Paula', 'paula@gamil.com', '969546354', 'kkkk155', '1985-02-05', 'F', '2017-11-03', '2', '3'),
('Luciano Machado', 'machado@gamil.com', '992934561', '123456788', '1999-12-01', 'M', '2017-10-05 15:38:36', '1', '2'),
('Lara Carol', 'carol@gamil.com', '996912348', 'flor', '1993-08-03', 'F', '2017-08-09 12:02:40', '1', '3'),
('Ianka Lara', 'lara@hotmail.com', '984596078', 'unicórnia', '1956-05-12', 'F', '2017-07-05 09:31:50', '1', '2'),
('josé Mario', 'mario@gamil.com', '9749484847', '850380500', '1990-09-03', 'M', '2017-05-09 11:02:39', '1', '1'),
('Naira Maria', 'maria@gamil.com', '965456787', 'naiara', '1993-05-15', 'F', '2017-10-09 11:30:39', '1', '2'),
('Eduardo Pereira', 'pereira@gamil.com', '918463544', '2580190', '1980-05-25', 'M', '2017-06-24', '2', '1'),
('Joao Pedro', 'pedro@gamil.com', '987984514', 'pedrao', '1999-09-21', 'M', '2017-06-22', '1', '3'),
('Maria Clara', 'clara@gamil.com', '945986530', 'clara', '1975-10-28', 'M', '2017-07-30', '2', '5'),
('Jose Fabiano', 'fabiano@gamil.com', '999554696', 'fabi', '1990-03-15', 'M', '2017-07-28', '1', '5'),
('Paula Fernandes', 'fernandes@gamil.com', '969546358', 'fernandes', '1985-07-05', 'F', '2017-08-03', '2', '1');

/*Inserindo dados na tabela de albuns*/
INSERT INTO albuns 
(nome, data, usuario) 
VALUES 
('Família', '2010-05-02 05:38:37', '2'),
('Amigos', '2013-07-20 15:38:37', '4'),
('Por Aew', '2015-03-25 16:08:31', '6'),
('Curtindo o Feriadao', '2014-02-25 20:41:32', '9'),
('Festa sabado', '2009-05-16 06:56:45', '10'),
('Natal', '2017-12-25 16:38:37', '1'),
('Formatura SI', '2019-12-15 12:38:37', '5'),
('Despedida de Solteiro', '2013-07-06 23:00:00', '3'),
('Encontro dos Amigos', '2017-09-06 13:25:11', '7'),
('Virada de Ano', '2020-01-01 19:38:37', '2'),
('Happy', '2010-06-02 05:40:37', '2'),
('Zuera', '2013-09-20 15:50:37', '4'),
('Poesia', '2015-10-25 16:20:31', '6'),
('Curtindo', '2014-06-25 20:52:32', '9'),
('Festa', '2009-02-16 06:22:45', '10'),
('Ano Novo', '2017-12-25 16:55:37', '1'),
('Formatura', '2019-11-15 12:22:37', '5'),
('Farra', '2013-09-06 23:00:00', '3'),
('Serviço', '2017-08-06 13:25:11', '7'),
('Virada', '2020-10-01 19:40:37', '2');

/*Inserindo dados na tabela de multimidias*/
INSERT INTO multimidias
(midia, tipo_conteudo, data, album)
VALUES
('Foto', 'Público', '2017-02-28 14:38:37','5'),
('Vídeo', 'Privado', '2017-10-01 13:38:37','3'),
('Vídeo', 'Privado', '2017-06-20 15:09:37','2'),
('Foto', 'Público', '2017-12-22 09:38:37','1'),
('Texto', 'Público', '2017-03-16 11:38:35','1'),
('Vídeo', 'Privado', '2017-08-19 12:49:35','4'),
('Foto', 'Público', '2017-09-23 17:34:39','6'),
('Texto', 'Privado', '2017-10-25 14:00:00','9'),
('Foto', 'Público', '2017-02-10 19:25:09','4'),
('Texto', 'Privado', '2017-07-28 20:45:35','3'),
('Foto', 'Público', '2017-08-28 14:38:37','5'),
('Vídeo', 'Privado', '2017-11-01 13:38:37','3'),
('Vídeo', 'Privado', '2017-03-20 15:09:37','2'),
('Foto', 'Público', '2017-04-22 09:38:37','1'),
('Texto', 'Público', '2017-06-16 11:38:35','1'),
('Vídeo', 'Privado', '2017-07-19 12:49:35','4'),
('Foto', 'Público', '2017-08-23 17:34:39','6'),
('Texto', 'Privado', '2017-12-25 14:00:00','9'),
('Foto', 'Público', '2017-03-10 19:25:09','4'),
('Texto', 'Privado', '2017-09-28 20:45:35','3');

/*Inserindo dados na tabela de postagens*/
INSERT INTO postagens
(ups, downs, descricao, data, visualizacoes, usuario)
VALUES
('12', '8', 'Primeira postagem', '2009-10-05 09:38:37', '3', '4'),
('9', '0', 'Vida', '2010-10-30 12:38:37', '1', '2'),
('3', '123', 'Natureza', '2012-11-28 05:38:37', '5', '1'),
('25', '2', 'Passa eu', '2017-11-20 16:39:00', '35', '10'),
('155', '10', 'Essa rede e legal', '2016-05-06 12:00:42', '200', '6'),
('1', '100', 'Onde eu to', '2016-03-14 22:25:15', '155', '4'),
('51', '5', 'Sera que essa postagem funciona cara', '2016-07-03 12:22:48', '80', '8'),
('36', '2', 'To indo ali, ja volto', '2012-11-21 23:14:20', '42', '5'),
('25', '3', 'porque eu não  fui onde voltei', '2016-01-01 11:11:37', '29', '7'),
('0', '9', 'Segunda postagem eu acho', '2009-10-22 15:38:39', '5', '4'),
('12', '8', 'Primeira vez', '2009-11-05 09:38:37', '3', '4'),
('9', '0', 'Vida Diaria', '2010-07-30 12:38:37', '1', '2'),
('3', '123', 'Roça', '2012-12-28 05:38:37', '5', '1'),
('25', '2', 'Atrasado', '2017-09-20 16:39:00', '35', '10'),
('155', '10', 'Gol', '2016-07-06 12:00:42', '200', '6'),
('1', '100', 'Perdido', '2016-07-14 22:25:15', '155', '4'),
('51', '5', 'Canseira', '2016-07-03 12:22:48', '80', '8'),
('36', '2', 'Away', '2012-08-21 23:14:20', '42', '5'),
('25', '3', 'voltei', '2016-05-01 11:11:37', '29', '7'),
('0', '9', 'Segunda postagem', '2009-06-22 15:38:39', '5', '4');

/*Inserindo dados na tabela de comentarios*/
INSERT INTO comentarios
(descricao, ups, downs, data, postagem, usuario)
VALUES
('Que linda', '0', '3', '2011-01-06 20:38:37', '3', '2'),
('Linda', '2', '1', '2011-01-06 23:38:37', '3', '4'),
('Top', '4', '1', '2011-01-06 15:08:37', '3', '3'),
('Maravilhosa', '3', '1', '2011-01-06 11:38:37', '3', '4'),
('Eoq', '5', '5', '2016-05-09 14:30:37', '5', '1'),
('Aff', '10', '3', '2017-11-06 12:00:37', '7', '8'),
('Que legal', '5', '0', '2017-04-15 15:15:15', '8', '1'),
('Denovo isso', '25', '3', '2017-06-08 16:25:00', '9', '6'),
('Legalzaum', '30', '5', '2016-09-17 22:12:14', '6', '8'),
('Vamos sair?', '0', '4', '2011-01-06 15:38:56', '3', '1'),
('foda', '0', '3', '2011-01-06 20:38:37', '3', '2'),
('gatinha', '2', '1', '2011-01-06 23:38:37', '3', '4'),
('topado', '4', '1', '2011-01-06 15:08:37', '3', '3'),
('meiga', '3', '1', '2011-01-06 11:38:37', '3', '4'),
('fon', '5', '5', '2016-05-09 14:30:37', '5', '1'),
('att', '10', '3', '2017-11-06 12:00:37', '7', '8'),
('eita', '5', '0', '2017-04-15 15:15:15', '8', '1'),
('canseira', '25', '3', '2017-06-08 16:25:00', '9', '6'),
('aham', '30', '5', '2016-09-17 22:12:14', '6', '8'),
('Vamos logo', '0', '4', '2011-01-06 15:38:56', '3', '1');

/*Inserindo dados na tabela de postagens_multimidias*/
INSERT INTO postagens_multimidias
(postagem, multimidia)
VALUES
('1', '10'),
('2', '9'),
('3', '8'),
('4', '7'),
('5', '6'),
('6', '5'),
('7', '4'),
('8', '3'),
('9', '2'),
('10', '1'),
('11', '20'),
('12', '19'),
('13', '18'),
('14', '17'),
('15', '16'),
('16', '15'),
('17', '14'),
('18', '13'),
('19', '12'),
('20', '11');

/*Inserindo dados na tabela de postagens_albuns*/
INSERT INTO postagens_albuns
(postagem, album)
VALUES
('5', '5'),
('3', '2'),
('2', '1'),
('6', '7'),
('7', '6'),
('8', '9'),
('9', '8'),
('10', '10'),
('4', '3'),
('1', '4'),
('4', '4'),
('3', '3'),
('2', '2'),
('6', '6'),
('7', '7'),
('8', '8'),
('9', '9'),
('10', '5'),
('4', '5'),
('1', '6');

/*Inserindo dados na tabela de palavras_chave*/
INSERT INTO palavras_chave
(descricao)
VALUES
('Família, União, Esperança, Laço, Amor'),
('Vida, Reflexão, Liberdade, Genética, Respiração'),
('Natureza, Fauna, Flora, Animais, Unicórnio'),
('Festa, Refrigerante, Alegria, Barraco, Alcool'),
('Design, Pencil, Photshop, Corel Draw, Paint'),
('Computador, Memorias, Placas, Hd, Fonte'),
('Site, Html, php, jsp, asp'),
('Faculdade, Depressão, Desistir, Passar, Reprovar'),
('Cidade, Bontia, Feia, Movimentada, Deserta'),
('Colação, Formatura, Beca, Diploma, Festa'),
('Casa, União, Esperança, Abrigo, Amor'),
('Respirar, Reflexão, Liberdade, Genética, Respiração'),
('Roça, Fauna, Flora, Animais, Unicórnio'),
('Festa, Refrigerante, Alegria, Barraco, Alcool'),
('Desenhar, Pencil, Photshop, Corel Draw,
 Paint'),
('PC, Memorias, Placas, Hd, Fonte'),
('Web, Html, php, jsp, asp'),
('Ensino Medio, Depressão, Desistir, Passar, Reprovar'),
('Cidade Natal, Bontia, Feia, Movimentada, Deserta'),
('Fim, Formatura, Beca, Diploma, Festa');

/*Inserindo dados na tabela de categorias*/
INSERT INTO categorias
(descricao)
VALUES
('Biológicas'),
('Exatas'),
('Humanas'),
('Tecnologia'),
('Indeciso'),
('Tanto Faz'),
('Nenhuma'),
('Sei lá'),
('Viix'),
('Deboas'),
('Desconhecida'),
('Outros'),
('Astronomia'),
('Geologia'),
('Estatistica'),
('Logica'),
('Programação'),
('Engenharia'),
('Psicologia'),
('Direito');


/*Inserindo dados na tabela aportes*/
INSERT INTO `aportes` VALUES 
(1, 'Artigo aprovado!', 1, 4),
(2, 'Mais uma publicação', 2, 3),
(3, 'Viram isso?', 3, 2),
(4, 'Novidade!!', 4, 1),
(5, 'Mais um artigo aprovado!!!', 5, 2),
(6, 'Outro Artigo que deu certo', 6, 10),
(7, 'Confiram ai!!', 7, 9),
(8, 'Outro', 8, 8),
(9, 'Vejam ai', 9, 7),
(10, 'Caramba até que enfim', 10, 6),
(11, 'Aprovado!', 1, 5),
(12, 'Publicado', 2, 5),
(13, 'Viram', 3, 5),
(14, 'Sucesso', 4, 3),
(15, 'Mais um artigo', 5, 3),
(16, 'Deu certo', 6, 9),
(17, 'Confiram', 7, 10),
(18, 'De novo', 7, 7),
(19, 'Vejam', 7, 9),
(20, 'Caramba', 10, 7);

/*Inserindo dados na tabela artigos*/
INSERT INTO artigos
(id, idioma, revista, issn, data, area_conhecimento, titulo, resumo, url, artigo, categoria) 
VALUES
(1,'PORTUGUES', 'ISTOE', '2530-1123', '2017-04-16', 'INFORMATICA', 'NANODEGREE', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante. ', 'www.istoe.com.br', 1, 1),
(2,'PORTUGUES', 'VEJA', '2250-1003', '2017-07-10', 'INFORMATICA', 'APPS', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante.', 'www.veja.com.br', 2, 2),
(3,'PORTUGUES', 'EXAME', '2125-0023', '2017-09-06', 'INFORMATICA', 'PHP', 'Proin vel turpis fringilla, congue mauris sit amet, interdum .', 'www.exame.com.br', 3, 3),
(4,'PORTUGUES', 'REVISTA1', '8888-9999', '2017-09-15', 'INFORMATICA', 'JQUERY', 'Proin vel turpis fringilla', 'www.revista1.com.br', 4, 4),
(5,'PORTUGUES', 'REVISTA2', '9999-9999', '2017-10-19', 'INFORMATICA', 'HTML', 'Proin vel turpis fringilla, del qualquer coisa', 'www.revista2.com.br', 5, 5),
(6,'PORTUGUES', 'REVISTAALI', '5577-5566', '2017-10-19', 'INFORMATICA', 'ASP', 'E um artigo bem legal', 'www.revistaali.com.br', 6, 6),
(7,'PORTUGUES', 'POPULAR', '9566-6695', '2017-02-17', 'INFORMATICA', 'PHP', 'Um pequeno resumo....', 'www.populardopovo.com.br', 7, 7),
(8,'PORTUGUES', 'GAZETA', '9875-5475', '2017-05-20', 'INFORMATICA', 'WEB', 'Neste artigo procurei defender a WEB', 'www.gazetaweb.com.br', 8, 8),
(9,'PORTUGUES', 'PLANALTO', '9578-9575', '2017-08-20', 'INFORMATICA', 'INTERNET', 'Internet das coisas', 'www.planaltoartigos.com.br', 9, 9),
(10,'PORTUGUES', 'FOFOCANDO', '9254-9474', '2017-12-20', 'INFORMATICA', 'OPERACIONAL', 'O sistema ideal pra você', 'www.fofocando.com.br', 10, 10),
(11,'PORTUGUES', 'ISTOE', '2530-1123', '2017-04-16', 'INFORMATICA', 'NANODEGREE', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante. ', 'www.istoe.com.br', 11, 11),
(12,'PORTUGUES', 'VEJA', '2250-1003', '2017-07-10', 'INFORMATICA', 'APPS', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante.', 'www.veja.com.br', 12, 12),
(13,'PORTUGUES', 'EXAME', '2125-0023', '2017-09-06', 'INFORMATICA', 'PHP', 'Proin vel turpis fringilla, congue mauris sit amet, interdum .', 'www.exame.com.br', 13, 13),
(14,'PORTUGUES', 'REVISTA1', '8888-9999', '2017-09-15', 'INFORMATICA', 'JQUERY', 'Proin vel turpis fringilla', 'www.revista1.com.br', 14, 14),
(15,'PORTUGUES', 'REVISTA2', '9999-9999', '2017-10-19', 'INFORMATICA', 'HTML', 'Proin vel turpis fringilla, del qualquer coisa', 'www.revista2.com.br', 15, 15),
(16,'PORTUGUES', 'REVISTAALI', '5577-5566', '2017-10-19', 'INFORMATICA', 'ASP', 'E um artigo bem legal', 'www.revistaali.com.br', 16, 16),
(17,'PORTUGUES', 'POPULAR', '9566-6695', '2017-02-17', 'INFORMATICA', 'PHP', 'Um pequeno resumo....', 'www.populardopovo.com.br', 17, 17),
(18,'PORTUGUES', 'GAZETA', '9875-5475', '2017-05-20', 'INFORMATICA', 'WEB', 'Neste artigo procurei defender a WEB', 'www.gazetaweb.com.br', 18, 18),
(19,'PORTUGUES', 'PLANALTO', '9578-9575', '2017-08-20', 'INFORMATICA', 'INTERNET', 'Internet das coisas', 'www.planaltoartigos.com.br', 19, 19),
(20,'PORTUGUES', 'FOFOCANDO', '9254-9474', '2017-12-20', 'INFORMATICA', 'OPERACIONAL', 'O sistema ideal pra você', 'www.fofocando.com.br', 20, 20);

/*Inserindo dados na tabela postagens_artigos*/
INSERT INTO postagens_artigos 
(postagem, artigo)
VALUES
('1', '10'),
('2', '9'),
('3', '8'),
('4', '7'),
('5', '6'),
('6', '5'),
('7', '4'),
('8', '3'),
('9', '2'),
('10', '1'),
('11', '20'),
('12', '19'),
('13', '18'),
('14', '17'),
('15', '16'),
('16', '15'),
('17', '14'),
('18', '13'),
('19', '12'),
('20', '11');

/*Inserindo dados na tabela postagens_palavras_chave*/
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('1', '10');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('2', '9');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('3', '8');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('4', '7');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('5', '6');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('6', '5');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('7', '4');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('8', '3');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('9', '2');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('10', '1');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('11', '20');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('12', '19');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('13', '18');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('14', '17');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('15', '16');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('16', '15');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('17', '14');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('18', '13');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('19', '12');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('20', '11');

/*Inserindo dados na tabela autores*/
INSERT INTO autores 
(usuario, artigo)
VALUES
('2', '4'),
('4', '5'),
('3', '1'),
('1', '2'),
('5', '3'),
('6', '10'),
('8', '6'),
('7', '9'),
('9', '7'),
('10', '8'),
('12', '14'),
('14', '15'),
('13', '11'),
('11', '12'),
('15', '13'),
('16', '20'),
('18', '16'),
('17', '19'),
('19', '17'),
('20', '18');


/*Inserindo dados na tabela relacionamentos*/
INSERT INTO relacionamentos 
(usuario_1, usuario_2, tipo)
VALUES
('1', '2', 1),
('4', '5', 2),
('3', '1', 3),
('4', '2', 4),
('6', '7', 5),
('8', '9', 6),
('9', '10', 8),
('10', '9', 3),
('2', '6', 3),
('5', '3', 4),
('11', '12', 1),
('14', '15', 2),
('13', '11', 3),
('14', '12', 4),
('16', '17', 5),
('18', '19', 6),
('19', '20', 8),
('20', '19', 3),
('12', '16', 3),
('15', '13', 4);

/*Inserindo dados na tabela grupos*/
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`)
 VALUES ('1', 'Profissão Programador', '2017-09-03', 'Discutimos assuntos sobre desenvolvimento de software, mercado de trabalho, etc.', '0', 1);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('2', 'BD Master', '2017-10-30', 'Discutimos assuntos sobre SGBDs, mercado de trabalho, etc.', '0', 2);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('3', 'Artigos TI', '2016-06-15', 'Discutimos assuntos sobre Artigo na area de TI.', '1', 3);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('4', 'Business Intelligence', '2017-01-21', 'Discutimos assuntos sobre processo de coleta, organização, análise, compartilhamento e monitoramento de informações que oferecem suporte a gestão de negócios.', '1', 4);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('5', 'Engenharia de software', '2017-04-18', 'Discutimos assuntos sobre especificação, desenvolvimento, manutenção e criação de software, visando organização, produtividade e qualidade.', '0', 5);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('6', 'WEbDesign', '2017-03-18', 'Discutimos assuntos sobre o desenvolvimento de paginas Web.', '0', 6);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('7', 'ChatBot', '2017-07-25', 'Discutimos assuntos sobre o desenvolvimento de Bots para telegram e outros.', '0', 7);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('8', 'Ajax', '2017-09-05', 'Discutimos assuntos sobre o desenvolvimento em ajax.', '0', 8);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('9', 'Java', '2017-11-05', 'Discutimos assuntos sobre o desenvolvimento, manutenção e criação de software, utilizando
 a linguagem JAVA!', '0', 9);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('10', 'Mineração de Dados', '2017-09-03', 'Discutimos assuntos sobre mineração de dados.', '0', 10);

INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`)
 VALUES ('11', 'Programador', '2017-09-03', 'Discutimos assuntos sobre desenvolvimento de software, mercado de trabalho, etc.', '0', 11);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('12', 'BD', '2017-10-30', 'Discutimos assuntos sobre SGBDs, mercado de trabalho, etc.', '0', 12);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('13', 'Artigos Tec. Inform.', '2016-06-15', 'Discutimos assuntos sobre Artigo na area de TI.', '1', 13);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('14', 'Intelligence', '2017-01-21', 'Discutimos assuntos sobre processo de coleta, organização, análise, compartilhamento e monitoramento de informações que oferecem suporte a gestão de negócios.', '1', 14);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('15', 'Eng. de software', '2017-04-18', 'Discutimos assuntos sobre especificação, desenvolvimento, manutenção e criação de software, visando organização, produtividade e qualidade.', '0', 15);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('16', 'Web Design', '2017-03-18', 'Discutimos assuntos sobre o desenvolvimento de paginas Web.', '0', 16);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('17', 'ChatBot Inovação', '2017-07-25', 'Discutimos assuntos sobre o desenvolvimento de Bots para telegram e outros.', '0', 17);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('18', 'Ajax Puro', '2017-09-05', 'Discutimos assuntos sobre o desenvolvimento em ajax.', '0', 18);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('19', 'Programação Java', '2017-11-05', 'Discutimos assuntos sobre o desenvolvimento, manutenção e criação de software, utilizando a linguagem JAVA!', '0', 19);
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) 
VALUES ('20', 'M. de Dados ', '2017-09-03', 'Discutimos assuntos sobre mineração de dados.', '0', 20);

/*Inserindo dados na tabela participantes*/
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('1', '2', '1');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('1', '3', '2');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('2', '4', '3');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('3', '5', '4');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('5', '1', '5');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('7', '10', '6');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('9', '9', '7');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('10', '8', '8');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('6', '7', '9');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('4', '6', '10');

INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('2', '2', '1');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('2', '3', '2');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('3', '4', '3');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('4', '5', '4');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('6', '1', '5');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('8', '10', '6');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('10', '9', '7');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('1', '8', '8');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('7', '7', '9');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('5', '6', '10');

/*Inserindo dados na tabela de tipos_atividades*/ 
INSERT INTO tipos_atividades
(id, nome, restricao)
VALUES
(1, 'Palestra', true),
(2, 'Reunião da Empresa', false),
(3, 'Evento', true),
(4, 'Evento Partidário', true),
(5, 'Palestra Sobre Negócios', false),
(6, 'Palestra Sobre Start-up', false),
(7, 'Evento Beneficente', false),
(8, 'Evento Acadêmico', true),
(9, 'Evento Motivacional', false),
(10, 'Palestra Internacional', false),

(11, 'Palestra Economica', true),
(12, 'Reunião de Funcionarios', false),
(13, 'Evento Solidario', true),
(14, 'Evento', true),
(15, 'Palestra Sobre Agricultura', false),
(16, 'Palestra Sobre Minecraft', false),
(17, 'Evento Surpresa', false),
(18, 'Evento Mestrado', true),
(19, 'Evento Ciclismo', false),
(20, 'Palestra Nacional', false);

/*Inserindo dados na tabela de eventos*/ 
INSERT INTO eventos
(id, nome, descricao, certificado, inicio, fim, responsavel, inicio_inscricao, encerramento_inscricao, endereco)
VALUES
(1,'Latinoware', 'Evento Congresso Latino-Americano de Software Livre e Tecnologias Abertas', true ,'2017/10/18 08:00', '2017/10/20 17:00', '1', '2017/01/01 15:00', '2017/09/20 15:00', 'a'),
(2, 'Fgsl', 'Fórum Goiano de Software Livre', true, '2017/09/18 19:00', '2017/11/20 18:00', '2', '2017/01/01 15:00', '2017/09/20 15:00', 'a'),
(3, 'Flisol', 'Festival Latino-americano de Instalação de Software Livre', false, '2017/09/12 08:00', '2017/11/05 11:00', '3', '2017/01/02 12:00', '2017/05/20 13:00', 'a'),
(4, 'CSBC', 'Congresso Nacional da Sociedade Brasileira de Computação', true, '2017/09/11 07:00', '2017/12/20 12:00', '4', '2017/07/26 15:00', '2017/08/20 16:00', 'a'),
(5, 'SIMTEC', 'Simpósio de Tecnologia da Informação', false, '2017/09/11 07:00', '2017/01/20 18:00', '5', '2017/01/02 12:00', '2017/08/24 12:00', 'a'),
(6, 'SMW', 'Social Media Week', true, '2017/06/13 07:00', '2017/06/15 12:00', '4', '2017/05/26 15:00', '2017/06/02 16:00', 'a'),
(7, 'BIG', ' Brazil Independent Game Festival', true, '2017/05/01 07:00', '2017/05/02 12:00', '4', '2017/04/26 15:00', '2017/04/29 16:00', 'a'),
(8, 'CP', 'Campus Party', true, '2017/06/01 07:00', '2017/06/06 12:00', '4', '2017/05/20 15:00', '2017/05/29 16:00', 'a'),
(9, 'CE360', 'Conferência Ethos 360º', true, '2017/03/01 07:00', '2017/03/05 15:00', '4', '2017/02/15 13:00', '2017/02/20 17:00', 'a'),
(10, 'ESHOW', 'eShow SP', true, '2017/09/15 07:00', '2017/09/20 19:00', '4', '2017/08/26 15:00', '2017/09/10 16:00', 'a'),

(11,'Latinoware', 'Evento Congresso Latino-Americano de Software Livre e Tecnologias Abertas', true ,'2017/10/18 08:00', '2017/10/20 17:00', '1', '2017/01/01 15:00', '2017/09/20 15:00', 'a'),
(12, 'Fgsl', 'Fórum Goiano de Software Livre', true, '2017/09/18 19:00', '2017/11/20 18:00', '2', '2017/01/01 15:00', '2017/09/20 15:00', 'a'),
(13, 'Flisol', 'Festival Latino-americano de Instalação de Software Livre', false, '2017/09/12 08:00', '2017/11/05 11:00', '3', '2017/01/02 12:00', '2017/05/20 13:00', 'a'),
(14, 'CSBC', 'Congresso Nacional da Sociedade Brasileira de Computação', true, '2017/09/11 07:00', '2017/12/20 12:00', '4', '2017/07/26 15:00', '2017/08/20 16:00', 'a'),
(15, 'SIMTEC', 'Simpósio de Tecnologia da Informação', false, '2017/09/11 07:00', '2017/01/20 18:00', '5', '2017/01/02 12:00', '2017/08/24 12:00', 'a'),
(16, 'SMW', 'Social Media Week', true, '2017/06/13 07:00', '2017/06/15 12:00', '4', '2017/05/26 15:00', '2017/06/02 16:00', 'a'),
(17, 'BIG', ' Brazil Independent Game Festival', true, '2017/05/01 07:00', '2017/05/02 12:00', '4', '2017/04/26 15:00', '2017/04/29 16:00', 'a'),
(18, 'CP', 'Campus Party', true, '2017/06/01 07:00', '2017/06/06 12:00', '4', '2017/05/20 15:00', '2017/05/29 16:00', 'a'),
(19, 'CE360', 'Conferência Ethos 360º', true, '2017/03/01 07:00', '2017/03/05 15:00', '4', '2017/02/15 13:00', '2017/02/20 17:00', 'a'),
(20, 'ESHOW', 'eShow SP', true, '2017/09/15 07:00', '2017/09/20 19:00', '4', '2017/08/26 15:00', '2017/09/10 16:00', 'a');

/*Inserindo dados na tabela de atividades*/
INSERT INTO atividades
(id, descricao, inicio, fim, vagas, tipo, evento, local)
VALUES
(1, 'Marketing é Vida','2010-01-01 10:00:00','2010-01-01 12:00:00','100','1','2', 'a'),
(2, 'O Valor da Existência','2011-02-02 09:00:00','2011-02-02 11:00:00','50','3','4', 'a'),
(3, 'Como Investir?','2015-04-14 14:00:00','2015-04-14 16:00:00','65','5','3', 'a'),
(4, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(5, 'O Quanto Vale A Verdade?','2016-05-16 17:00:00','2016-05-16 19:00:00','150','3','1', 'a'),
(6, 'O Poder da Tecnologia','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(7, 'Ser Humano','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(8, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(9, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(10, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),

(11, 'Marketing é Vida','2010-01-01 10:00:00','2010-01-01 12:00:00','100','1','2', 'a'),
(12, 'O Valor da Existência','2011-02-02 09:00:00','2011-02-02 11:00:00','50','3','4', 'a'),
(13, 'Como Investir?','2015-04-14 14:00:00','2015-04-14 16:00:00','65','5','3', 'a'),
(14, 'Aprender
 a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(15, 'O Quanto Vale A Verdade?','2016-05-16 17:00:00','2016-05-16 19:00:00','150','3','1', 'a'),
(16, 'O Poder da Tecnologia','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(17, 'Ser Humano','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(18, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(19, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a'),
(20, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','4','3', 'a');

/*Inserindo dados na responsaveis_atividades*/ 
INSERT INTO responsaveis_atividades
(atividade, usuario)
VALUES
('1', '10'),
('2', '9'),
('3', '8'),
('4', '7'),
('5', '6'),
('6', '5'),
('7', '4'),
('8', '3'),
('9', '2'),
('10', '1'),

('11', '20'),
('12', '19'),
('13', '18'),
('14', '17'),
('15', '16'),
('16', '15'),
('17', '14'),
('18', '13'),
('19', '12'),
('20', '11');

/*Inserindo dados na tabela de organizadores_eventos*/ 
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('1', '1');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('2', '2');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('3', '3');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('4', '4');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('5', '5');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('6', '5');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('7', '4');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('8', '3');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('9', '2');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('10', '1');

INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('11', '11');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('12', '12');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('13', '13');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('14', '14');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('15', '15');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('16', '15');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('17', '14');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('18', '13');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('19', '12');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('20', '11');

/*Inserindo dados na tabela de presenca_evento*/ 
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '3');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '2', '5');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '3', '2');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '2', '3');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '7', '3');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '6');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '5', '9');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '1');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '4');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '9', '8');

INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '13');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '2', '15');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '3', '12');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '2', '13');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '7', '13');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '16');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '5', '19');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '11');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '1', '14');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '9', '18');

/*Inserindo dados na tabela de presenca_atividade*/ 
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '3');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '1', '1');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '2');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '3', '4');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '5', '7');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '6', '8');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '8', '5');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '7', '3');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '7', '2');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '7', '1');

INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '13');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '1', '11');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '12');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '3', '14');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '5', '17');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '6', '18');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '8', '15');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '7', '13');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '7', '12');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '7', '11');