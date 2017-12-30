package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.PaisBO;
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
 * Controle para o País
 * @author Igor Justino Rodrigues
 * @since 27/08/2017
 */
@WebServlet(name = "PaisControle", urlPatterns = {"/PaisControle"})
public class PaisControle extends HttpServlet {

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

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Pais pais = new Pais();

            request.setAttribute("pais", pais);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/paises/cadastro_paises.jsp");
        rd.forward(request, response);
    }

    /**
     * Cadastra um país no banco de dados
     * @param request
     * @param response
     * @throws Exception
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Pais pais = new Pais();

        if (!"".equals(request.getParameter("id").trim())){
            pais.setId(Integer.parseInt(request.getParameter("id")));
        }

        pais.setNome(request.getParameter("nome"));

        request.setAttribute("pais", pais);

        if (pais.getId() == null){
            this.inserir(pais, request, response);
        } else {
            this.alterar(pais, request, response);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("paginas/paises/cadastro_paises.jsp");
        rd.forward(request, response);
    }

    private void inserir(Pais pais, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void alterar(Pais pais, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.alterar(pais);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            PaisBO paisBO = new PaisBO();
            Pais pais = paisBO.selecionar(id);

            request.setAttribute("pais", pais);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/paises/cadastro_paises.jsp");
        rd.forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            PaisBO bo = new PaisBO();
            List paises = bo.listar();

            request.setAttribute("lista", paises);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/paises/listagem_paises.jsp");
        rd.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            PaisBO bo = new PaisBO();
            bo.excluir(id);

            request.setAttribute("mensagem", "Excluído com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        this.listar(request, response);
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
        return "Servlet para País";
    }
}