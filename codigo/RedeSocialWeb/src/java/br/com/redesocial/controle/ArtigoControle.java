package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.ArtigoBO;
import br.com.redesocial.modelo.bo.CategoriaBO;
import br.com.redesocial.modelo.dto.Artigo;
import br.com.redesocial.modelo.dto.Categoria;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ArtigoControle", urlPatterns = {"/ArtigoControle"})
public class ArtigoControle extends HttpServlet {

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

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Artigo artigo = new Artigo();

            request.setAttribute("artigo", artigo);
            
            CategoriaBO categoriaBO = new CategoriaBO();
            List categorias = categoriaBO.listar();            
            request.setAttribute("categorias", categorias);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/artigos/cadastro.jsp");
        rd.forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Artigo artigo = new Artigo();

        if (!"".equals(request.getParameter("id").trim())){
            artigo.setId(Integer.parseInt(request.getParameter("id")));
        }

        artigo.setIdioma(request.getParameter("idioma"));
        artigo.setRevista(request.getParameter("revista"));
        artigo.setISSN(request.getParameter("issn"));
        
        artigo.setData(new Date());
        
        artigo.setAreaConhecimento(request.getParameter("area_conhecimento"));
        artigo.setTitulo(request.getParameter("titulo"));
        artigo.setResumo(request.getParameter("resumo"));
        artigo.setURL(request.getParameter("url"));
        artigo.setArtigo(new byte[]{});
        
        int idCategoria = Integer.parseInt( request.getParameter("categoria") );
        CategoriaBO categoriaBO = new CategoriaBO();
        Categoria categoria = categoriaBO.selecionar(idCategoria);
        artigo.setCategoria(categoria);

        request.setAttribute("artigo", artigo);
        
        List categorias = categoriaBO.listar();            
        request.setAttribute("categorias", categorias);

        if (artigo.getId() == null){
            this.inserir(artigo, request, response);
        } else {
            this.alterar(artigo, request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/artigos/cadastro.jsp");
        rd.forward(request, response);
    }

    private void inserir(Artigo artigo, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            ArtigoBO artigoBO = new ArtigoBO();
            artigoBO.inserir(artigo);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void alterar(Artigo artigo, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            ArtigoBO artigoBO = new ArtigoBO();
            artigoBO.alterar(artigo);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ArtigoBO bo = new ArtigoBO();
            List artigos = bo.listar();

            request.setAttribute("lista", artigos);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/artigos/listagem.jsp");
        rd.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            ArtigoBO bo = new ArtigoBO();
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

            ArtigoBO artigoBO = new ArtigoBO();
            Artigo artigo = artigoBO.selecionar(id);

            request.setAttribute("artigo", artigo);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/artigos/cadastro.jsp");
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
        return "Artigo Controle";
    }// </editor-fold>
}
