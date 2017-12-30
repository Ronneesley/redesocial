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
import br.com.redesocial.modelo.dto.Estado;
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
                ex.printStackTrace();
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

        if (!"".equals(request.getParameter("id").trim())){
            cidade.setId(Integer.parseInt(request.getParameter("id")));
        }

        cidade.setNome(request.getParameter("cidade"));
        
        EstadoBO estadoBO = new EstadoBO();
        Integer idEstado = Integer.parseInt(request.getParameter("estado"));
        Estado estado = estadoBO.selecionar(idEstado);
        
        cidade.setEstado(estado);

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
       try {
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.alterar(cidade);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void inserir(Cidade cidade, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/cidades/cadastro_cidades.jsp");
        rd.forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CidadeBO bo = new CidadeBO();
            List cidades = bo.listar();

            request.setAttribute("lista", cidades);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/cidades/listagem_cidades.jsp");
        rd.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CidadeBO bo = new CidadeBO();
            bo.excluir(id);

            request.setAttribute("mensagem", "Excluído com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        this.listar(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CidadeBO cidadeBO = new CidadeBO();
            Cidade cidade = cidadeBO.selecionar(id);

            request.setAttribute("cidade", cidade);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/cidades/cadastro_cidades.jsp");
        rd.forward(request, response);
    }

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Cidade cidade = new Cidade();
            request.setAttribute("cidade", cidade);
            
            PaisBO pbo = new PaisBO();
            List paises = pbo.listar();
            request.setAttribute("paises", paises);
            
            EstadoBO bo = new EstadoBO();
            List estados = bo.listar();
            request.setAttribute("estados", estados);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/cidades/cadastro_cidades.jsp");
        rd.forward(request, response);
    }
}
