package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Multimidia;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.PostagemMultimidia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Daniel
 */
public class PostagemMultimidiaDAO extends DAOCRUDBase<PostagemMultimidia>{

    @Override
    public void inserir(PostagemMultimidia dto) throws Exception {
        Connection conexao = getConexao();
        
        if(dto.getPostagem() == null || dto.getMultimidia() == null){
            throw new Exception("A descrição ou a mídia não podem estar vazias.");
        }
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("insert into postagens_multimidias(postagem, multimidia) values (?, ?)");
        
        pstmt.setInt(1, dto.getPostagem().getId());
        pstmt.setInt(2, dto.getMultimidia().getId());
        
        pstmt.executeQuery();
    }

    @Override
    public void alterar(PostagemMultimidia dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update postagens_multimidias set postagem = ?, multimidia = ? where ");
        //condicao 
        
        pstmt.setInt(1, dto.getPostagem());
        pstmt.setInt(2, dto.getMultimidia());
        
        pstmt.executeQuery();
        
        //ainda apanhando das chaves estrangeiras, depois olho direito
    }

    @Override
    public PostagemMultimidia selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_multimidas where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        MultimidiaDAO multimidiaDAO = new MultimidiaDAO();
        PostagemDAO postagemDAO = new PostagemDAO();
        
        if (rs.next()){
            PostagemMultimidia pm = new PostagemMultimidia();
            pm.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            pm.setMultimidia(multimidiaDAO.selecionar(rs.getInt("multimidia")));
            
            return pm;
        } else {
            return null;
        }
    }

    @Override
    public List listar() throws Exception {

    }

    @Override
    public void excluir(int id) throws Exception {

    }
    
}
