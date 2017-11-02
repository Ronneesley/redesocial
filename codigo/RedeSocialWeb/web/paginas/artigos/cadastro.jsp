<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Artigos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="ArtigoControle?operacao=Cadastrar" method="post">
            <h1>Cadastro de Artigos</h1>
            
            ${mensagem}

            ${erro}
            
            <input type="hidden" name="id" value="${artigo.id}" />
            
            <br />
            Idioma do Artigo: <br />
            <input type="text" name="idioma" value="${artigo.idioma}" />
            <br /><br />
            
            Nome da Revista: <br />
            <input type="text" name="revista" value="${artigo.revista}" />
            <br /><br />
            
            ISSN: <br />
            <input type="text" name="issn" value="${artigo.ISSN}" />
            <br /><br />
            
            Data: <br />
            <input type="text" value="${artigo.data}" readonly />
            <br /><br />
            
            &Aacute;rea do conhecimento: <br />
            <input type="text" name="area_conhecimento" value="${artigo.areaConhecimento}" />
            <br /><br />
            
            Categoria: <br />
            <select name="categoria">
                <c:forEach items="${categorias}" var="c">
                    <c:if test="${artigo.categoria.id == c.id}">
                        <option value="${c.id}" selected>${c.descricao}</option>
                    </c:if>
                    
                    <c:if test="${artigo.categoria.id != c.id}">
                        <option value="${c.id}">${c.descricao}</option>
                    </c:if>
                </c:forEach>
            </select>
            <br /><br />
            
            T&iacute;tulo da publica&ccedil;&atilde;o<br />
            <input type="text" name="titulo" value="${artigo.titulo}" />
            <br /><br />
            
            Resumo do Artigo<br />
            <textarea name="resumo" style="width: 500px; height: 300px;">${artigo.resumo}</textarea>
            <br /><br />
            
            URL do Artigo<br />
            <input type="text" name="url" value="${artigo.URL}" />
            <br /><br />
            
            Enviar Arquivo do Artigo<br />
            <input type="file" name="arquivo"  />            
            <br /><br />
            
            <input type="checkbox" name="aceito" />
            Aceito os termos de uso 
            <br /><br />
            
            <input type="button" value="Cancelar" />
            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
