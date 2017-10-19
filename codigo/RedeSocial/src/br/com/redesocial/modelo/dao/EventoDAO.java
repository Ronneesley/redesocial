package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Evento;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Postagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos dados dos eventos
 * @author Willian Wallace e Jonathan Silvestre
 * @since 13/10/2017
 */
public class EventoDAO extends DAOCRUDBase<Evento> {
     
    @Override
    public void inserir(Evento dto) throws Exception {
        Connection conexao = getConexao();

        if(dto.getNome().trim().equals("")){
            throw new Exception("O campo nome não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into eventos (descricao, nome, id) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, dto.getDescricao());
        pstmt.setString(2, dto.getNome());
        pstmt.setInt(3, dto.getId());
        pstmt.executeUpdate();

        dto.setId(getId(pstmt));
    }

    @Override
    public void alterar(Evento dto) throws Exception {
       Connection conexao = getConexao();

        PreparedStatement pstmt = conexao.prepareStatement("update eventos set descricao  = ?, nome = ? where id = ?"); 
        
        pstmt.setString(1, dto.getDescricao()); 
        pstmt.setString(2, dto.getNome());        
        pstmt.setInt(3, dto.getId());

        pstmt.executeUpdate();
    }

    @Override
    public Evento selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from eventos where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Evento dto = new Evento();
            
            dto.setDescricao(rs.getString("descricao"));
            dto.setNome(rs.getString("nome"));
            dto.setId(rs.getInt("id"));
            
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from evento order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           Evento p = new Evento();
           p.setNome(rs.getString("descricao"));
           p.setNome(rs.getString("nome"));
           p.setId(rs.getInt("id"));

           lista.add(p);
       }

       return lista;
    }
    
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();  
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from eventos where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
