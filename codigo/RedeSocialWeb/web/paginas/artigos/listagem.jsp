<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        
        <title>Listagem de Artigos</title>
    </head>
    <body>
        <div id="fundo">
            <h1>Listagem de Artigos</h1>
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
                        <th style="width: 50%;">T&iacute;tulo</th>
                        <th style="width: 50%;">Op&ccedil;&otilde;es</th>
                    </tr>

                    <c:forEach items="${lista}" var="artigo">
                        <tr>
                            <td style="font-family: arial;">${artigo.titulo}</td>
                            <td style="text-align: center; font-family: arial;">
                                <a class="botao editar" href="./ArtigoControle?operacao=Editar&amp;id=${artigo.id}">Editar</a>
                                <a class="botao excluir" href="./ArtigoControle?operacao=Excluir&amp;id=${artigo.id}">Excluir</a>
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
