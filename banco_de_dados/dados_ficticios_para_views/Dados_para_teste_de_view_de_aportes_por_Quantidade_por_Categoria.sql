/*Dados para teste de view de aportes por quantidades*/

/*Inserção de Artigos*/

INSERT INTO 'artigos' (idioma,revista,issn,data,area_conhecimento,titulo,resumo,url,categoria) 
VALUES ('Ingles','VEJA','ABCDEFGHIJKL','1999-01-20','Tecnologia','Informátcia','Sobre informatica basica','www.google.com.br/info','','1');

INSERT INTO 'artigos' (idioma,revista,issn,data,area_conhecimento,titulo,resumo,url,categoria) 
VALUES ('Ingles','VEJA','ABCDEFGHIJKL','1994-02-23','Saude','Saude','Sobre saude basica','www.google.com.br/saude','','2');

INSERT INTO 'artigos' (idioma,revista,issn,data,area_conhecimento,titulo,resumo,url,categoria) 
VALUES ('Ingles','VEJA','ABCDEFGHIJKLMNOPQRS','1997-06-01','Agroecologia','Agronomia','Sobre agroecologia basica','www.google.com.br/agro','','2');

/*Inserção de Categorias*/

INSERT INTO categorias (descricao) VALUES ('Informatizacao');
INSERT INTO categorias (descricao) VALUES ('Saude e Beleza');
INSERT INTO categorias (descricao) VALUES ('Agropecuaria');

/*Inserção de postagem*/

INSERT INTO postagem (ups,downs,descricao,data,visualizacoes,usuario) VALUES ('10','20','Status','1999-09-09','50','1');
INSERT INTO postagem (ups,downs,descricao,data,visualizacoes,usuario) VALUES ('15','10','Offline','1997-03-03','500','1');
INSERT INTO postagem (ups,downs,descricao,data,visualizacoes,usuario) VALUES ('100','12','Online','1997-02-01','55','2');
INSERT INTO postagem (ups,downs,descricao,data,visualizacoes,usuario) VALUES ('105','120','Ausente','1997-06-01','550','1');

/*Inserção de aportes*/

INSERT INTO aportes (titulo,categoria,postagem) VALUES ('Agronomia Basica','2','1');
INSERT INTO aportes (titulo,categoria,postagem) VALUES ('Agropecuaria Basica','2','2');
INSERT INTO aportes (titulo,categoria,postagem) VALUES ('Informática','1','1');
