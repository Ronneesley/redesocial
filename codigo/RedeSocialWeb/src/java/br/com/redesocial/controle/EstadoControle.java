/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.EstadoBO;
import br.com.redesocial.modelo.bo.PaisBO;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controle para Estado
 * @author Paulo Henrique
 * @since 30/08/2017
 */
@WebServlet(name = "EstadoControle", urlPatterns = {"/EstadoControle"})
public class EstadoControle extends HttpServlet {

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
                case "CriarNovo":
                    this.criarNovo(request, response);
                    break;
                case "Cadastrar":
                    this.cadastrar(request, response);
                    break;
            }
        } catch (Exception ex){

        }
    }

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Estado estado = new Estado();
            request.setAttribute("estado", estado);

            PaisBO bo = new PaisBO();
            List paises = bo.listar();
            request.setAttribute("paises", paises);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/estados/cadastro_estados.jsp");
        rd.forward(request, response);
    }

     /**
     * Cadastra um estado no banco de dados
     * @param request
     * @param response
     * @throws Exception
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Estado estado = new Estado();

        if (request.getParameter("id") != null){
            estado.setId(Integer.parseInt(request.getParameter("id")));
        }

        estado.setNome(request.getParameter("estado"));
        
        PaisBO paisBO = new PaisBO();
        Integer idPais = Integer.parseInt(request.getParameter("pais"));
        Pais pais = paisBO.selecionar(idPais);
        
        estado.setPais(pais);

        request.setAttribute("estado", estado);

        PaisBO bo = new PaisBO();
        List paises = bo.listar();
        request.setAttribute("paises", paises);

        if (estado.getId() == null){
            this.inserir(estado, request, response);
        } else {
            this.alterar(estado, request, response);
        }
    }


    private void inserir(Estado estado, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/estados/cadastro_estados.jsp");
        rd.forward(request, response);
    }

    private void alterar(Estado estado, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //Para vocês codificarem
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
        return "Servlet para Estado";
    }// </editor-fold>

    }
