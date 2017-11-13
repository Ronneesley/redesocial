<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<html>
    <head>
        <title>Fotos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
			#cantos{
				padding: 0 ;
				margin: 0 ;
			}

			#cabecalho{
				background-color: #ccc;
				width: 100%;
				height: 75px;
			}
			#info{
				margin-top: -80px;
				padding: 50px;
				right:  300px;
				margin-left: -38px;
				margin-top: -85px;
				display: block;  
			}
			#galeria{
				background-color: #fff;
				width: 600px;
				height: 400px;
				margin: auto;
				display: table;
				border: 1px solid;
				font-family: arial;
				margin-left: 16%;
				padding: 19px;
			}
			#opcoes{
				background-color: #fff;
				width: 130px;
				height: 280px;
				margin: auto;
				padding: 20px;
				font-family: arial;
				margin-top: -442px;
				margin-left: 72%;
				display: table;
				border: 1px solid;
			}
			#direita{
				margin-left: 64%;
			}
			#topobotao{
				margin-left: 77%;
				margin-top: 20px;
			}
			#center{
				margin-left: 3%;
			}
			.botao{
				color: #fff;
				width: 80px;
				height: 30px;
				font-family: arial;
				font-weight: bolder;
				background-color: #666;
				padding: 10px;
				border: none;
				border-radius: 1px;
				left: 85%;
			}
			.botaoInfo{
				width: 30px;
				height: 30px;
				background-color: #4589CC;
				display: block;     
				padding: 10px;
				margin-top: 10px;
				border: none; 
				display: inline;
			}
			.botaoVoltar{
				color: #fff;
				width: 80px;
				height: 30px;
				font-family: arial;
				font-weight: bolder;
				background-color: #999;
				padding: 10px;
				border: none;
				border-radius: 1px;
				left: 85%;				
			}
			.btn{
				color: #fff;
				width: 50px;
				height: 23px;
				font-family: arial;
				font-weight: bolder;
				background-color: #999;
				padding: 10px;
				border: none;
				border-radius: 1px;
				left: 85%;
				padding: 5px;
			}
			.campoInfo{
				background-color: #ddd;
				margin-left: 16%;
				width: 300px;
				height: 30px;
				margin-bottom: 100px;
				padding: 0px;
				border:none;

			}
			.conteudogaleria{
				background-color: #fff;
				width: 550px;
				height: 400px;
				margin: auto;
				display: table;
				border: 1px solid;
				font-family: arial;
				margin-left: 4%;
				padding: 1px;
			}
			.link{
				color:#000;
				text-decoration: none;
			}
			.logo{
				width: 100px; /*Largura*/
				height: 90px;/*Altura*/
				position: absolute;
				left:40px;
				top:20px;
			}
			.fotoUsuario{
				width: 40px;
				height: 40px;
				position: absolute;
				border-radius: 40px; /*Arredonda as bordas*/
				left:93%;
				top: 15px;
			}
			.topo_galeria{
				margin: 10px;
				border: 45px;
			}
			h1{
				font-family: arial;
				font-size: 19px;
				display: inline;
				padding: 10px;
				margin: 5px;
			}
			h2{
				font-family: Arial;
				font-size: 12px;
				display:inline;
				padding: 8px;
			}
            img{
                width: 30%;
                text-decoration: none;
                color: black;
                margin: 5px;
                margin-bottom: 2px;
                display: inline-block;
            }			
			a{
				text-decoration: none;
				color: black;
			}            
			select{
				background:#eee;
				border:none;
				width: 38px;
				font-family: arial;
				font-size: 15px;
			}
			label{
				font-family: Arial;
				display: inline;
			}
            .albuns{
                width:100%;
                align-items: center;
                text-align: center;
                margin: auto;
            }
            .imagem{
                max-width: 169px;
                padding: 1px;
            }
        </style>
    </head>
    
    <body id="cantos">
        ${mensagem}
        ${erro}
        
        <div id="cabecalho">
            <input type="hidden" value="${album.id}" name="album"/>
            <img src="../../RedeSocialWeb/paginas/galeria/logo_rede.png" class="logo"/>
            <img src="../../RedeSocialWeb/paginas/galeria/foto.png" class="fotoUsuario"/>

			<input id="topobotao" type="reset" name="voltar" class="botaoVoltar" value="Voltar" />
			&ensp;&ensp;
			<input type="reset" name="sair" class="botao" value="Sair"/>
				<form>
					<div id="info">
						<input class="campoInfo" type="text" name="" placeholder="Mais Informações"><input class="botaoInfo" type="button" name="" value="">
					</div>
				</form>
		</div>

		<br><br>            
            
        <div id="galeria">
				
            <div class="topogaleria">
					
                <h1>${album.nome}</h1>
                <a  href="#">Suas fotos</a>
                <a  href="../RedeSocialWeb/AlbumControle?operacao=Listar">Seus Álbuns</a>
                <a  href="../RedeSocialWeb/AlbumControle?operacao=CriarNovo">Criar Álbum</a>
                <select>
                    <option value="#">...</option>
                    <option value="#">Editar</option>
                    <option value="#">Deletar</option>
                    <option value="#">Álbuns Selecionados</option>
                </select>
            </div>
                
            <hr/> <br/>
        
            <div class="albuns">
                    
                <a href="./MultimidiaControle?operacao=CriarNovo&amp;idalbum=${album.id}" id="${album.id}">
                    <img url="../../imagens/adicionar-botao.jpg" alt="Adicionar mídias..." class="imagem" />
                </a>
                    
                <a href="../../imagens/usuario.jpg" target="_blank">
                    <img src="../../imagens/usuario.jpg" alt="imagem" class="imagem" />
                </a>
                <a href="../../imagens/usuario.jpg" target="_blank">
                    <img src="../../imagens/usuario.jpg" alt="imagem" class="imagem" />
                </a>
                <a href="../../imagens/usuario.jpg" target="_blank">
                    <img src="../../imagens/usuario.jpg" alt="imagem" class="imagem" />
                </a>
                <a href="../../imagens/usuario.jpg" target="_blank">
                    <img src="../../imagens/usuario.jpg" alt="imagem" class="imagem" />
                </a>
                <a href="../../imagens/usuario.jpg" target="_blank">
                    <img src="../../imagens/usuario.jpg" alt="imagem" class="imagem" />
                </a>
            </div>
            
        </div>
        
        
        <div id="opcoes">

			<a class="link" href="#">Amigos</a>
			<br/><br/>
			<a class="link" href="#">Aportes</a>
			<br/><br/>
			<a class="link" href="#">Artigos</a>
			<br/><br/>
			<a class="link" href="#">Eventos</a>
			<br/><br/>
			<a class="link" href="#">Grupos</a>
			<br/><br/>
			<a class="link" href="#">Lattes</a>
			<br/><br/>
			<a class="link" href="#">Mensagens</a>
			<br/><br/>
			<a class="link" href="#"><B>Minhas Fotos</B></a>
			<br/><br/>
			<a class="link" href="#">Perfil</a>
			<br/><br/>
			<a class="link" href="#">Páginas</a>
			<br/><br/>
			<a class="link" href="#">Vídeos</a>
        
        </div>
    </body>
</html>
