<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE><!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tipo de Atividade</title>

        <style>
            body {
                width: 220px;
                height: 220px;
                margin: auto;
            }
            select {
                margin-right: 10px;
                padding-right: 10em;
                margin: auto;

            }
            fieldset {
                background-color: rgb(236,236,236);
            }
            h3 {
                margin-left: 0.8em;
                font-family: arial;
                font-size: 19px;
            }
            body, input {
                font-family: arial;
                font-size: 14px;
                margin-bottom: 2px;
            }
            input{
                padding: 2px;
                padding-left: 5px;
                padding-top: 4px;
                border-radius: 6px;
                border-color: #ccc;
                width: 180px;
            }
            select{
                width: 180px;
                margin-top: 4px;
                font-family: arial;
                font-size: 14px;
                padding: 2px;
                margin-left: 2px;
                
            }
            .cancelar button {
                background-color: rgb(239,239,239);
                font-family: arial;
                font-size: 14px;
                color: red;
                margin-bottom: 9px;
                margin-left: 40px;
                padding: 4px;
                margin-top: 8px;
                border-radius: 5px;
            }
            .salvar button {
                margin-bottom: 2px;
                margin-left: 123px;
                background-color: rgb(239,239,239);
                font-size: 14px;
                font-family: arial;
                color: rgb(0,220,0);
                border-radius: 4px;
                position: absolute;
                top: 200px;
                padding: 4px;
                padding-left: 6px;
                padding-right: 6px;
            }
            .campo {
                margin-bottom: 0.8em;
                border-radius: 2px;
                border-color: red;
            }
            .campo label {
                margin-left: 0.2em;
                margin-bottom: 0.2em;
                padding: 1px;
                color: black;
                font-weight: bolder;
                
            }
            .campo select {
                padding-left: 0.1em;
                padding-right: 0.5em;
                border: 1px solid #CCC;
                box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
                display: block;
                border-radius: 5px;
                border-color: black;
            }
        </style>
    </head>
    <body>
        <form action="TiposAtividadesControle?operacao=Cadastrar" method="post">
            <input type="hidden" name="id" value="${tiposAtividades.id}" />
            <fieldset>
                <h3>Tipo de Atividade</h3>
                <!--Campos-->
                <div class="campo">
                    <label for="tiposAtividades">Atividade:</label>
                    <input type="text" name="nome" id="tiposAtividades" value="${tipos.Atividades.nome}" placeholder="Digite a atividade">
                </div>
                <br/>
                <div class="campo">
                    <label for="restricao">Restri&ccedil&atildeo:</label>
                    <select name="restricao" id="restricao" value="${tiposAtividades.restricao}">
                        <option value="sim">Sim</option>
                        <option value="nao">N&atildeo</option>
                    </select>
                </div>
                <div class="cancelar">
                    <button type="reset" name="submit" id="cancelar">Cancelar</button>
                </div>
                <div class="salvar">
                    <button type="submit" name="submit2" id="salvar">Salvar</button>
                </div>
                <br> 
                     ${mensagem}
                     ${erro}
            </fieldset>
        </form>
    </body>
</html>
