/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.CidadeBO;
import br.com.redesocial.modelo.dto.Cidade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe de controle para inserir Cidade
 * @author Daniel Moreira Cardoso
 * @since 30/08/2017
 */
@WebServlet(name = "CidadeControle", urlPatterns = {"/CidadeControle"})
public class CidadeControle extends HttpServlet {

    /**
     * Processa todas as requisições sejam elas do tipo GET ou POST   *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
     * Cadastra uma cidade no banco de dados
     * @param request
     * @param response
     * @throws Exception 
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cidade cidade = new Cidade();
        cidade.setNome(request.getParameter("nome"));
        
        request.setAttribute("cidade", cidade);
        
        try {
            CidadeBO usuarioBO = new CidadeBO();
            usuarioBO.inserir(cidade);

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
     * Descrição do servlet
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para Cidades";
    }
}
