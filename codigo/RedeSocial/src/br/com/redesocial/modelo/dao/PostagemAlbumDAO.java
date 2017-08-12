package br.com.redesocial.modelo.dao;

<<<<<<< HEAD
import br.com.redesocial.modelo.dto.Postagem;
=======
import br.com.redesocial.modelo.dto.PostagemAlbum;
>>>>>>> 20a6a399d729774b2714e982b4bd564e3f8b0de1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        pstmt.setInt(2, dtoNovo.getAlbum().getId());
        pstmt.setInt(3, dto.getPostagem().getId());
        pstmt.setInt(4, dto.getAlbum().getId());
        
        pstmt.executeQuery();
        
    }
    public Postagem listar(int id) throws Exception{
       Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_albuns where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Postagem p = new Postagem();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            /*p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setCurtidas(rs.getInt("curtidas"));
            p.setData(rs.getDate("data"));
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));*/
            
            return p;
        } else {
            return null;
        } 
    }
}
