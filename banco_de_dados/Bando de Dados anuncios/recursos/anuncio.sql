CREATE DATABASE anuncio;

USE anuncio;

CREATE TABLE pagamentos(
	id INT NOT NULL  AUTO_INCREMENT,
    valor DECIMAL(60) NOT NULL,
    forma_pagamento VARCHAR(45) NOT NULL,
    credito DECIMAL(60),
    PRIMARY KEY (id)
);
    
CREATE TABLE anuncios(
	id INT NOT NULL  AUTO_INCREMENT,
    quantidade_visualizacao INT NOT NULL,
    publico_alvO VARCHAR(45),
    regiao VARCHAR(45) NOT NULL,
    cliques INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_final DATE NOT NULL,
    postagem_anuncio VARCHAR(200) NOT NULL,
    pagamentos_id INT NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_anuncios_pagamentosl_idx (pagamentos_id ASC),
	CONSTRAINT fk_anuncios_pagamentos1
		FOREIGN KEY (pagamentos_id)
        REFERENCES pagamentos (id)
);

CREATE TABLE anunciantes(
	id INT NOT NULL AUTO_INCREMENT,
    pagina VARCHAR(45) NOT NULL,
    usuario VARCHAR(45) NOT NULL,
    pagamentos_id INT NOT NULL,
    anuncios_id INT NOT NULL,
    PRIMARY KEY (id, pagamentos_id),
    INDEX fk_anunciantes_pagametnos_idx (pagamentos_id ASC),
    INDEX fk_anunciantes_anuncios1_idx (anuncios_id ASC),
    CONSTRAINT fk_anunciantes_pagamentos
		FOREIGN KEY (pagamentos_id)
        REFERENCES anuncio.pagamentos (id),
	CONSTRAINT fk_anunciantes_anuncios1
		FOREIGN KEY (anuncios_id)
        REFERENCES anuncio.pagamentos (id)
);