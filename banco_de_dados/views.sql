/* Todos os códigos das views serão adicionados aqui */
/**
 * View para selecionar a quantidade de usuários cadastrados por mês
 * @author Daniel Moreira Cardoso
 */
 
 CREATE VIEW `quantidade_de_usuarios_por_mes` AS
    (SELECT 
        DATE_FORMAT(`usuarios`.`data_cadastro`, '%M') AS `Mês`,
        DATE_FORMAT(`usuarios`.`data_cadastro`, '%y') AS `Ano`,
        COUNT(*) AS `Quantidade de novos usuários`
    FROM
        `usuarios`
    GROUP BY DATE_FORMAT(`usuarios`.`data_cadastro`, '%M-%Y')
    ORDER BY `usuarios`.`data_cadastro`);
	
/**
 * View para selecionar a quantidade de comentários do usuário
 * @author Gusttavo Nunes Gomes
 */
 CREATE VIEW quantidade_de_comentarios_do_usuario AS
	(SELECT
		`usuarios`.`nome` AS `Usuário`,
		COUNT(*) AS `Qtde. Comentários`
		
	FROM 
		`usuarios` 
		INNER JOIN `comentarios` ON `comentarios`.`usuario` = `usuarios`.`id`
		
	GROUP BY `usuarios`.`id`
	ORDER BY `Qtde. Comentários`);
    
/**
 * View para selecionar os aportes mais "upados"
 * @author Andrey Silva Ribeiro
 */
 CREATE VIEW aportes_mais_upados AS
	(SELECT
		`postagens`.`curtidas` AS quantidade_ups,
        `aportes`.`titulo`
	FROM 
		(postagens
        INNER JOIN `aportes` ON `postagens`.`id` = `aportes`.`postagem`)
    ORDER BY `postagens`.`curtidas` desc);
    
    
/**
 * View da quantidade de usuários por sexo
 * @author Andrey Silva Ribeiro
 */
 CREATE VIEW quantidade_usuario_sexo AS
 SELECT sexo, count(sexo) AS qtde
 FROM usuarios
 GROUP BY sexo
 ORDER BY sexo desc;
 
/**
 * View para mostrar os aportes mais visualizados
 * @author Jônatas de Souza Rezende
 */
CREATE VIEW aportes_mais_visualizados AS
SELECT ap.id AS id_aporte, titulo AS titulo_do_aporte, post.visualizacoes AS quantidade_de_visualizacoes 
FROM aportes ap
INNER JOIN postagens post ON ap.postagem = post.id
ORDER BY post.visualizacoes DESC;


/**
 * View para mostrar a quantidade de usuários por estado
 * @author Jônatas de Souza Rezende
 */
CREATE VIEW usuarios_por_estado AS
SELECT est.nome AS estado, pai.nome AS pais, COUNT(est.nome) AS qtde
FROM usuarios us
INNER JOIN cidades cid ON us.cidade = cid.id
INNER JOIN estados est ON cid.estado = est.id
INNER JOIN paises pai ON est.pais = pai.id
GROUP BY est.nome, pai.nome
ORDER BY est.nome;

/**
 * View para mostrar a quantidade de vezes que uma palavra-chave foi usada nas postagens
 * @author Thalia Santos de Santana
 */
create view palavra_chave_postagem as
select palavras_chave.descricao as 'Palavra-chave', count(palavras_chave.descricao) as 'Quantidade' from palavras_chave
inner join postagens_palavras_chave on postagens_palavras_chave.palavra_chave = palavras_chave.id
inner join postagens on postagens_palavras_chave.postagem = postagens.id 
group by palavras_chave.descricao 
order by palavras_chave.descricao desc;

/**
 * View para mostrar a quantidade de vezes que uma palavra-chave foi usada nos aportes
 * @author Thalia Santos de Santana
 */
create view palavra_chave_aporte as
select palavras_chave.descricao as 'Palavra-chave', count(palavras_chave.descricao) as 'Quantidade' from palavras_chave
inner join postagens_palavras_chave on postagens_palavras_chave.palavra_chave = palavras_chave.id
inner join postagens on postagens_palavras_chave.postagem = postagens.id 
inner join aportes on postagens_palavras_chave.postagem = aportes.postagem
group by palavras_chave.descricao 
order by palavras_chave.descricao desc;

/**
 * View para mostrar a quantidade de comentários em uma postagem
 * @author Davi de Faria
 */
 CREATE VIEW `quantidade_de_comentarios_por_postagem` AS
    (SELECT 
        `p`.`descricao` AS `Postagem`,
        COUNT(*) AS `Quantidade de comentários`
    FROM
        (`postagens` `p`
        LEFT JOIN `comentarios` `c` ON ((`p`.`id` = `c`.`postagem`)))
    GROUP BY `p`.`id`);
    
/**
 * View para mostrar a quantidade de comentários em uma postagem
 * @author Gleyson-Alves
 */
CREATE VIEW multidias_por_album_de_usuario AS
SELECT usuarios.nome as usuario, albuns.nome as album, COUNT(multimidias.id) AS qtde_multimidias
FROM multimidias
INNER JOIN albuns ON multimidias.album = albuns.id
INNER JOIN usuarios ON albuns.usuario = usuarios.id
GROUP BY usuarios.nome, albuns.nome
ORDER BY usuarios.nome;

/**
 * View para mostrar a quantidade de cidades por estado
 * @author Adallberto Lucena Moura
 */
CREATE VIEW contador_de_cidades_por_estado AS
SELECT COUNT (*) FROM estados e JOIN cidades c
ON e.id = c.estado;
