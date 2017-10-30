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
('Luciano Borba', 'ciano@gamil.com', '992934567', '123456789', '1998-12-01', 'M', '2017-09-05 15:38:37', '1', '6'),
('Lara Caroline', 'lara@gamil.com', '996912347', 'florzinha', '1993-09-03', 'F', '2017-10-09 12:02:39', '1', '2'),
('Ianka', 'ianka@hotamil.com', '984596076', 'kdjfldjfjj', '1956-04-12', 'F', '2017-08-05 09:31:37', '1', '3'),
('josé Maria', 'jm@gamil.com', '9749484848', '850380504', '1990-10-03', 'M', '2017-03-09 11:02:39', '1', '5'),
('Naira Azevedo', 'na@gamil.com', '965456789', 'naiaraazevedo', '1993-03-15', 'F', '2017-02-09 11:02:39', '1', '4');

/*Inserindo dados na tabela de albuns*/
INSERT INTO albuns 
(nome, data, usuario) 
VALUES 
('Família', '2010-05-02', '2'),
('Amigos', '2013-07-20', '4'),
('Natal', '2017-12-25', '1'),
('Formatura SI', '2019-12-15', '5'),
('Virada de Ano', '2020-01-01', '2')

/*Inserindo dados na tabela de multimidias*/
INSERT INTO multimidias
(midia, tipo_conteudo, data, album)
VALUES
('Foto', 'Público', '2017-02-28','5'),
('Vídeo', 'Privado', '2017-10-01','3'),
('Vídeo', 'Privado', '2017-06-20','2'),
('Foto', 'Público', '2017-12-22','1'),
('Texto', 'Público', '2017-03-16','1')

/*Inserindo dados na tabela de postagens*/
INSERT INTO postagens
(ups, downs, descricao, data, visualizacoes, usuario)
VALUES
('0', '0', 'Primeira postagem', '2009-10-05', '3', '4'),
('0', '0', 'Vida', '2010-10-30', '1', '2'),
('0', '0', 'Natureza', '2012-11-28', '5', '1'),
('0', '0', 'IA', '2015-08-01', '15', '2'),
('0', '0', 'Segunda postagem', '2009-10-22', '5', '4')

/*Inserindo dados na tabela de comentarios*/
INSERT INTO comentarios
(descricao, ups, downs, data, postagem, resposta, usuario)
VALUES
('Que linda', '0', '1', '2011-01-06', '3', 'Obrigada!', '2'),
('Linda', '0', '1', '2011-01-06', '3', 'Você', '4'),
('Top', '0', '1', '2011-01-06', '3', 'Obg', '3'),
('Maravilhosa', '0', '1', '2011-01-06', '3', 'Obrigadaa!', '4'),
('Vamos sair?', '0', '1', '2011-01-06', '3', 'Hoje não Faro kkkk', '1')

/*Inserindo dados na tabela de postagens_multimidias*/