package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Comentario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Ronneesley Moura Teles, Igor, Ianka, Heitor e Gusttavo.
 * @since 27/07/2017
 */
public class ComentarioDAO extends DAOCRUDBase<Comentario> {
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from comentarios where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public void alterar(Comentario p) throws Exception {
        Connection conexao = getConexao();

        //PreparedStatement pstmt = conexao.prepareStatement("update comentarios set descricao = ?, curtidas = ?, data = ?, postagem = ? ,resposta = ? where id = ?"); 
        PreparedStatement pstmt = conexao.prepareStatement("update comentarios set descricao = ?, curtidas = ?, data = ? where id = ?"); //codigo temporario
        pstmt.setString(1, p.getDescricao());
        pstmt.setInt(2, p.getCurtidas());
        pstmt.setDate(3, (Date) p.getData());
       /*
        pstmt.setPostagem(4, p.getPostagem());//Que metodo usar se postagem é um tipo
        pstmt.setComentario(5, p.getResposta()); //Que metodo usar se resposta é um tipo
        pstmt.setInt(6, p.getId());
         */       
        pstmt.setInt(4, p.getId());//excluir depois caso o comentario acima tenha seu erro arrumado

        pstmt.executeUpdate();
    }

    @Override
    public Comentario selecionar(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("Select * from posts where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        PostagemDAO postagemDAO = new PostagemDAO();
        if (rs.next()){
            Comentario c = new Comentario();
            c.setId(id);
            c.setDescricao(rs.getString("descricao"));
            c.setCurtidas(rs.getInt("curtidas"));
            c.setData(rs.getDate("data"));
            c.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            
            int idResposta = rs.getInt("resposta");            
            if (!rs.wasNull()){
                c.setResposta(this.selecionar(idResposta));
            }

            return c;
        } else {
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from comentarios order by data desc");

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();

        PostagemDAO postagemDAO = new PostagemDAO();
        while (rs.next()){
            Comentario c = new Comentario();

            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            c.setCurtidas(rs.getInt("curtidas"));
            c.setData(rs.getDate("data"));
            c.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));

            int idResposta = rs.getInt("resposta");
            if (!rs.wasNull()){
                c.setResposta(this.selecionar(idResposta));
            }

            lista.add(c);
        }

        return lista;
    }

    @Override
    public void inserir(Comentario dto) throws Exception {

    }
}
