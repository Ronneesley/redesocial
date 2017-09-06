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