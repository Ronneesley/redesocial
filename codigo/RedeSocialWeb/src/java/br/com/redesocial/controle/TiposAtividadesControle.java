package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.TiposAtividadesBO;
import br.com.redesocial.modelo.dto.TiposAtividades;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TiposAtividadesControle", urlPatterns = {"/TiposAtividadesControle"})
public class TiposAtividadesControle extends HttpServlet {

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
            TiposAtividades tiposAtividades = new TiposAtividades();

            request.setAttribute("atividade", tiposAtividades);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/tiposAtividades.jsp");
        rd.forward(request, response);
    }

    /**
     * Cadastra uma atividade no banco de dados
     * @param request
     * @param response
     * @throws Exception
     */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        TiposAtividades tiposAtividades = new TiposAtividades ();

        if (!"".equals(request.getParameter("id").trim())){
            tiposAtividades.setId(Integer.parseInt(request.getParameter("id")));
        }

        tiposAtividades.setNome(request.getParameter("nome"));
        

        request.setAttribute("nome", tiposAtividades);

        if (tiposAtividades.getId() == null){
            this.inserir(tiposAtividades, request, response);
        } else {
            this.alterar(tiposAtividades, request, response);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("paginas/tiposAtividades.jsp");
        rd.forward(request, response);
    }

    private void inserir(TiposAtividades tiposAtividades, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            TiposAtividadesBO tiposAtividadesBO = new TiposAtividadesBO();
            tiposAtividadesBO.inserir(tiposAtividades);

            request.setAttribute("mensagem", "Cadastro de atividade realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void alterar(TiposAtividades tiposAtividades, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            TiposAtividadesBO tiposAtividadesBO = new TiposAtividadesBO();
            tiposAtividadesBO.alterar(tiposAtividades);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            TiposAtividadesBO tiposAtividadesBO = new TiposAtividadesBO();
            TiposAtividades tiposAtividades = tiposAtividadesBO.selecionar(id);

            request.setAttribute("atividade", tiposAtividades);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/tiposAtividades.jsp");
        rd.forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            TiposAtividadesBO bo = new TiposAtividadesBO();
            List tiposAtividades = bo.listar();

            request.setAttribute("lista", tiposAtividades);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/listagemTA.jsp");
        rd.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            TiposAtividadesBO bo = new TiposAtividadesBO();
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
        return "Servlet para tipos de atividades";
    }
}
