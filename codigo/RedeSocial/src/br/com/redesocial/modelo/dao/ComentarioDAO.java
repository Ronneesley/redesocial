package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Ronneesley Moura Teles, Igor, Ianka, Heitor e Gusttavo.
 * @since 27/07/2017
 */
<<<<<<< HEAD
public class ComentarioDAO extends DAOBase {
=======
public class ComentarioDAO extends DAOCRUDBase<Comentario> {
    @Override
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from comentarios where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

<<<<<<< HEAD
    public void atualizar() throws Exception {
=======
    @Override
    public void alterar(Comentario p) throws Exception {
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
        Connection conexao = getConexao();

        PreparedStatement pstmt = conexao.prepareStatement("update comentarios set descricao = ? where id = ?");
        pstmt.setString(1, p.getDescricao);
        pstmt.setInt(2, p.getId);

        pstmt.executeUpdate();
    }

<<<<<<< HEAD
    public Post selecionar(int id) throws Exception {
=======
    @Override
    public Comentario selecionar(int id) throws Exception {
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("Select * from posts where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

<<<<<<< HEAD
        if (rs.next()){
            Post p = new Post();
            p.setId(id);
            p.setCurtidas(rs.getString("curtidas"));
            p.setData(rs.getDate("data"));
            p.setPostagem(rs.getString("postagem"));
            p.setResposta(rs.getString("resposta"));

            return p;
=======
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
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
        } else {
            return null;
        }
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from comentarios order by data desc");

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();

        //PostagemDAO postagemDAO = new PostagemDAO();
        while (rs.next()){
            Comentario c = new Comentario();

            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            c.setCurtidas(rs.getInt("curtidas"));
            c.setData(rs.getDate("data"));
            //c.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));

            int idResposta = rs.getInt("resposta");
            if (!rs.wasNull()){
                c.setComentario(this.selecionar(idResposta));
            }

            lista.add(c);
        }

        return lista;
    }

    @Override
    public void inserir(Comentario dto) throws Exception {

    }
}
