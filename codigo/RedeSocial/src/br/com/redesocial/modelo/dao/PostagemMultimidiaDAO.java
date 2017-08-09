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
    
    public void inserir(Postagem p, Multimidia m) throws Exception{
        Connection conexao = getConexao();
        
        if(p.getDescricao().equals("") && m.getMidia().equals("")){
            throw new Exception("A descrição ou a mídia não podem estar vazias.");
        }
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("insert into postagens_multimidias(postagem, multimidia) values (?, ?)");
        
        pstmt.setInt(1, p.getId());
        pstmt.setInt(2, m.getId());
        
        pstmt.executeQuery();
    }

    @Override
    public void inserir(PostagemMultimidia dto) throws Exception {

    }

    @Override
    public void alterar(PostagemMultimidia dto) throws Exception {

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
