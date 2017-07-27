package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.UsuarioBO;
import br.com.redesocial.modelo.dto.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controle para o usuário
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
@WebServlet(name = "UsuarioControle", urlPatterns = {"/UsuarioControle"})
public class UsuarioControle extends HttpServlet {

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
     * Cadastra um usuário no banco de dados
     * @param request
     * @param response
     * @throws Exception 
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(request.getParameter("nome"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

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
        return "Servlet para usuários";
    }
}