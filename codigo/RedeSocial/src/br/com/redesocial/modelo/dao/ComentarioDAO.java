package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
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

    /**
     * Método responsável pela alteração de um comentário no banco de dados
     * @author Gusttavo Nunes Gomes
     * @param p novos dados de comentário, com o ID do comentario a ser alterado preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */    
    @Override
    public void alterar(Comentario p) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt = conexao.prepareStatement("update comentarios set descricao = ?, ups = ?, downs = ?, data = ?, postagem = ?, resposta = ?, usuario = ? where id = ?"); 
        
        pstmt.setString(1, p.getDescricao());
        pstmt.setInt(2, p.getUps());
        pstmt.setInt(3, p.getDowns());
        pstmt.setDate(4, new java.sql.Date(p.getData().getTime()));
        pstmt.setInt(5, p.getPostagem().getId());
        pstmt.setInt(6, p.getResposta().getId()); 
        pstmt.setInt(7, p.getUsuario().getId());
        pstmt.setInt(8, p.getId());

        pstmt.executeUpdate();
    }
    
    /**
     * Método que seleciona um comentário já cadastrado no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @param id identificador do comentário
     * @return comentário selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */    
    @Override
    public Comentario selecionar(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("Select * from comentarios where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        PostagemDAO postagemDAO = new PostagemDAO();
        if (rs.next()){
            Comentario c = new Comentario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            c.setId(id);
            c.setDescricao(rs.getString("descricao"));
            c.setUps(rs.getInt("ups"));
            c.setDowns(rs.getInt("downs"));
            c.setData(rs.getDate("data"));
            c.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            c.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            
            int idResposta = rs.getInt("resposta");            
            if (!rs.wasNull()){
                c.setResposta(this.selecionar(idResposta));
            }

            return c;
        } else {
            return null;
        }
    }

      /**
     * Método que lista todos os comentarios ordenado pela data do comentário do banco de dados
     * @author Igor Justino Rodrigues
     * @return lista de comentarios ordenados pela data do comentário
     * @throws Exception possíveis exceções que podem acontecer
     */
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
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            c.setUps(rs.getInt("Ups"));
            c.setDowns(rs.getInt("Downs"));;
            c.setData(rs.getDate("data"));
            c.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            c.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            int idResposta = rs.getInt("resposta");
            if (!rs.wasNull()){
                c.setResposta(this.selecionar(idResposta));
            }

            lista.add(c);
        }

        return lista;
    }
    
    /**
     * Método responsável pela inserção de um comentario no banco de dados
     * @author Fernando Maciel da Silva
     * @param c comentario a ser inserido     
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Comentario c) throws Exception {
        
        Connection conexao = getConexao();
         
        if (c.getDescricao().equals("")){
            throw new Exception("O comentário não pode estar vazio!");
        }
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into comentarios(descricao, ups, downs, data, postagem, resposta, usuario) values(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, c.getDescricao());
        pstmt.setInt(2, c.getUps());
        pstmt.setInt(3, c.getDowns());
        pstmt.setDate(4, new java.sql.Date(c.getData().getTime()));
        pstmt.setInt(5, c.getPostagem().getId());
        pstmt.setInt(6, c.getResposta().getId());
        pstmt.setInt(7, c.getUsuario().getId());
        
        if(c.getResposta() != null){
            pstmt.setInt(5, c.getResposta().getId());
        } else {
            pstmt.setNull(5, Types.INTEGER);
        }
        pstmt.executeUpdate();
        
        c.setId(getId(pstmt));
        
    }
}
