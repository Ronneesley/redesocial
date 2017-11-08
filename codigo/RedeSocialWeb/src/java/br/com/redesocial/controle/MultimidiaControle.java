/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import br.com.redesocial.modelo.bo.AlbumBO;
import br.com.redesocial.modelo.bo.MultimidiaBO;
import br.com.redesocial.modelo.dto.Album;
import br.com.redesocial.modelo.dto.Multimidia;
import br.com.redesocial.modelo.utilitarios.Utilitarios;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author qualq
 */
@WebServlet(name = "MultimidiaControle", urlPatterns = {"/MultimidiaControle"})
public class MultimidiaControle extends HttpServlet {
    // Configurações de upload
    // Limite de memória
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 300; 	// 3MB
    // Tamanho máximo do arquivo
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 400; // 40MB
    // Tamanho máximo do request (arquivos + formulário)
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 500; // 50MB
    // Diretório para upload da imagem
    private static final String UPLOAD_DIRECTORY = "tmp";

    
    
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
            throws ServletException, IOException, Exception {
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet de multimídias.";
    }// </editor-fold>

    private void editar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Multimidia multimidia = new Multimidia();
            request.setAttribute("multimidia", multimidia);
            
            Integer id = Integer.parseInt(request.getParameter("id"));
            AlbumBO albumBO = new AlbumBO();
            Album album = albumBO.selecionar(id);
            
            request.setAttribute("album", album);
        } catch (Exception e) {
            request.setAttribute("errro", e.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("paginas/galeria/cadastro_fotos.jsp");
        rd.forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Multimidia multimidia = new Multimidia();
        
        if (request.getParameter("id") != null){
            multimidia.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        // configura as opções de upload
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // define o limite de memória além do qual os arquivos são armazenados no disco 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // define localização temporária para armazenar arquivos
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // define o tamanho máximo do arquivo
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // define o tamanho máximo da solicitação (arquivo + dados do formulário)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // constrói o caminho do diretório para armazenar o arquivo de upload
        // esse caminho é relativo ao diretório do aplicativo
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

        // cria o diretório se não existir
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
      
        AlbumBO albumBO = new AlbumBO();
        Integer id = Integer.parseInt(request.getParameter("album"));
        Album album = albumBO.selecionar(id);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH;mm;ss");
        
        try {
            // analisa o conteÃºdo do pedido para extrair dados do arquivo
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // itera sobre campos do formulÃ¡rio
                for (FileItem item : formItems) {
                    // processa apenas campos que nÃ£o sÃ£o campos de formulÃ¡rio
                    if (!item.isFormField()) {
                        String fileName = sdf.format(new Date()) + " " + new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;

                        if(!fileName.equals("")){
                            File storeFile = new File(filePath);
                            
                            item.write(storeFile);

                            multimidia.setMidia(Utilitarios.lerArquivo(storeFile));
                            multimidia.setData(new Date());
                            multimidia.setAlbum(album);
                            multimidia.setTipoConteudo("ainda não sei");

                            try {
                                this.inserir(multimidia, request, response);
                                request.setAttribute("mensagem","Upload realizado com sucesso!");
                            } catch (Exception e) {
                                request.setAttribute("erro", e.getMessage());
                            }
                        }
                    }
                    /*if(item.isFormField()){
                        
                    }
                    */
                }
            }
        }catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
        
        if(uploadDir.isDirectory()){
            File[] tmps = uploadDir.listFiles();
            
            for(File deletarArquivos : tmps){
                deletarArquivos.delete();
            }
        }
    }

    private void inserir(Multimidia multimidia, HttpServletRequest request, HttpServletResponse response) {
        try {
            MultimidiaBO bo = new MultimidiaBO();
            
            bo.inserir(multimidia);
            request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        }
    }

}
