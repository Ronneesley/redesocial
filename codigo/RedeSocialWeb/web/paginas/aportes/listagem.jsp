<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        
        <title>Listagem de Aportes</title>
        <style>
            #fundo{
                background-color: #eee;
                width: 580px;
                padding: 20px;
                margin: auto;
                border-radius: 10px;
            }
			
			#menu_aporte{				
				background-color: #fff;
				width: 225px;
				height: 275px;
				margin: auto;
				padding: 20px;
				font-family: arial;
				margin-top: -200px;
				margin-right: 77%;
				display: table;
				border: 1px solid;
			}					            
            h1{
                font-family: arial;
                font-weight: bolder;
                text-align: left;
                font-size: 24px;
                margin-left: 19px;
            }
            hr{
                background-color: #002752;
                height: 1px;
                width: 93%;
            }                        
            
            .botao{
                font-family: arial;
                font-weight: bolder;
                color: #fff;
                border: none;
                padding: 3px;
                border-radius: 2px;
            }
            
            .editar{
                background-color: #333333;
            }
            
            .excluir{
                background-color: #333333;
            }
            
            .voltar{
                padding: 10px;
                border-radius: 5px;
                background-color: #666666;
                margin-left: 485px;
            }
			.novo_aporte{
                padding: 10px;
                border-radius: 5px;
                background-color: #666666;
				margin-left: 50px;                
            }
            
            a:link{
                text-decoration: none;
            }
			.link{
				color:#000;
				text-decoration: none;
			}
			
			table{
                margin: auto;
				border-collapse: collapse;
				border: 1px solid black;
				width: 90%;
            }
			
            th{
                font-family: arial;
                font-weight: bolder;
                text-align: left;
                height: 20px;
				border: 1px solid black;
				background-color: #cecece;
            }
            
            td{
                height: 30px;
                width: 150px;
				border: 1px solid black;
            }
            <!--
			
			
            
            
			-->
            
            #mensagem{
                margin: auto;
                font-family: arial;
                font-weight: bolder;
                width: 200px;
                background-color: #00FF00;
                text-align: center;
                color: #fff;
                border-radius: 5px;
            }
            
            #erro{
                margin: auto;
                font-family: arial;
                font-weight: bolder;
                background-color: #FF0000;
                width: 90%;
                text-align: center;
                color: #fff;
                border-radius: 5px;
            }
            
        </style>
    </head>
	
    <body>    	
		<div id="fundo">
            <h1>Listagem de Aportes </h1>			
            <hr/>
            <div id="mensagem">
                ${mensagem}
            </div>
            <div id="erro">
                ${erro}
            </div>
            <br/>            

            <c:if test="${lista != null}">
                <c:forEach items="${lista}" var="aportes">
					<table border="0">                    
                        <tr>
                                <th style="font-family: arial;">${aporte.titulo}</th>							
                        </tr>

                        <tr>                        
                                <td style="font-family: arial;">${postagem.descricao}</td>
                        </tr>

                        <tr>
                                <td style="font-family: arial;"> Por ${usuario.nome} </td>
                        </tr>
                        <tr>
                                <td style="font-family: arial;"> ${postagem.data} </td>
                        </tr>
                        <tr>
                                <td style="font-family: arial;"> ${postagem.visualizacoes} visualiza&ccedil;&otilde;es</td>
                        </tr>
						<!-- 
						<tr>
                            <td style="font-family: arial;">${aporte.titulo}</td>
							<td style="font-family: arial;">${aporte.categoria}</td>
                            <td style="text-align: center; font-family: arial;">
                                <a class="botao editar" href="./AporteControle?operacao=Editar&amp;id=${aporte.id}">Editar</a>
                                <a class="botao excluir" href="./AporteControle?operacao=Excluir&amp;id=${aporte.id}">Excluir</a>
                            </td>
                        </tr>
						-->
                    
					</table>
				</c:forEach> 
            </c:if>
            <br/>
			<a class="botao voltar" href="">Voltar<a/>			
        </div>
		
		<div id = "menu_aporte">
		
            <a class="botao novo_aporte" href="">Novo Aporte &plus;<a/><!--Botao para cadastrar novo aporte-->
			
			<a class="link" href="#"><h3>Meus Aportes</h3></a>			
			<a class="link" href="#"><h5>&mdash; Favoritos</h5></a>
			<a class="link" href="#"><h5>&mdash; Recentes</h5></a>
			<a class="link" href="#"><h5>&mdash; Salvos</h5></a>
			<a class="link" href="#"><h5>&mdash; Lixeira</h5></a>			
			
			<a class="link" href="#"><h3>Categoria de Discuss&atilde;o</h3></a>			
			<a class="link" href="#"><h5>&mdash; Perfil</h5></a>
			<a class="link" href="#"><h5>&mdash; Amigos</h5></a>
			<a class="link" href="#"><h5>&mdash; Comunidades</h5></a>
			<a class="link" href="#"><h5>&mdash; Cole&ccedil;&otilde;es</h5></a>
			<a class="link" href="#"><h5>&mdash; Sugest&otilde;es</h5></a>
			
		</div>
		
    </body>
</html>
