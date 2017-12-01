<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        
        <title>Listagem de Atividades</title>
        <style>
            #fundo{
                background-color: #eee;
                width: 580px;
                padding: 20px;
                margin: auto;
                border-radius: 10px;
            }
            
            h1{
                font-family: arial;
                font-weight: bolder;
                text-align: left;
                font-size: 24px;
                margin-left: 19px;
            }
            hr{
                background-color: #002752;
                height: 1px;
                width: 93%;
            }            
            
            th{
                background-color: #cecece;
            }
            
            table{
                margin: auto;
                border-collapse : collapse;
            }
            
            .botao{
                font-family: arial;
                font-weight: bolder;
                color: #fff;
                border: none;
                padding: 3px;
                border-radius: 2px;
            }
            
            .editar{
                background-color: #65d85c;
            }
            
            .excluir{
                background-color: #ff4c4c;
            }
            
            .voltar{
                padding: 10px;
                border-radius: 5px;
                background-color: #3d83e8;
                margin-left: 500px;
            }
            
            a:link{
                text-decoration: none;
            }
            
            th{
                font-family: arial;
                font-weight: bolder;
                text-align: left;
                height: 20px;
            }
            
            td{
                height: 30px;
                width: 150px;
            }
            
            table{
                width: 70%;
            }
            
            #mensagem{
                margin: auto;
                font-family: arial;
                font-weight: bolder;
                width: 200px;
                background-color: #00FF00;
                text-align: center;
                color: #fff;
                border-radius: 5px;
            }
            
            #erro{
                margin: auto;
                font-family: arial;
                font-weight: bolder;
                background-color: #FF0000;
                width: 93%;
                text-align: center;
                color: #fff;
                border-radius: 5px;
            }
            
        </style>
    </head>
    <body>
        <div id="fundo">
            <h1>Listagem de Atividades</h1>
            <hr/>
            <div id="mensagem">
                ${mensagem}
            </div>
            <div id="erro">
                ${erro}
            </div>
            <br/>            

            <c:if test="${lista != null}">
                <table border="1">
                    <tr>
                        <th style="width: 60%;">Nome</th>
                        <th style="width: 50%;">Op&ccedil;&otilde;es</th>
                    </tr>

                    <c:forEach items="${lista}" var="tiposAtividades">
                        <tr>
                            <td style="font-family: arial;">${tiposAtividades.nome}</td>
                            <td style="text-align: center; font-family: arial;">
                                <a class="botao editar" href="./TiposAtividadesControle?operacao=Editar&amp;id=${tiposAtividades.id}">Editar</a>
                                <a class="botao excluir" href="./TiposAtividadesControle?operacao=Excluir&amp;id=${tiposAtividades.id}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach> 
                </table>
            </c:if>
            <br/>
            <a class="botao voltar" href="./TiposAtividadesControle?operacao=CriarNovo">Voltar<a/>
        </div>
    </body>
</html>
