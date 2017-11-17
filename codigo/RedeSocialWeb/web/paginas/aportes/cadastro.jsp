<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
            <title>Cadastro Aporte</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css"href="/RedeSocialWeb/paginas/aportes/style.css"/>
	</head>


	<body id="cantos">
		<div id="cabecalho">
                    <img src="/RedeSocialWeb/paginas/aportes/logo_rede.png" class="logo"/>
                    <img src="/RedeSocialWeb/paginas/aportes/foto.png" class="fotoUsuario"/>

                    <input id="direitaCabecalho" type="reset" name="voltar" class="botaoVoltar" value="Voltar" />
                    &ensp;&ensp;
                    <input type="reset" name="sair" class="botao" value="Sair"/>
                        <form>
                            <div id="info">
                                <input class="campoInfo" type="text" name="" placeholder="Mais Informa&ccedil;&otilde;es"><input class="botaoInfo" type="button" name="" value="">
                            </div>
                        </form>
		</div>

		<br><br>

		<div id="meio">
                    <form action="AporteControle?operacao=Cadastrar" method="post">
                        ${mensagem}

                        ${erro}
                        <h1 id="center"> Cria&ccedil;&abreve;o de novo aporte</h1>
                            <input type="hidden" name="id" value="${aporte.id}" />
                            
                            <hr style="width: 95%" />
                            <br><br>
                            <b id="center">T&iacute;tulo</b> (Campo Obrigat&oacute;rio *)
                           
                            <br/>
                            <input id="center" class="campo" type="text" name="titulo" value="${aporte.titulo}"/>
                            <br/><br/>
                           
                            <b id="center">Categoria</b> (Campo Obrigat&oacute;rio *)
                            <br/>
                           
                            <select id="center" name="categorias">
                                <option value="Selecione a categoria">Selecione a categoria</option>
                                <c:forEach items="${categorias}" var="categoria">
                                    <option value="${categoria.id}">${categoria.descricao}</option>
                                </c:forEach>
                            </select>

                            <br/><br/>
                            <b id="center">Arquivos de m&iacute;dia</b> (Opcional)
                            <br/>
                            <input id="center" class="campoMidia" type="text" name="midia" placeholder="Descri&ccedil;&abreve;o do Arquivo" />

                            <input id="center" class="botaoUpload" type="button" name="upload" value="Upload">
                            <br/><br/>

                            <b id="center">Descri&ccedil;&abreve;o</b> (Opcional)
                            <br/>
                            <textarea id="center" class="campoDescricao" type="text" name="descricao" value${postagem.descricao}/> </textarea>
                            <br/><br/>
                            <b id="center">Palavras Chaves</b> (Opcional)
                            <br/>

                            <input id="center" class="campo" type="text" name="palavras_chaves"/>
                            <br/><br/>
                            <input id="direita"  type="reset" class="botao" value="Cancelar"/>
                            &ensp;&ensp;
                            <input  type="submit" class="botao" value="Enviar"/>
                    </form>
		</div>

		<div id="opcoes">

			<a class="link" href="#">Amigos</a>
			<br/><br/>
			<a class="link" href="#"><b>Aportes</b></a>
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
			<a class="link" href="#">Minhas Fotos</a>
			<br/><br/>
			<a class="link" href="#">Perfil</a>
			<br/><br/>
                        <a class="link" href="#">P&aacute;ginas</a>
			<br/><br/>
                        <a class="link" href="#">V&iacute;deos</a>

		</div>
	</body>
</html> 