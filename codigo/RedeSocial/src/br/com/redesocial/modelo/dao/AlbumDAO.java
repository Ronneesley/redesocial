package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Daniel
 */
public class AlbumDAO extends DAOCRUDBase<Album> {
    @Override
    public Album selecionar(int id)throws Exception{
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from albuns where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(rs.next()){
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setData(rs.getDate("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            return a;
        }else{
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from albuns order by data desc"); 

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        while (rs.next()){
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setData(rs.getDate("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            lista.add(a);
        }

        return lista;
    }

    @Override
    public void inserir(Album dto) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into albuns  (nome, data, usuario) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getNome());
        pstmt.setDate(2, new java.sql.Date(dto.getData().getTime()));
        pstmt.setInt(3, dto.getUsuario().getId());
        
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
        
    }

    @Override
    public void alterar(Album dto) throws Exception {
        
        Connection conexao = getConexao();

        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("update albuns set nome = ?, data=?, usuario=? where id =? ");
       
        pstmt.setString(1, dto.getNome());
        pstmt.setDate(2, new java.sql.Date(dto.getData().getTime()));
        pstmt.setInt(3, dto.getUsuario().getId()); 
        pstmt.setInt(4, dto.getId());
       
        pstmt.executeUpdate();
    }

    @Override
    public void excluir(int id) throws Exception {

    }
}
