<%-- 
    Document   : listagem_paises
    Created on : 06/09/2017, 17:36:20
    Author     : Ronneesley Moura Teles, Daniel Moreira Cardoso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        
        <title>Listagem de Pa&iacute;ses</title>
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
            
            .tdpaisnome{
                width: 200px;
                font-family: arial;               
            }
            
            .tdbotoes{
                text-align: center;
            }
            
            #mensagem{
                margin: auto;
                font-family: arial;
                font-weight: bolder;
                padding: 6px;
                background-color: #00FF00;
                text-align: center;
                color: #fff;
                border-radius: 5px;
            }
            
        </style>
    </head>
    <body>
        <div id="fundo">
            <h1>Listagem de Pa&iacute;ses</h1>
            <hr/>
            <div id="mensagem">
                ${mensagem}
            </div>

            ${erro}

            <c:if test="${lista != null}">
                <table border="1">
                    <tr>
                        <th>Nome</th>
                        <th>Op&ccedil;&otilde;es</th>
                    </tr>

                    <c:forEach items="${lista}" var="pais">
                        <tr>
                            <td class="tdpaisnome">${pais.nome}</td>
                            <td class="tdbotoes">
                                <a class="botao editar" href="./PaisControle?operacao=Editar&amp;id=${pais.id}">Editar</a>
                                <a class="botao excluir" href="./PaisControle?operacao=Excluir&amp;id=${pais.id}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach> 
                </table>
            </c:if>
            <br/>
            <a class="botao voltar" href="">Voltar<a/>
        </div>
    </body>
</html>
