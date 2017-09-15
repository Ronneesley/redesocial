<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de cidades</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            #fundo{
                background-color: #eee;
                width: 580px;
                padding: 20px;
                margin: auto;
                border-radius: 10px;
            }
            
            .campo{
                padding: 10px;
                border: none;
                background: #fff;
                border-radius: 5px;
                width: 93.7%;
                margin-left: 19px;
                margin-top: 10px;
                margin-bottom: 10px;
            }
            
            .texto{
                width: 90.3%;
            }
            
            .botaoReset{
                font-family: arial;
                font-weight: bolder;
                color:#fff;
                border: none;
                background-color: #ff4c4c;
                padding: 10px;
                border-radius: 5px;
                margin-left: 423px;
            }
            
            .botaoSubmit{
                font-family: arial;
                font-weight: bolder;
                color: #fff;
                border: none;
                background-color: #65d85c;
                padding: 10px;
                border-radius: 5px;
            }
            
            h1{
                font-family: arial;
                font-weight: bolder;
                text-align: center;
                font-size: 24px;
                margin-left: 19px;
            }
            hr{
                width: 93%;
            }
            
            label{
                font-family: arial;
                font-weight: bolder;
                margin-left: 19px;
            }
        </style>
    </head>
    <body>
        ${mensagem}
        
        ${erro}
        
        <div id="fundo">
            <h1>Cadastrar cidade</h1>
            <hr/>
            <form action="CidadeControle?operacao=Cadastrar" method="post">
                <input type="hidden" name="id" value="${cidade.id}" />
                
                <label for="paises">Pa&iacutes:</label>
                <br />
                <select name="paises" class="campo" id="pais" >
                    <option value="${pais.nome}">Selecione o Pa&iacutes</option>
                    
                    <c:forEach items="${paises}" var="pais">
                        <option value="${pais.id}">${pais.nome}</option>
                    </c:forEach>
                </select>
                <label for="estados">Estado:</label>
                <br />
                <select name="estados" class="campo" id="estado" >
                    <option value="${estado.nome}">Selecione o Estado</option>
                    
                    <c:forEach items="${estados}" var="estado">
                        <option value="${estado.id}">${estado.nome}</option>
                    </c:forEach>
                </select>
                <label for="cidade">Cidade:</label>
                <br />
                <input name="cidade" type="text" class="campo texto" id="cidade" placeholder="Digite o nome da cidade" />
                <br/>
                <input type="reset" class="botaoReset" value="Cancelar">
                <input type="submit" class="botaoSubmit" value="Salvar">
                
            </form>
        </div>
    </body>
</html>
