package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Daniel, Andrey Ribeiro
 */
public class AlbumDAO extends DAOCRUDBase<Album> {
    
    /**
    * Método que seleciona os álbuns no banco de dados
    * @author Daniel Moreira Cardoso
    * @return retorna o álbum desejado
    * @throws Exception possíveis exceções que podem acontecer
    * @param id identificador de Album
    */
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
            a.setData(rs.getTimestamp("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            return a;
        }else{
            return null;
        }
    }
   
    /**
    * Método que lista todos os albuns em ordem alfabética do banco de dados
    * @author Andrey Ribeiro
    * @return lista de albuns ordenados alfabeticamente
    * @throws Exception possíveis exceções que podem acontecer
    */
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
            a.setData(rs.getTimestamp("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            lista.add(a);
        }

        return lista;
    }

    /**
    * Método responsável pela inserção de um álbum no banco de dados
    * @param dto álbum a ser inserido
    * @throws Exception possíveis exceções que podem acontecer
    */
    @Override
    public void inserir(Album dto) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into albuns  (nome, data, usuario) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getNome());
        pstmt.setTimestamp(2, new java.sql.Timestamp(dto.getData().getTime()));
        pstmt.setInt(3, dto.getUsuario().getId());
        
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
        
    }
    
    /**
    * Método responsável pela alteração de um album no banco de dados
    * @author gleyson-alves
    * @param dto novos dados do Album, com o ID do album a ser alterado preenchido
    * @throws Exception possíveis exceções que podem acontecer
    */
    @Override
    public void alterar(Album dto) throws Exception {
        
        Connection conexao = getConexao();

        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("update albuns set nome = ?, usuario=? where id =? ");
       
        pstmt.setString(1, dto.getNome());
        pstmt.setInt(2, dto.getUsuario().getId()); 
        pstmt.setInt(3, dto.getId());
       
        pstmt.executeUpdate();
    }

    /**
    * Método responsável pela exclusão de um álbum no banco de dados
    * @param id identificador do álbum a ser excluído
    * @throws Exception possíveis exceções que podem acontecer
    */
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from albuns where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    /**
    * Método que lista todos os albuns relacionados a um usuário
    * @param id identificador do usuario a ser pesquisado
    * @return lista de albuns ordenados alfabeticamente
    * @throws Exception possíveis exceções que podem acontecer
    * @throws SQLException possíveis exceções que podem acontecer
    * @throws ClassNotFoundException possíveis exceções que podem acontecer
    */
    public List listarAlbunsPessoais(int id) throws SQLException, ClassNotFoundException, Exception{
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from albuns where usuario = ? order by data");
        
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        while (rs.next()){
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setData(rs.getTimestamp("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            lista.add(a);
        }

        return lista;
    }
}
