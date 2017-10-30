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
(ups, downs, descricao, data, vizualizacoes, usuario)
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
('', ''),
('', ''),
('', ''),
('', ''),
('', '');

/*Inserindo dados na tabela de postagens_albuns*/
INSERT INTO postagens_albuns
(postagem, album)
VALUES
('', ''),
('', ''),
('', ''),
('', ''),
('', '');

/*Inserindo dados na tabela de palavras_chaves*/
INSERT INTO palavras_chaves
(descricao)
VALUES
(''),
(''),
(''),
(''),
('');

/*Inserindo dados na tabela de categorias*/
INSERT INTO categorias
(descricao)
VALUES
(''),
(''),
(''),
(''),
('');





 

