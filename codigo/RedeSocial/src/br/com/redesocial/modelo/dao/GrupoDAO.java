package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade grupos
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */
public class GrupoDAO extends DAOCRUDBase<Grupo>{

    /**
    * Método responsável pela inserção de um objeto no banco de dados na tabela grupos
    * @param g objeto com os dados de grupo já preenchido
    * @throws Exception
    */
    @Override
    public void inserir(Grupo g) throws Exception {
        Connection conexao = getConexao();        

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into grupos (nome, data_criacao, descricao, privacidade, tipo) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, g.getNome());
        pstmt.setDate(2, new java.sql.Date(g.getDataCriacao().getTime()));
        pstmt.setString(3,g.getDescricao());
        pstmt.setInt(4, g.getPrivacidade());
        pstmt.setString(5, g.getTipo());        
        
        pstmt.executeUpdate();

        g.setId(getId(pstmt));
    }

    /**
    * Método responsável pela alteração de dados de um grupo no banco de dados
    * @param g novos dados alterados do grupo, com o ID do grupo a ser alterado
    * @throws Exception possíveis exceções que podem acontecer
    */
    @Override
    public void alterar(Grupo g) throws Exception {
        Connection conexao = getConexao();        

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update grupos set nome = ?, data_criacao = ?, descricao = ?, privacidade = ?, tipo = ? where id = ?");

        pstmt.setString(1, g.getNome());
        pstmt.setDate(2, new java.sql.Date(g.getDataCriacao().getTime()));
        pstmt.setString(3,g.getDescricao());
        pstmt.setInt(4, g.getPrivacidade());
        pstmt.setString(5, g.getTipo());        
        
        pstmt.setInt(6,g.getId());

        pstmt.executeUpdate();
    }

    /**
     * Método responsável pela exclusão de um grupo no banco de dados     
     * @param id identificador do grupo a ser excluído
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from grupos where id = ?");

        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }

    /**
     * Método que seleciona um grupo já cadastrado no banco de dados     
     * @param id identificador do grupo
     * @return grupo selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public Grupo selecionar(int id) throws Exception {        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("select * from grupos where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            Grupo g = new Grupo();
            g.setId(id);
            g.setNome(rs.getString("nome"));

            return g;
        }else{
            return null;
        }
    }

    /**
     * Método que lista todos os grupos em ordem alfabética do banco de dados     
     * @return lista de grupos ordenados alfabeticamente
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {        
       Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from grupos order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           Grupo g = new Grupo();
           g.setId(rs.getInt("id"));
           g.setNome(rs.getString("nome"));

           lista.add(g);
       }
       return lista;
    }    
}
