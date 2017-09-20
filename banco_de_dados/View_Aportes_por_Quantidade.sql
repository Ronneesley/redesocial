//View Aportes por Quantidade
CREATE VIEW `AportesPorQuantidade` AS
SELECT categorias.descricao, COUNT(*)
FROM aportes, categorias
where aportes.categoria = categorias.id
GROUP BY aportes.categoria;