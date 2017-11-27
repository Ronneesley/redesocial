<%-- 
    Document   : Parametros_TipoAtividade
    Created on : 27/11/2017, 02:43:46
    Author     : Jose Gilvan
--%>

<% String Tipo_De_Atividade = request.getParameter("Tipo De Atividade"); %> 
<% String Restricao = request.getParameter("Restrição"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados e tipo de Atividade</title>
    </head>
    <body>
        <h1> Tipo De Atividade:<%= Tipo_De_Atividade %></h1>
        <h1> Restriçao:<%= Restricao %></h1>
    </body>
</html>
