/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.EstadoBO;
import br.com.redesocial.modelo.dto.Estado;
import java.io.IOException;
import java.io.PrintWriter;
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
                case "Cadastrar":
                    this.cadastrar(request, response);
                    break;
            }
        } catch (Exception ex){
            
        }
    }
    
     /**
     * Cadastra um estado no banco de dados
     * @param request
     * @param response
     * @throws Exception 
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Estado estado = new Estado();
        estado.setNome(request.getParameter("estado"));

        
        request.setAttribute("Estado", estado);
        
        try {
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
            
            RequestDispatcher rd = request.getRequestDispatcher("configuracao_perfil.jsp");
            rd.forward(request, response);
        } catch (Exception ex){
            request.setAttribute("mensagem", "Erro: " + ex.getMessage());
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
        return "Servlet para Estado";
    }// </editor-fold>

    }
