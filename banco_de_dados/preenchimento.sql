/*Inserindo dados na tabela de paises*/
INSERT INTO paises 
(nome) 
VALUES 
('Brasil'), 
('Argentina'),
('Estados Unidos'),
('Portugal'),
('França');

/*Inserindo dados na tabela de estados*/
INSERT INTO estados
(nome, pais)
VALUES
('Texas', '3'),
('Minas Gerais', '1'),
('Santa Fé', '2'),
('São Paulo', '1'),
('Flórida', '3');

/*Inserindo dados na tabela de cidades*/
INSERT INTO cidades
(nome, estado)
VALUES
('Uruana', '2'),
('Austin', '1'),
('Campinas', '4'),
('Belo Horizonte', '2'),
('São Paulo', '4');

/*Inserindo dados na tabela de usuarios*/
INSERT INTO usuarios
(nome, email, telefone, senha, data_nascimento, sexo, data_cadastro, status, cidade)
VALUES
('Luciano Borba', 'ciano@gamil.com', '992934567', '123456789', '1998-12-01', 'M', '2017-09-05 15:38:37', '1', '3'),
('Lara Caroline', 'lara@gamil.com', '996912347', 'florzinha', '1993-09-03', 'F', '2017-10-09 12:02:39', '1', '2'),
('Ianka', 'ianka@hotmail.com', '984596076', 'unicórnio', '1956-04-12', 'F', '2017-08-05 09:31:37', '1', '3'),
('josé Maria', 'jm@gamil.com', '9749484848', '850380504', '1990-10-03', 'M', '2017-03-09 11:02:39', '1', '5'),
('Naira Azevedo', 'na@gamil.com', '965456789', 'naiaraazevedo', '1993-03-15', 'F', '2017-02-09 11:02:39', '1', '4');

/*Inserindo dados na tabela de albuns*/
INSERT INTO albuns 
(nome, data, usuario) 
VALUES 
('Família', '2010-05-02 05:38:37', '2'),
('Amigos', '2013-07-20 15:38:37', '4'),
('Natal', '2017-12-25 16:38:37', '1'),
('Formatura SI', '2019-12-15 12:38:37', '5'),
('Virada de Ano', '2020-01-01 19:38:37', '2');

/*Inserindo dados na tabela de multimidias*/
INSERT INTO multimidias
(midia, tipo_conteudo, data, album)
VALUES
('Foto', 'Público', '2017-02-28 14:38:37','5'),
('Vídeo', 'Privado', '2017-10-01 13:38:37','3'),
('Vídeo', 'Privado', '2017-06-20 15:09:37','2'),
('Foto', 'Público', '2017-12-22 09:38:37','1'),
('Texto', 'Público', '2017-03-16 11:38:35','1');

/*Inserindo dados na tabela de postagens*/
INSERT INTO postagens
(ups, downs, descricao, data, visualizacoes, usuario)
VALUES
('12', '8', 'Primeira postagem', '2009-10-05 09:38:37', '3', '4'),
('9', '0', 'Vida', '2010-10-30 12:38:37', '1', '2'),
('3', '123', 'Natureza', '2012-11-28 05:38:37', '5', '1'),
('78', '0', 'IA', '2015-08-01 15:34:37', '15', '2'),
('0', '9', 'Segunda postagem', '2009-10-22 15:38:39', '5', '4');

/*Inserindo dados na tabela de comentarios*/
INSERT INTO comentarios
(descricao, ups, downs, data, postagem, usuario)
VALUES
('Que linda', '0', '3', '2011-01-06 20:38:37', '3', '2'),
('Linda', '2', '1', '2011-01-06 23:38:37', '3', '4'),
('Top', '4', '1', '2011-01-06 15:08:37', '3', '3'),
('Maravilhosa', '3', '1', '2011-01-06 11:38:37', '3', '4'),
('Vamos sair?', '0', '4', '2011-01-06 15:38:56', '3', '1');

/*Inserindo dados na tabela de postagens_multimidias*/
INSERT INTO postagens_multimidias
(postagem, multimidia)
VALUES
('1', '2'),
('5', '3'),
('4', '1'),
('3', '4'),
('2', '2');

/*Inserindo dados na tabela de postagens_albuns*/
INSERT INTO postagens_albuns
(postagem, album)
VALUES
('5', '5'),
('3', '2'),
('2', '1'),
('4', '3'),
('1', '4');

/*Inserindo dados na tabela de palavras_chave*/
INSERT INTO palavras_chave
(descricao)
VALUES
('Família, União, Esperança, Laço, Amor'),
('Vida, Reflexão, Liberdade, Genética, Respiração'),
('Natureza, Fauna, Flora, Animais, Unicórnio'),
('Virada, Fogos, Champagne, Branco, Trevo'),
('Colação, Formatura, Beca, Diploma, Festa');

/*Inserindo dados na tabela de categorias*/
INSERT INTO categorias
(descricao)
VALUES
('Biológicas'),
('Exatas'),
('Humanas'),
('Tecnologia'),
('Deboas');

/*Inserindo dados na tabela aportes*/
INSERT INTO `aportes` VALUES 
(1, 'Artigo aprovado!', 1, 4),
(2, 'Mais uma publicação', 2, 3),
(3, 'Viram isso?', 3, 2),
(4, 'Novidade!!', 4, 1),
(5, 'Mais um artigo aprovado!!!', 5, 2);

/*Inserindo dados na tabela artigos*/
INSERT INTO artigos
(id, idioma, revista, issn, data, area_conhecimento, titulo, resumo, url, artigo, categoria) 
VALUES
(1,'PORTUGUES', 'ISTOE', '2530-1123', '2017-04-16', 'INFORMATICA', 'NANODEGREE', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante. ', 'www.istoe.com.br', 1, 1),
(2,'PORTUGUES', 'VEJA', '2250-1003', '2017-07-10', 'INFORMATICA', 'APPS', 'Proin vel turpis fringilla, congue mauris sit amet, interdum ante.', 'www.veja.com.br', 2, 2),
(3,'PORTUGUES', 'EXAME', '2125-0023', '2017-09-06', 'INFORMATICA', 'PHP', 'Proin vel turpis fringilla, congue mauris sit amet, interdum .', 'www.exame.com.br', 3, 3),
(4,'PORTUGUES', 'REVISTA1', '8888-9999', '2017-09-15', 'INFORMATICA', 'JQUERY', 'Proin vel turpis fringilla', 'www.revista1.com.br', 1, 2),
(5,'PORTUGUES', 'REVISTA2', '9999-9999', '2017-09-15', 'INFORMATICA', 'HTML', 'Proin vel turpis fringilla', 'www.revista2.com.br', 1, 1);

/*Inserindo dados na tabela postagens_artigos*/
INSERT INTO postagens_artigos 
(postagem, artigo)
VALUES
('1', '5'),
('2', '4'),
('3', '3'),
('4', '2'),
('5', '1');

/*Inserindo dados na tabela postagens_palavras_chave*/
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('1', '4');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('2', '3');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('3', '1');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('4', '5');
INSERT INTO `redesocial`.`postagens_palavras_chave` (`postagem`, `palavra_chave`) VALUES ('5', '2');

/*Inserindo dados na tabela autores*/
INSERT INTO autores 
(usuario, artigo)
VALUES
('2', '4'),
('4', '5'),
('3', '1'),
('1', '2'),
('5', '3');

/*Inserindo dados na tabela relacionamentos*/
INSERT INTO relacionamentos 
(usuario_1, usuario_2, tipo)
VALUES
('1', '2', 'Casado'),
('4', '5', 'Relacionamento Aberto'),
('3', '1', 'Divorciado'),
('4', '2', 'Divorciado'),
('5', '3', 'Relacionamento Sério');

/*Inserindo dados na tabela grupos*/
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) VALUES ('1', 'Profissão Programador', '2017-09-03', 'Discutimos assuntos sobre desenvolvimento de software, mercado de trabalho, etc.', '0', 'Programação');
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) VALUES ('2', 'BD Master', '2017-10-30', 'Discutimos assuntos sobre SGBDs, mercado de trabalho, etc.', '0', 'Banco de Dados');
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) VALUES ('3', 'Artigos TI', '2016-06-15', 'Discutimos assuntos sobre Artigo na area de TI.', '1', 'Artigos Cientificos');
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) VALUES ('4', 'Business Intelligence', '2017-01-21', 'Discutimos assuntos sobre processo de coleta, organização, análise, compartilhamento e monitoramento de informações que oferecem suporte a gestão de negócios.', '1', 'Inteligência de Negócios');
INSERT INTO `redesocial`.`grupos` (`id`, `nome`, `data_criacao`, `descricao`, `privacidade`, `tipo`) VALUES ('5', 'Engenharia de software', '2017-04-18', 'Discutimos assuntos sobre especificação, desenvolvimento, manutenção e criação de software, visando organização, produtividade e qualidade.', '0', 'Engenharia');

/*Inserindo dados na tabela participantes*/
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('1', '2', '1');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('1', '3', '2');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('2', '4', '3');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('3', '5', '4');
INSERT INTO `redesocial`.`participantes` (`grupo`, `usuario`, `cargo`) VALUES ('5', '1', '5');

/*Inserindo dados na tabela de tipos_atividades*/ 
INSERT INTO tipos_atividades
(id, nome, restricao)
VALUES
(1, 'Palestra', true),
(2, 'Reunião da Empresa', false),
(3, 'Evento', true),
(4, 'Evento Partidário', true),
(5, 'Palestra Sobre Negócios', false);

/*Inserindo dados na tabela de atividades*/
INSERT INTO atividades
(id, descricao, inicio, fim, vagas, tipo, evento)
VALUES
(1, 'Marketing é Vida','2010-01-01 10:00:00','2010-01-01 12:00:00','100','1','2'),
(2, 'O Valor da Existência','2011-02-02 09:00:00','2011-02-02 11:00:00','50','3','4'),
(3, 'Como Investir?','2015-04-14 14:00:00','2015-04-14 16:00:00','65','5','6'),
(4, 'Aprender a Programar é Bom?','2008-10-15 22:00:00','2008-10-15 23:00:00','70','7','8'),
(5, 'O Quanto Vale A Verdade?','2016-05-16 17:00:00','2016-05-16 19:00:00','150','9','10');

/*Inserindo dados na tabela de eventos*/ 
INSERT INTO eventos
(nome, descricao, certificado, inicio, fim, responsavel, inicio_inscricao, encerramento_inscricao)
VALUES
('Latinoware', 'Evento Congresso Latino-Americano de Software Livre e Tecnologias Abertas', true, '18/10/2017 08:00', '20/10/2017 17:00', 'Parque Itaipu', '01/01/2017 15:00', '20/09/2017 15:00'),
('Fgsl', 'Fórum Goiano de Software Livre', true, '18/09/2017 09:00', '20/11/2017 18:00', 'João da Beirinha', '01/01/2017 15:00', '20/09/2017 15:00'),
('Flisol', 'Festival Latino-americano de Instalação de Software Livre', false, '12/09/2017 08:00', '05/11/2017 11:00', 'Unicórnio Colorido', '02/01/2017 12:00', '20/05/2017 13:00'),
('CSBC', 'Congresso Nacional da Sociedade Brasileira de Computação', true, '11/09/2017 07:00', '20/12/2017 12:00', 'Povo Inteligente', '26/07/2017 15:00', '20/08/2017 16:00'),
('SIMTEC', 'Simpósio de Tecnologia da Informação', false, '11/09/2017 07:00', '20/01/2017 18:00', 'Alunos de SI', '02/01/2017 12:00', '24/08/2017 12:00');

/*Inserindo dados na responsaveis_atividades*/ 
INSERT INTO responsaveis_atividades
(atividade, usuario)
VALUES
('1', '5'),
('4', '4'),
('2', '1'),
('5', '3'),
('3', '2');

/*Inserindo dados na tabela de organizadores_eventos*/ 
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('1', '1');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('1', '2');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('1', '3');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('2', '4');
INSERT INTO `redesocial`.`organizadores_eventos` (`evento`, `usuario`) VALUES ('3', '5');

/*Inserindo dados na tabela de presenca_evento*/ 
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '1', '3');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '2', '1');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '3', '2');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('1', '2', '3');
INSERT INTO `redesocial`.`presenca_evento` (`presenca`, `evento`, `usuario`) VALUES ('0', '2', '1');

/*Inserindo dados na tabela de presenca_atividade*/ 
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '3');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '1', '1');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '2', '2');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('1', '3', '4');
INSERT INTO `redesocial`.`presenca_atividade` (`presenca`, `atividade`, `usuario`) VALUES ('0', '4', '5');











