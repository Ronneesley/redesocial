CREATE VIEW `redesocial`.`aportesporquantidade` AS
SELECT `redesocial`.`categorias`.`descricao` AS `CATEGORIA`,
COUNT(0) AS `QUANTIDADE` FROM (`redesocial`.`aportes` JOIN `redesocial`.`categorias`)
WHERE (`redesocial`.`aportes`.`categoria` = `redesocial`.`categorias`.`id`)
GROUP BY `redesocial`.`aportes`.`categoria`
