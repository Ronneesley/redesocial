INSERT INTO pagamentos(valor, forma_pagamento, credito)
VALUES  (200, 'Boleto', 155),
		(2500,'Cartao de credito', 10),
        (100,'Boleto', 1),
        (20,'Cartao de credito', 0),
        (340,'Cartao de credito', 85),
        (2050, 'Boleto', 155),
		(400,'Boleto', 103),
        (60,'Boleto', 122),
        (2088,'Boleto', 20),
        (987,'Cartao de credito', 845);
        
        
        
INSERT INTO anuncios(quantidade_visualizacao, publico_alvo, regiao, cliques, data_inicio, data_final, postagem_anuncio, pagamentos_id)
VALUES				(800, 'lojistas', 'centro-oeste', 740, '2017-11-25', '2017-10-30', 'pao de batata', 1),
					(8400, 'varejo', 'sul', 2740, '2017-01-25', '2017-11-30', 'churrasco', 2),
                    (100, 'americanas', 'norte', 140, '2017-02-25', '2017-11-30', 'pao', 3),
                    (500, 'seu ze', 'centro-oeste', 240, '2017-03-25', '2017-11-30', 'arroz', 4),
                    (400, 'atacado', 'centro-oeste', 440, '2017-04-25', '2017-11-30', 'feijao', 5),
                    (200, 'lojistas', 'nordeste', 640, '2017-05-25', '2017-11-30', 'carro', 6),
                    (600, 'lojistas', 'centro-oeste', 840, '2017-06-25', '2017-11-30', 'moto', 7),
                    (100, 'if goiano', 'sul', 40, '2017-07-25', '2017-11-30', 'barco', 8),
                    (1800, 'lojistas', 'centro-oeste', 420, '017-08-25', '017-11-30', 'aviao', 9),
                    (50, 'lojistas', 'centro-oeste', 10, '2017-09-25', '2017-10-30', 'pao de batata', 10);
                    
                    
INSERT INTO anunciantes(pagina, usuario, pagamentos_id, anuncios_id)
VALUES				   ('renova filmes','Andrey Silva',1,1),
					   ('conteudi','Jeferson Rosini',2,2),
                       ('if goiano','Adriano Braga',3,3),
                       ('sistemas','Ronne',4,4),
                       ('conteudo','Rossini Jeferson',5,5),
                       ('renova filmes','Andrey Silva',6,6),
                       ('renova filmes','Andrey Silva',7,7),
                       ('marcafrutas','Jose silva',8,8),
                       ('lojista','Thalia Santana',9,9),
                       ('renova filmes','Andrey Silva',10,10);