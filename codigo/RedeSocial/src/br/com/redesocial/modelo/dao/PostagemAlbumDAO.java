package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gusttavo
 */
public class PostagemAlbumDAO extends DAOBase{
    public void inserir(){
        
        
    }
    public void excluir(){
        
    }
    public void selecionar(){
        
    }
    public void alterar(PostagemAlbum dto, PostagemAlbum dtoNovo) throws Exception{
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update postagens_albuns set postagem = ?, album = ? where postagem = ? and album = ?");
        
        pstmt.setInt(1, dtoNovo.getPostagem().getId());
        pstmt.setInt(2, dtoNovo.getAlbum().getId);
        pstmt.setInt(3, dtoNovo.getPostagem().getId());
        pstmt.setInt(4, dtoNovo.getAlbum().getId);
        
        pstmt.executeQuery();
        
    }
    public void listar(){
        
    }
}
