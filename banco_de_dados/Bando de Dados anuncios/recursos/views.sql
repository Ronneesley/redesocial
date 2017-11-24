-- Visualizar o nome da pagina, o nome do usuario e quantidade de visualizacao do anuncio
CREATE VIEW visualizacao_anunciante AS 
SELECT  anunciantes.id, anunciantes.pagina, anunciantes.usuario, anuncios.quantidade_visualizacao FROM anunciantes
INNER JOIN anuncios ON anunciantes.anuncios_id = anuncios.id;

-- Seleciona a quantidade de cliques por anuncio
CREATE VIEW cliques_anuncio AS 
SELECT anuncios.cliques, anuncios.postagem_anuncio, anuncios.id FROM anuncios
INNER JOIN anunciantes ON anuncios_id = anunciantes.anuncios_id
GROUP BY anuncios.id;

-- Seleciona o metodo a pagina e o metodo de pagamento de cada anuncio
CREATE VIEW pagamento_anuncio AS
SELECT anunciantes.id, anunciantes.pagina, anuncios.postagem_anuncio, forma_pagamento FROM anunciantes
INNER JOIN anuncios ON anunciantes.anuncios_id = anuncios.id 
INNER JOIN pagamentos ON anuncios.pagamentos_id = pagamentos.id;

-- Seleciona o nome da pagina e credito de anuncio de cada usuario
CREATE VIEW qntd_credito AS
SELECT anunciantes.id, anunciantes.pagina, anunciantes.usuario, anuncios.postagem_anuncio, pagamentos.credito FROM anunciantes
INNER JOIN anuncios ON anunciantes.anuncios_id = anuncios.id
INNER JOIN pagamentos ON anuncios.pagamentos_id = pagamentos.id;

-- Seleciona a pagina, o usuario as datas de inicio e fim de cada anuncio
CREATE VIEW datas_anuncio AS
SELECT anunciantes.id, anunciantes.pagina, anunciantes.usuario, anuncios.postagem_anuncio, anuncios.data_inicio, anuncios.data_final FROM anunciantes
INNER JOIN anuncios ON anunciantes.anuncios_id = anuncios.id;

-- Seleciona a pagina, o usuario e o publico alvdo de cada anuncio
CREATE VIEW publico_alvo_anuncio AS
SELECT anunciantes.id, anunciantes.pagina, anunciantes.usuario, anuncios.postagem_anuncio, anuncios.publico_alvo FROM anunciantes
INNER JOIN anuncios ON anunciantes.anuncios_id = anuncios.id;

-- Seleciona a pagina, o usuario e regiao escolhida de cada anuncio
CREATE VIEW regiao_anuncio AS
SELECT anunciantes.id, anunciantes.pagina, anunciantes.usuario, anuncios.postagem_anuncio, anuncios.regiao FROM anunciantes
INNER JOIN anuncios ON anunciantes.anuncios_id = anuncios.id;