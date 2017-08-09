package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Multimidia;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.PostagemMultimidia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Daniel
 */
public class PostagemMultimidiaDAO extends DAOCRUDBase<PostagemMultimidia>{

    @Override
    public void inserir(PostagemMultimidia dto) throws Exception {
        Connection conexao = getConexao();
        
        if(dto.getPostagem().getId().equals("") && dto.getMultimidia().getId().equals("")){
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

    }

    @Override
    public List listar() throws Exception {

    }

    @Override
    public void excluir(int id) throws Exception {

    }
    
}
