package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.AporteBO;
import br.com.redesocial.modelo.bo.CategoriaBO;
import br.com.redesocial.modelo.bo.PostagemBO;
import br.com.redesocial.modelo.dto.Aporte;
import br.com.redesocial.modelo.dto.Categoria;
import br.com.redesocial.modelo.dto.Postagem;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo Henrique
 */
@WebServlet(name = "AporteControle", urlPatterns = {"/AporteControle"})
public class AporteControle extends ControleBase {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Aporte aporte = new Aporte();

            request.setAttribute("aporte", aporte);
            
            CategoriaBO categoriaBO = new CategoriaBO();
            List categorias = categoriaBO.listar();            
            request.setAttribute("categoria", categorias);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/aportes/cadastro.jsp");
        rd.forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Aporte aporte = new Aporte();
        
        if (!"".equals(request.getParameter("id").trim())){
            aporte.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        aporte.setTitulo(request.getParameter("titulo"));

        int idCategoria = Integer.parseInt( request.getParameter("categoria") );
        CategoriaBO categoriaBO = new CategoriaBO();
        Categoria categoria = categoriaBO.selecionar(idCategoria);
        aporte.setCategoria(categoria);
        
        int idPostagem = Integer.parseInt( request.getParameter("postagem") );
        PostagemBO postagemBO = new PostagemBO();
        Postagem postagem = postagemBO.selecionar(idPostagem);
        aporte.setPostagem(postagem);
        
        request.setAttribute("aporte", aporte);
        
        List categorias = categoriaBO.listar();            
        request.setAttribute("categorias", categorias);
        
         if (aporte.getId() == null){
            this.inserir(aporte, request, response);
        } else {
            this.alterar(aporte, request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/aportes/cadastro.jsp");
        rd.forward(request, response);
    }
    
        private void inserir(Aporte aporte, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            AporteBO aporteBO = new AporteBO();
            aporteBO.inserir(aporte);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void alterar(Aporte aporte, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            AporteBO aporteBO = new AporteBO();
            aporteBO.alterar(aporte);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            AporteBO bo = new AporteBO();
            List artigos = bo.listar();

            request.setAttribute("lista", artigos);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/aportes/listagem.jsp");
        rd.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            AporteBO aporteBO = new AporteBO();
            aporteBO.excluir(id);

            request.setAttribute("mensagem", "Excluído com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        this.listar(request, response); 
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception {
         try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            AporteBO aporteBO = new AporteBO();
            Aporte aporte = aporteBO.selecionar(id);

            request.setAttribute("aporte", aporte);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/aportes/cadastro.jsp");
        rd.forward(request, response);
    }

}
