<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de usu&aacute;rios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        ${mensagem}
        
        <form action="UsuarioControle?operacao=Cadastrar" method="post">
            <label for="nome">Nome</label>
            <input type="text" name="nome" value="${usuario.nome}" id="nome" placeholder="Digite seu nome" />
            <br />
            
            <label for="email">E-mail</label>
            <input type="text" name="email" value="${usuario.email}" id="email" placeholder="Digite seu e-mail" />
            <br />
            
            <label for="senha">Senha</label>
            <input type="password" name="senha" value="" id="senha" placeholder="Digite uma senha" />
            <br />
            
            <input type="submit" value="Cadastrar" />
        </form>
    </body>
</html>
