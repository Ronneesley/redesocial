<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title> Cadastro de Estados </title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            #fundo{
                width: 580px;
                background-color: #eee;
                padding: 20px;
                margin:auto;
                border-radius: 10px;
            }
            
            .botaoSubmit{
                font-family: arial;
                font-weight: bolder;
                color: #fff;
                border: none;
                background-color: #65d85c;
                padding: 10px;
                border-radius: 5px;
            }
            
            .botaoReset{
                font-family: arial;
                font-weight: bolder;
                color: #fff;
                border: none;
                background-color: #ff4c4c;
                padding: 10px;
                border-radius: 5px;
                margin-left: 420px;    
            }
            
            .campo{
                padding: 10px;
                border: none;
                background: #fff;
                border-radius: 5px;
                width: 90%;
                margin-left: 19px;
                margin-top: 10px;
                margin-bottom: 10px;
            }
            
            label{
                font-family: arial;
                font-weight: bolder;
                margin-left: 19px;
            }
            
            h1{
                font-family: arial;
                font-weight: bolder;
                font-size: 24px;
                margin-left: 19px;
				text-align: center;
            }
            
            hr{
                width: 93%;
            }
        </style>
	</head>
	
	<body>
                ${mensagem}
            
		<div id="fundo">
		<h1> Cadastro de Estados</h1>
		<hr />
		<form action="EstadoControle?operacao=Cadastrar" method="post">
			<label for="pais">Pa&iacutes:</label>
			<br />
			<select tabindex="1" name="pais" class="campo" id="pais" >
				<option value="Selecione o Pais">Selecione o Pa&iacutes</option>
                                
                                <c:forEach items="${paises}" var="pais">
                                    <option value="${pais.id}">${pais.nome}</option>
                                </c:forEach>
			</select>
			 <label for="estado">Estado:</label>
                <br />
                <input tabindex="1" name="estado" type="text" class="campo" id="estado" placeholder="Digite o nome do estado" />
			<br />
			
			<input tabindex="3" type="reset" class="botaoReset" value="Cancelar" />
			<input tabindex="2" type="submit" class="botaoSubmit" value="Salvar" />
		</form>
		
		</div>		
	</body>
	
	
</html>