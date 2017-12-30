package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade país
 * @author Ronneesley Moura Teles, Thalia Santos de Santana, beltrano
 * @since 24/09/2017
 */
public class PaisDAO extends DAOCRUDBase<Pais> {

    /**
     * Método responsável pela inserção de um país no banco de dados
     * @author Ciclano
     * @param p país a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Pais p) throws Exception {
        Connection conexao = getConexao();

        if(p.getNome().trim().equals("")){
            throw new Exception("O campo país não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into paises (nome) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, p.getNome());
        pstmt.executeUpdate();

        p.setId(getId(pstmt));
    }

    /**
     * Método responsável pela alteração de um país no banco de dados
     * @author Macilon Arruda
     * @param p novos dados do país, com o ID do país a ser alterado preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void alterar(Pais p) throws Exception {
        Connection conexao = getConexao();

        if (p.getNome().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update paises set nome = ? where id = ?");

        pstmt.setString(1, p.getNome());
        pstmt.setInt(2, p.getId());

        pstmt.executeUpdate();
    }

    /**
     * Método responsável pela exclusão de um país no banco de dados
     * @author Ciclano
     * @param id identificador do país a ser excluído
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from paises where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    /**
     * Método que seleciona um país já cadastrado no banco de dados
     * @author Ciclano
     * @param id identificador do país
     * @return país selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public Pais selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from paises where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            Pais p = new Pais();
            p.setId(id);
            p.setNome(rs.getString("nome"));

            return p;
        }else{
            return null;
        }
    }

    /**
     * Método que lista todos os países em ordem alfabética do banco de dados
     * @author Thalia Santos de Santana
     * @return lista de países ordenados alfabeticamente
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
       Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from paises order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           Pais p = new Pais();
           p.setId(rs.getInt("id"));
           p.setNome(rs.getString("nome"));

           lista.add(p);
       }

       return lista;
    }
 }
