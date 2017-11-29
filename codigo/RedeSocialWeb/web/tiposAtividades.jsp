<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE><!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<title>Tipo de Atividade</title>

		<style>
body {
    width: 220px;
    height: 220px;
}
select {
    margin-right: 10px;
    padding-right: 20em;
}
fieldset {
    background-color: rgb(236,236,236);
    border: 1;
}
h3 {
    margin-left: 0.8em;
    font-family: arial;
    font-size: 17px;
}
body, input {
    font-family: arial;
    font-size: 14px;
}

input{
    padding: 2px;
    padding-left: 5px;
    border-radius: 4px;
    border-color: #CCC;
}

select{
    width: 180px;
    margin-top: 4px;
    font-family: arial;
    font-size: 14px;
}
.cancelar button {
    background-color: rgb(239,239,239);
    font-family: arial;
    font-size: 14px;
    color: red;
    margin-bottom: 2px;
    margin-left: 40px;
    padding: 2px;
    padding-left: 6px;
    padding-right: 6px;
    border-radius: 5px;
}
.salvar button {
    margin-bottom: 2px;
    margin-left: 123px;
    background-color: rgb(239,239,239);
    font-size: 14px;
    font-family: arial;
    color: rgb(0,220,0);
    border-radius: 4px;
    position: absolute;
    top: 177px;
    padding: 2px;
    padding-left: 6px;
    padding-right: 6px;
}
.campo {
    margin-bottom: 1em;
}
.campo label {
    margin-left: 0.2em;
    margin-bottom: 0.3em;
    color: black;
}
.campo select {
    padding-left: 0.1em;
    padding-right: 0.5em;
    border: 1px solid #CCC;
    box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
    display: block;
    border-radius: 5px;
}
</style>
	</head>
		<body>
			<form action="#" method="post">
				<fieldset>
					<h3>Tipo de Atividade</h3>
					<!--Campos-->
					<div class="campo">
						<label for="atividade">Atividade:</label>
						<input type="text" name="atividade" id="atividade">
					</div>
						<div class="campo">
							<label for="restricao">Restri&ccedil&atildeo:</label>
							<select name="restricao" id="restricao">
								<option value="sim">Sim</option>
								<option value="nao">N&atildeo</option>
							</select>
						</div>
							<div class="cancelar">
								<button type="submit" name="submit" id="cancelar">Cancelar</button>
							</div>
							<div class="salvar">
								<button type="submit" name="submit2" id="salvar">Salvar</button>
							</div>
				</fieldset>
			</form>
		</body>
</html>
