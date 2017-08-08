package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Postagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author IgorRodrigues
 */
public class PostagemDAO extends DAOCRUDBase<Postagem> {
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from postagens where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
<<<<<<< HEAD
    
    public void alterar(Postagem p) throws Exception{
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update postagens set curtidas = ?, descricao = ?, data = ?, usuario = ? where id = ?");
        
        pstmt.setInt(1, p.getCurtidas());
        pstmt.setString(2, p.getDescricao());
        pstmt.setDate(3, p.getData());
        pstmt.setString(4, p.getUsuario());
        pstmt.setInt(5, p.getId());
        
        pstmt.executeUpdate();
=======

    @Override
    public void inserir(Postagem dto) throws Exception {
        
    }

    @Override
    public void alterar(Postagem dto) throws Exception {
        
    }

    @Override
    public Postagem selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //Apague a linha e escreva o código
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //Apague a linha e escreva o código
>>>>>>> d31b0c91de7f5fd5d3e626b3acaca1b916666f4b
    }
}
