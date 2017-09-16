<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
            <title>Rede Social</title>
            
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"> 
            <link rel="stylesheet" type="text/css" href="css/estilo_feed.css">
            <link href='http://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>
                
            <script type="text/javascript">
                function publicar(){
                    var divPostagem = document.getElementById("postagem");
                    
                    divPostagem.style.display = "block";
                }
            </script>
	</head>
	
	<body>
	
	<div id="geral">
	
            <header>	
                <div id="barra_ferramentas">
                    <img class="rounded float-left logo" src="imagens/logo2.png" alt="imagem da logo" width="124px" height="24px;" />
                    <a href="teste_link.html" target="_blank"><img class="icones_ferramentas" src="imagens/icones1.jpg" alt="imagens dos icones" width="30px" height="30px;"/></a>
                    <a href="./solicitacaoAmizade.html" ><img  src="imagens/icones2.jpg" alt="imagens dos icones" width="30px" height="30px;"/></a>
                    <a href="./mensagem.html"><img  src="imagens/icones3.jpg" alt="imagens dos icones" width="30px" height="30px;"/></a>
                    <a href="./perfil.html"><img class="icone_perfil" src="imagens/icones4.jpg" alt="imagens dos icones" width="50px" height="40px;"/></a>
		</div>
            </header>
		
            <div id="lado_esquerdo">
		<div id="bloco">
                    <div id="resumo_perfil">
			<a href="./perfil.html"><img class="resumo_perfil_foto" src="imagens/reumo_perfil.jpg" alt="imagens dos icones" width="150px" height="150px;"/></a>
			<a href="./perfil.html"><h3 class="perfil">${usuario.nome}</h3></a>
			<a href="http://www.renovafilmes.com" target="_blank"><h6>${usuario.email}</h6></a>					
                            <div id="resumo_publicacao">
				<div id="resumo_p">
                                	<a href="./post.html"><h4 class="resumo">76 Posts</h4></a>
					<a href="./teste_link.html"><h4 class="resumo">7 Aportes</h4></a>
					<a href="./teste_link.html"><h4 class="resumo">3 Artigos</h4></a>
				</div>
                            </div>
                    </div>								
                </div>

		<div id="botao_resumo_perfil">
                    <button type="button" class="btn btn-light" onclick="publicar()">Publicar</button>
                    <button type="button" class="btn btn-light">Novo Aporte</button>
                    <button type="button" class="btn btn-light">Enviar Artigo</button>
		</div>
			
		<div id="resumo_pub">
                    <button type="button" class="btn btn-light ">Aportes Favoritos</button>
                    <button type="button" class="btn btn-light">Mensagens</button>
                    <button type="button" class="btn btn-light">Amigos</button>				
                    <div id="mostra_resumo">
			<iframe src="./teste_link.html"></iframe>
                    </div>
		</div>
            </div>
		
            <div id="central">
                <jsp:include page="postagem.jsp" />
                    
                <c:forEach items="${postagens}" var="postagem">
                <div id="post">
                    <img class="post_foto" src="imagens/reumo_perfil.jpg" alt="imagens dos icones" width="50" height="50"/>

                    <div class="post_info">
                        ${postagem.usuario.nome}<br />
                        ${postagem.data} 50 min.<br />
                    </div>

                    <div id="container-post">
                        <p>${postagem.descricao}</p>
                    </div>
                    
                </div>
                    </c:forEach>                    
                    
                    <!--
                    <div id="post">
                        <img class="post_foto" src="imagens/reumo_perfil.jpg" alt="imagens dos icones" width="50" height="50"/>
                                
                        <div class="post_info">
                            Andrey Ribeiro<br />
                            50 min <br />
                        </div>
					
                        <div id="container-post">
                        <p>Muito satisfeito com a receptividade do projeto. Às pessoas que foram me ouvir durante o Workshop
                        de Inteligência Artificial: pesquisadores, alunos de mestrado e doutorado, alunos de graduação, empresários, comunidade em geral,
                        muito obrigado pela atenção, vocês fora muito legais.</p>

                        <div id="reacao">

                                <img src="imagens/up.png" width="15px" height="15px;" alt="icone up" /> Maria e outras 20 pessoas deram UP

                        </div>

                        <div id="comentario">

                                <a href="teste_link.html" target="_blank"><img  src="imagens/amigos_susgetao.jpg" width="60px" height="60x;" style="border-radius: 3%;" /></a>

                    </div>
						<div id="comentario_info">
							Maria Carolina 							
						</div>
						
						<div id="comentario_tempo">
							20min							
						</div>	
						<input id="caixa_comentario" type="text"  value="Tu é um gênio menino, espera um pouco que vou investir nessas tecnologias">
							
                </div>

			</div>
			
			<div id="post">
				<img class="post_foto" src="imagens/reumo_perfil.jpg" alt="imagens dos icones" width="50" height="50"/>
                                
                    <div class="post_info">
                        Andrey Ribeiro<br />
                        50 min <br />
                    </div>
					
					<div id="container-post">
                    <p>Muito satisfeito com a receptividade do projeto. Às pessoas que foram me ouvir durante o Workshop
					de Inteligência Artificial: pesquisadores, alunos de mestrado e doutorado, alunos de graduação, empresários, comunidade em geral,
					muito obrigado pela atenção, vocês fora muito legais.</p>
                    					
					<div id="reacao">
						
						<img src="imagens/up.png" width="15px" height="15px;" alt="icone up" /> Maria e outras 20 pessoas deram UP
						
					</div>
					
					<div id="comentario">
					
						<a href="teste_link.html" target="_blank"><img  src="imagens/amigos_susgetao.jpg" width="60px" height="60x;" style="border-radius: 3%;" /></a>
						
					</div>
						<div id="comentario_info">
							Maria Carolina 							
						</div>
						
						<div id="comentario_tempo">
							20min							
						</div>	
						<input id="caixa_comentario" type="text"  value="Tu é um gênio menino, espera um pouco que vou investir nessas tecnologias">
							
                </div>
                   
			</div>
			-->
			
		</div>
		
            <div id="direita">
		<input id="buscar_timeline" type="text" name="buscar" size="40" value="Buscar">			
                <div id="bloco_direita">
                    <p><a href="./perfil.html">Perfil</a></p>
                    <p><a href="teste_link.html" target="_blank">Lattes</a></p>
                    <p><a href="./mensagem.html" >Mensagens</a></p>
                    <p><a href="teste_link.html" target="_blank">Amigos</a></p>
                    <p><a href="./teste_link.html">Aportes</a></p>
                    <p><a href="./galeria.html" >Minhas Fotos</a></p>
                    <p><a href="teste_link.html" target="_blank">Vídeos</a></p>
                    <p><a href="teste_link.html" target="_blank">Páginas</a></p>
                    <p><a href="teste_link.html" target="_blank">Artigos Salvos</a></p>    		
                </div>			
            </div>			
	</div>		
	
	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>