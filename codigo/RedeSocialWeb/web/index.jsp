<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            .caixa{
               width: 580px;
               background-color: #fff;
               padding: 20px;
               margin:auto;
               margin-bottom: 90px;
            }
            
            #fundo{
                margin: auto;
                background-color: #fff; 
                width: 100%;
            }
            
            .logo{
                margin-left: 40px;
                width: 100px;
            }
            
            h1{
                font-family: arial;
                margin-left: 18px;
                font-weight: normal;
            }

            .inputCampo{
                background-color: #efefef;
                border: none;
                padding: 10px;
                margin: auto;
                margin-left:50px;
                text-align: center;
                width: 350px;
                margin-bottom: 15px;
            }
            
            .botao{
                background-color: #efefef;
                border: none;
                padding: 10px;
                text-align: center;
                text-decoration-color: black;
                width: 180px;
                margin-bottom: 15px;
                margin-left: 5px;
                
            }
            
            .button{
                margin-left:45px;
                font-weight: bold;
            }
            
            .campos{
                background-color: black;
                padding: 30px;
                border-radius: 10px;
                margin: auto;
                width: 480px;
            }
            
            .rodape {
                background-color: #000000;
                color: #ffffff;
                text-align: center;
                font-size: 15px;
                font-family: arial;
                padding: 8px;
            }
            
            .centro{
                left: 50%;
                margin-left: -100px; /* A metade de sua largura. */
                position: relative;
                width: 100%; /* O valor que você desejar. */
            }
        </style>
    </head>
    <body>
        <div>
            <div id="fundo">
                <div class="caixa">
                    <div class="centro">
                        <img src="<%= request.getContextPath() %>/imagens/logo.png" alt="Logo" class="logo" />
                    </div>
                    <h1>LOGIN:</h1>
                    
                    ${mensagem}
                    
                    <form action="./LoginControle?operacao=Logar" method="post">
                        <div class="campos">
                            <input type="text" placeholder="Telefone ou E-mail" class="inputCampo" name="email" />
                            <input type="password" placeholder="***Senha***" class="inputCampo" name="senha" />
                            
                            <div class="button">
                                <input type="button" class="botao" value="ESQUECEU A SENHA?" />
                                <input type="submit" class="botao" value="ENTRAR" />
                            </div>
                            
                            <div class="button">
                                <input type="button" class="botao" value="REGISTRAR-SE" style="margin-left: 100px; border-radius: 5px;" />
                            </div>    
                        </div>
                    </form>
                </div>    
                <div class="rodape">
		  <p>TERMOS DE USO / OUTRAS LINGUAS</p>
		</div>
            </div>
        </div>
    </body>
</html>
