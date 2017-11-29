<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title> Cadastro de Tipos de Atividades</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device=width, initial-scale=1.0">
		<style type="text/css">
			#fundo{
				width: 580px;
				background-color: #eee;
				padding: 20px;
				margin:auto;
				border-radius: 10px;
			}
			
			#meio{
				width: 90%;
				background-color: #ddd;
				padding: 20px;
				margin:auto;
				border-radius: 10px;
				ali: center;
				display:table;
			}
			
			.botao{
				font-family: arial;
				font-size: 16px;
				padding: 5px;
				border-radius: 5px;
				margin: none;
				display:inline-block;
			}
			
			.vermelho{
				background-color: #ff4c4c;
				color: #fff;
			}
			
			.verde{
				background-color: #65d85c;
				color: #fff;
			}
			
			.azul{
				background-color: #3d83e8;
				color: #fff;
			}
			
			.direito{
				margin-left: 450px;	
				margin-top: 10px;
			}
			
			h1{
				font-family: arial;
				font-weigth: bolder;
				font-size: 24px;
				margin-left: 19px;
			}
			
			hr{
				width: 95%;
			}
			
			table{
				margin-left: auto;
				margin-right: auto;
				width: 60;
			}
			
			th{
				background-color: #cecece;
			}
			
			tr{
				background-color: #eee;
			}
			
			a{
				text-decoration: none;
			}
		</style>
		
	</head>
	
	<body>
		<div id="fundo">
			<h1>Listagem de Atividades </h1>
			<hr style="width: 95%;" color="blue" />
			
			<div id="meio">
				<table>
					<tr>
						<th style="width: 25%;">Atividades </th>
						<th style="width: 25%;">Restri&ccedil&atildeo </th>
						<th style="width: 25%;">Op&ccedil;&otilde;es </th>
					</tr>
					
					<tr>
						<td>Design </td>
						<td>Sim </td>
						<td> 
							<a href="#" class="botao vermelho">Apagar</a>
							<a href="#" class="botao verde">Editar</a>
						</td>
					</tr>
					
					<tr>
						<td>Jogos </td>
						<td>N&atildeo</td>
						<td> 
							<a href="#" class="botao vermelho">Apagar</a>
							<a href="#" class="botao verde">Editar</a>
						</td>
					</tr>
					
					<tr>
						<td>Banco de Dados </td>
						<td>N&atildeo </td>
						<td> 
							<a href="#" class="botao vermelho">Apagar</a>
							<a href="#" class="botao verde">Editar</a>
						</td>
					</tr>
					
					<tr>
						<td>Engenharia</td>
						<td>Sim </td>
						<td> 
							<a href="#" class="botao vermelho">Apagar</a>
							<a href="#" class="botao verde">Editar</a>
						</td>
					</tr>
					
					<tr>
						<td>Filosofia</td>
						<td>N&atildeo</td>
						<td> 
							<a href="#" class="botao vermelho">Apagar</a>
							<a href="#" class="botao verde">Editar</a>
						</td>
					</tr>
					
				</table>
					<a href="#" class="botao azul direito" >Voltar</a>
			<div>
			
                    </div>
                </div>
           </div>
	</body>

</html>
© 2017 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
API
Training
Shop
Blog
About