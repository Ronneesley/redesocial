/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.CidadeBO;
import br.com.redesocial.modelo.bo.EstadoBO;
import br.com.redesocial.modelo.bo.PaisBO;
import br.com.redesocial.modelo.dto.Cidade;
import java.io.IOException;
import java.util.List;
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
                case "CriarNovo":
                    this.criarNovo(request, response);
                    break;
                case "Cadastrar":
                    this.cadastrar(request, response);
                    break;
                case "Listar":
                    this.listar(request, response);
                    break;
                case "Excluir":
                    this.excluir(request, response);
                    break;
                case "Editar":
                    this.editar(request, response);
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
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        Cidade cidade = new Cidade();

        if (request.getParameter("id") != null){
            cidade.setId(Integer.parseInt(request.getParameter("id")));
        }

        cidade.setNome(request.getParameter("cidade"));

        request.setAttribute("cidade", cidade);

        EstadoBO bo = new EstadoBO();
        List estados = bo.listar();
        request.setAttribute("estados", estados);
        
        PaisBO pbo = new PaisBO();
        List paises = pbo.listar();
        request.setAttribute("paises", paises);

        if (cidade.getId() == null){
            this.inserir(cidade, request, response);
        } else {
            this.alterar(cidade, request, response);
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

    private void alterar(Cidade cidade, HttpServletRequest request, HttpServletResponse response) {
       //To change body of generated methods, choose Tools | Templates.
    }

    private void inserir(Cidade cidade, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/estados/cadastro_estados.jsp");
        rd.forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {

    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) {

    }

    private void editar(HttpServletRequest request, HttpServletResponse response) {

    }

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) {

    }
}
