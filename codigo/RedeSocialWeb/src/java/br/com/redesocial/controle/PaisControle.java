package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.PaisBO;
import br.com.redesocial.modelo.dto.Pais;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controle para o País
 * @author Igor Justino Rodrigues
 * @since 27/08/2017
 */
@WebServlet(name = "PaisControle", urlPatterns = {"/PaisControle"})
public class PaisControle extends HttpServlet {

    /**
     * Processa todas as requisições sejam elas do tipo GET ou POST
     * @param request requisição
     * @param response resposta
     * @throws javax.servlet.ServletException se ocorre um erro no Servlet
     * @throws java.io.IOException se ocorre um erro de entrada e saída
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String operacao = request.getParameter("operacao");
        
        try {
            switch (operacao){
                case "Cadastrar":
                    this.cadastrar(request, response);
                    break;
            }
        } catch (Exception ex){
            
        }
    }
    
    /**
     * Cadastra um país no banco de dados
     * @param request
     * @param response
     * @throws Exception 
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Pais pais = new Pais();
        pais.setNome(request.getParameter("nome"));
        
        request.setAttribute("pais", pais);
        
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
            
            RequestDispatcher rd = request.getRequestDispatcher("configuracao_perfil.jsp");
            rd.forward(request, response);
        } catch (Exception ex){
            request.setAttribute("mensagem", "Erro: " + ex.getMessage());
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Requisições do tipo GET
     * @param request requisição
     * @param response resposta
     * @throws javax.servlet.ServletException se ocorre um erro no Servlet
     * @throws java.io.IOException se ocorre um erro de entrada e saída
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Tratamento dos envios pelo método POST
     * @param request requisição
     * @param response resposta
     * @throws javax.servlet.ServletException se ocorre um erro no Servlet
     * @throws java.io.IOException se ocorre um erro de entrada e saída
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Descrição do Servlet
     * @return descrição
     */
    @Override
    public String getServletInfo() {
        return "Servlet para País";
    }
}