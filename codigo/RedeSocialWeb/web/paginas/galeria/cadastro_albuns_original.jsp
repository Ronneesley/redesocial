<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Álbum</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            #timeline{
               width: 580px;
               background-color: #eee;
               padding: 20px;
               margin:auto;
            }
            
            .galeria{
                width: 90%;
                background-color: #fff;
                margin: auto;
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 40px;
                padding-bottom: 30px;
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
                margin: 10px;
                border: 45px;
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
            
            .btn{
                background: rgba(0,0,0,0); 
                border: 2px solid #cecece;
                padding: 5px;
                margin-right: 5px;
            }
        </style>
    </head>
    <body>
        ${mensagem}
        ${erro}
        <div id="timeline">
            
            <div class="galeria">
                <div class="cabeca">
                    <h1>Cadastrar Álbum</h1>
                    <a href="#"><h2>Suas fotos</h2></a>
                    <a href="../../RedeSocialWeb/AlbumControle?operacao=Listar"><h2>Seus Álbuns</h2></a>
                    <a href="../../AlbumControle?operacao=CriarNovo"><h2>Criar Álbum</h2></a>
                    <select>
                        <option value="#">...</option>
                        <option value="#">Editar</option>
                        <option value="#">Deletar</option>
                        <option value="#">Álbuns Selecionados</option>
                    </select>
                </div>	
                    <form action="AlbumControle?operacao=Cadastrar" method="post">
                        <input type="hidden" name="id" value="${album.id}" />
                        <label for="nomeAlbum">Digite o nome do Álbum: </label>
                        <input type="text" id="album" name="album" value="${album.nome}"/>


                        <input type="submit" class="btn" data-dismiss="modal" value="Criar"/>
                    </form>	
            </div>
        </div>
    </body>
</html>
