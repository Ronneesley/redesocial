<%-- 
    Document   : listagem_paises
    Created on : 06/09/2017, 17:36:20
    Author     : Ronneesley Moura Teles
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        
        <title>Listagem de Pa&iacute;ses</title>
    </head>
    <body>
        <h1>Listagem de Pa&iacute;ses</h1>
        
        ${mensagem}
        
        ${erro}
        
        <c:if test="${lista != null}">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Op&ccedil;&otilde;es</th>
                </tr>

                <c:forEach items="${lista}" var="pais">
                    <tr>
                        <td>${pais.id}</td>
                        <td>${pais.nome}</td>
                        <td>
                            <a href="./PaisControle?operacao=Editar&amp;id=${pais.id}">Editar</a>
                            <a href="./PaisControle?operacao=Excluir&amp;id=${pais.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach> 
            </table>
        </c:if>
    </body>
</html>
