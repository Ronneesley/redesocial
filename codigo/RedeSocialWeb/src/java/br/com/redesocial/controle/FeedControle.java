package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.PostagemBO;
import br.com.redesocial.modelo.dto.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "FeedControle", urlPatterns = {"/FeedControle"})
public class FeedControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String operacao = request.getParameter("operacao");
        
        try {
            switch (operacao){
                case "Postar":
                    this.postar(request, response);
                    break;
                case "Atualizar":
                    this.atualizar(request, response);
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void postar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String mensagem = request.getParameter("mensagem");        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        PostagemBO bo = new PostagemBO();
        bo.publicar(usuario, mensagem);
        
        request.setAttribute("usuario", usuario);
        
        atualizar(request, response);
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PostagemBO bo = new PostagemBO();
        List postagens = bo.listar();
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("postagens", postagens);
        
        RequestDispatcher rd = request.getRequestDispatcher("paginas/layout.jsp");
        rd.forward(request, response);        
    }

}
