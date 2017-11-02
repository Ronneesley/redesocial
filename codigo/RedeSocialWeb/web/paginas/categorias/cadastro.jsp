<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Categorias</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="CategoriaControle?operacao=Cadastrar" method="post">
            <h1>Cadastro de Categorias</h1>
            
            ${mensagem}

            ${erro}
            
            <input type="hidden" name="id" value="${categoria.id}" />
            
            Descri&ccedil;&atilde;o: <br />
            <input type="text" name="descricao" value="${categoria.descricao}" />
            <br /><br />
            
            <input type="button" value="Cancelar" />
            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
