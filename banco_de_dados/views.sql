/* Todos os códigos das views serão adicionados aqui */
/**
 * View para selecionar a quantidade de usuários cadastrados por mês
 * @author Daniel Moreira Cardoso
 */
 
 CREATE VIEW `quantidade_de_usuarios_por_mes` AS
    (SELECT 
        DATE_FORMAT(`usuarios`.`data_cadastro`, '%M/%Y') AS `Mês_Ano`,
        COUNT(*) AS `Quantidade de novos usuários`
    FROM
        `usuarios`
    GROUP BY `Mês_Ano`
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
		((usuarios 
		INNER JOIN `postagens` ON `usuarios`.`id` = `postagens`.`usuario`)
		INNER JOIN `comentarios` ON `comentarios`.`postagem` = `postagens`.`id`)
	GROUP BY `usuarios`.`id`
	ORDER BY `Qtde. Comentários`);
    
/**
 * View para selecionar os aportes mais "upados"
 * @author Andrey Silva Ribeiro
 */
 CREATE VIEW aportes_mais_upados AS
	(SELECT
		`postagens`.`curtidas` AS `Quantidade de UPs`,
        `aportes`.`titulo` AS `Titulo do aporte`
	FROM 
		(postagens
        INNER JOIN `aportes` ON `postagens`.`id` = `aportes`.`postagem`)
	GROUP BY `aportes`.`titulo`
    ORDER BY `postagens`.`curtidas`);
    
/**
 * View para mostrar os aportes mais visualizados
 * @author Jônatas de Souza Rezende
 */
CREATE VIEW aportes_mais_visualizados AS
SELECT ap.id AS id_aporte, titulo AS titulo_do_aporte, post.visualizacoes AS quantidade_de_visualizacoes 
FROM aportes ap
INNER JOIN postagens post ON ap.postagem = post.id
ORDER BY post.visualizacoes DESC
LIMIT 1;

/**
 * View para mostrar a quantidade de usuários por estado
 * @author Jônatas de Souza Rezende
 */
CREATE VIEW usuarios_por_estado AS
SELECT est.nome AS Estado, pai.nome AS Pais, COUNT(est.nome) AS Qtde
FROM usuarios us
INNER JOIN cidades cid ON us.cidade = cid.id
INNER JOIN estados est ON cid.estado = est.id
INNER JOIN paises pai ON est.pais = pai.id
GROUP BY est.nome
ORDER BY est.nome;