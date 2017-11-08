<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<html>
    <head>
        <title>Fotos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            *{font-family: arial; font-size: 14px;}
            #timeline{
               width: 560px;
               background-color: #eee;
               padding: 20px;
               margin:auto;
               display: flex;
               align-items: center;
            }
            
            .btn{
                background: rgba(0,0,0,0); 
                border: 2px solid #cecece;
                padding: 5px;
                margin-right: 5px;
            }
            
            .galeria{
                width: 100%;
                background-color: #fff;
                margin: auto;
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 40px;
                padding-bottom: 30px;
                align-items: center;
            }
            
            .imagem{
                max-width: 169px;
                padding: 1px;
            }
            
            .opcoes{
                max-width: 40px;
                display: compact;
            }
            
            .cabeca{
                width: 100%;
                margin: auto;
                border: 45px;
                display: flex;
                align-items: center;
                align-content: flex-start;
            }
            
            h1{
                font-family: Arial;
                font-size: 19px;
                display: inline;
                padding: 10px;
                margin: 5px
            }
            
            h2{
                font-family: Arial;
                font-size: 12px;
                display:inline;
                padding: 8px;
            }
            
            a{
                width: 30%;
                text-decoration: none;
                color: black;
                margin: 5px;
                margin-bottom: 2px;
                display: inline-block;
            }
            
            
            select{
                background:#eee;
                border:none;
                width: 38px;
                font-family: arial;
                font-size: 15px;
            }
            
            .albuns{
                width:100%;
                align-items: center;
                text-align: center;
                margin: auto;
            }
            
            hr{
                padding: 1px;   
                background-color: black;
            }
            
            .navi{
                width: 20%;
            }
            
        </style>
    </head>
    
    <body>
        ${mensagem}
        ${erro}
        <div id="timeline">
            <input type="hidden" value="${album.id}" name="album"/>
            <div class="galeria">
                <div class="cabeca">
                    <h1>${album.nome}</h1>
                    <a  class="btn navi" href="#">Suas fotos</a>
                    <a  class="btn navi" href="../RedeSocialWeb/AlbumControle?operacao=Listar">Seus Álbuns</a>
                    <a  class="btn navi" href="../RedeSocialWeb/AlbumControle?operacao=CriarNovo">Criar Álbum</a>
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
        </div>
    </body>
</html>