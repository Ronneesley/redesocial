create DATABASE triggers;
connection triggers;
-- -----------------------------------------------------
-- Table `triggers`.`usuario`
-- -----------------------------------------------------
CREATE TABLE usuario(
	id serial not null primary key,
	nome character(200) not null,
	dataCadastro timestamp without time zone
); 

-- -----------------------------------------------------
-- Stored procedure data_cadastro
-- -----------------------------------------------------
CREATE FUNCTION data_cadastro()
returns trigger as $$
Begin 
	NEW.datacadastro = now();
	RETURN NEW;
END;
$$ language 'plpgsql';

-- -----------------------------------------------------
-- Trigger data_cadastro_novo_cliente
-- -----------------------------------------------------

CREATE TRIGGER data_cadastro_novo_cliente
	BEFORE INSERT
	ON usuario
	FOR EACH ROW
	EXECUTE PROCEDURE data_cadastro();

