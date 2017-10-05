/*Dados para teste de view de aportes por quantidades*/

/*Inserção de Artigos*/

INSERT INTO 'artigos' ('idioma','revista','issn','data','area_conhecimento','titulo','resumo','url','artigo','categoria') 
VALUES ('Ingles','VEJA','ABCDEFGHIJKL','06-01-1997 15:38:37','Tecnologia','Informátcia','Sobre informatica basica','www.google.com.br/info','','1');

INSERT INTO 'artigos' ('idioma','revista','issn','data','area_conhecimento','titulo','resumo','url','artigo','categoria') 
VALUES ('Ingles','VEJA','ABCDEFGHIJKL','06-01-1997 15:38:00','Saude','Saude','Sobre saude basica','www.google.com.br/saude','','2');

INSERT INTO 'artigos' ('idioma','revista','issn','data','area_conhecimento','titulo','resumo','url','artigo','categoria') 
VALUES ('Ingles','VEJA','ABCDEFGHIJKLMNOPQRS','06-01-1994 12:38:37','Agroecologia','Agronomia','Sobre agroecologia basica','www.google.com.br/agro','','2');

/*Inserção de Categorias*/

INSERT INTO 'categorias' ('descricao') VALUES ('Informatizacao');
INSERT INTO 'categorias' ('descricao') VALUES ('Saude e Beleza');
INSERT INTO 'categorias' ('descricao') VALUES ('Agropecuaria');

/*Inserção de postagem*/

INSERT INTO 'postagem' ('ups','downs','descricao','data','visualizacoes','usuario') VALUES ('10','20','Status','06-06-1996 15:00:00','50','1');
INSERT INTO 'postagem' ('ups','downs','descricao','data','visualizacoes','usuario') VALUES ('15','10','Offline','05-01-1996 14:00:00','500','1');
INSERT INTO 'postagem' ('ups','downs','descricao','data','visualizacoes','usuario') VALUES ('100','12','Online','07-07-1997 17:00:00','55','2');
INSERT INTO 'postagem' ('ups','downs','descricao','data','visualizacoes','usuario') VALUES ('105','120','Ausente','01-09-1987 11:00:00','550','1');

/*Inserção de aportes*/

INSERT INTO 'aportes' ('titulo','categoria','postagem') VALUES ('Agronomia Basica','2','1');
INSERT INTO 'aportes' ('titulo','categoria','postagem') VALUES ('Agropecuaria Basica','2','2');
INSERT INTO 'aportes' ('titulo','categoria','postagem') VALUES ('Informática','1','1');
