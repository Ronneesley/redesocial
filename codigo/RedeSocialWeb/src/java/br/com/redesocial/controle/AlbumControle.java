package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.AlbumBO;
import br.com.redesocial.modelo.bo.MultimidiaBO;
import br.com.redesocial.modelo.dto.Album;
import br.com.redesocial.modelo.dto.Usuario;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para controle de Ã¡lbuns
 * @author Daniel Moreira Cardoso
 */
@WebServlet(name = "AlbumControle", urlPatterns = {"/AlbumControle"})
public class AlbumControle extends HttpServlet {

    /**
    * Processa todas as requisições sejam elas do tipo GET ou POST
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String operacao = request.getParameter("operacao");
        
        switch(operacao){
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
            case "Selecionar":
                this.selecionar(request, response);
                break;
        }
        
    }

    /**
    * Requisições do tipo GET
    * @param request requisição
    * @param response resposta
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
    * Tratamento dos envios pelo método POST
    * @param request requisição
    * @param response resposta
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
    * Descrição do Servlet
    * @return descrição
    */
    @Override
    public String getServletInfo() {
        return "Controle de Álbuns";
    }

    /**
    * Cria um novo álbum
    * @param request requisição
    * @param response resposta
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Album album = new Album();
            
            request.setAttribute("album", album);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("paginas/galeria/cadastro_albuns.jsp");
        rd.forward(request, response);
    }

    /**
    * Cadastra um álbum no banco de dados
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Album album = new Album();
        
        if(!"".equals(request.getParameter("id").trim())){
            album.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        album.setNome(request.getParameter("album"));
        
        album.setData(new Date());
        
        Usuario usuario = new Usuario();
        usuario.setId(1);
        album.setUsuario(usuario);
        
        if(album.getId()==null){
            this.inserir(album, request, response);
            
        }else{
            this.alterar(album, request, response);
        }
           
    }

    /**
    * Lista todos os álbuns existentes no banco de dados
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            AlbumBO bo = new AlbumBO();
            List album = bo.listarAlbunsPessoais(1);
            
            request.setAttribute("album", album);
        }catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("paginas/galeria/listagem_albuns.jsp");
        rd.forward(request, response);
    }

    /**
    * Exclui um álbum no banco de dados
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void excluir(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * Edita um álbum no banco de dados
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            
            AlbumBO bo = new AlbumBO();
            Album album = bo.selecionar(id);
            
            request.setAttribute("album", album);
            request.setAttribute("mensagem", "Registro Selecionado com sucesso!");
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("galeria.html");
        rd.forward(request, response);
    }

    /**
    * Insere um álbum no banco de dados
    * @param album identificador do álbum a ser inserido
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void inserir(Album album, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AlbumBO bo = new AlbumBO();
            
            bo.inserir(album);
            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        }
        
        this.listar(request, response);
    }

    /**
    * Altera um álbum no banco de dados
    * @param album identificador do álbum a ser alterado
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */    
    private void alterar(Album album, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AlbumBO bo = new AlbumBO();
            bo.alterar(album);
            
            request.setAttribute("mensagem", "Alterado com sucesso!");
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        }
    }

    /**
    * Seleciona um álbum no banco de dados
    * @param request
    * @param response
    * @throws ServletException se ocorre um erro no Servlet
    * @throws IOException se ocorre um erro de entrada e saída
    */
    private void selecionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
            
            AlbumBO albumBO = new AlbumBO();
            Album album = albumBO.selecionar(id);
            
            MultimidiaBO bo = new MultimidiaBO();
            
            List fotosAlbum = bo.listarFotosAlbum(album.getId());
            
            request.setAttribute("album", album);
            
            request.setAttribute("fotos", fotosAlbum);
        }catch(Exception ex){
            
            request.setAttribute("erro", ex.getMessage());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("paginas/galeria/listagem_fotosAlbum.jsp");
        rd.forward(request, response);
    }

}
