package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Postagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    /**
    *
    * @author Paulo Henrique
    */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens order by data desc");
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        while(rs.next()){
            Postagem p = new Postagem();
            p.setId(rs.getInt("id"));
            p.setCurtidas(rs.getInt("curtidas"));
            p.setDescricao(rs.getString("descricao"));
            p.setData(rs.getDate("data"));
            p.usuarioDAO.listar(rs.getInt("usuario")); //deu erro aqui
            lista.add(p);
        }
        
        return lista;
     
    }
}
