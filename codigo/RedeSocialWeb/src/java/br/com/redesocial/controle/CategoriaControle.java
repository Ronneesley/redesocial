/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.CategoriaBO;
import br.com.redesocial.modelo.bo.PaisBO;
import br.com.redesocial.modelo.dto.Categoria;
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
@WebServlet(name = "CategoriaControle", urlPatterns = {"/CategoriaControle"})
public class CategoriaControle extends HttpServlet {

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
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        request.setAttribute("usuario", usuario);

        if (usuario != null){
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
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("paginas/mensagem_logar.html");
            rd.forward(request, response);
        }
    }

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Categoria categoria = new Categoria();

            request.setAttribute("categoria", categoria);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/categorias/cadastro.jsp");
        rd.forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Categoria categoria = new Categoria();

        if (!"".equals(request.getParameter("id").trim())){
            categoria.setId(Integer.parseInt(request.getParameter("id")));
        }

        categoria.setDescricao(request.getParameter("descricao"));

        request.setAttribute("categoria", categoria);

        if (categoria.getId() == null){
            this.inserir(categoria, request, response);
        } else {
            this.alterar(categoria, request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/categorias/cadastro.jsp");
        rd.forward(request, response);
    }

    private void inserir(Categoria categoria, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void alterar(Categoria categoria, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.alterar(categoria);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            CategoriaBO bo = new CategoriaBO();
            List categorias = bo.listar();

            request.setAttribute("lista", categorias);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/categorias/listagem.jsp");
        rd.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CategoriaBO bo = new CategoriaBO();
            bo.excluir(id);

            request.setAttribute("mensagem", "Excluído com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        this.listar(request, response);
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CategoriaBO categoriaBO = new CategoriaBO();
            Categoria categoria = categoriaBO.selecionar(id);

            request.setAttribute("categoria", categoria);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/categorias/cadastro.jsp");
        rd.forward(request, response);
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
        return "Categoria Controle";
    }// </editor-fold>
}
