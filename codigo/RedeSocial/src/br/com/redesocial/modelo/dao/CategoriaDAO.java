package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.bo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;



/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade categoria
 * @author Lucas Azevedo
 * @since 05/09/2017
 */
public class CategoriaDAO extends DAOCRUDBase<Categoria> {

    /**
     * Método responsável pela inserção de um categoria no banco de dados
     * @author Lucas Azevedo
     * @param c Categoria a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Categoria c) throws Exception {
        Connection conexao = getConexao();

        if(c.getDescricao().equals("")){
            throw new Exception("O campo categoria não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into categoria (descricao) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, (String) c.getDescricao());
        pstmt.executeUpdate();

        c.setId(getId(pstmt));
    }

    @Override
    public void alterar(Categoria dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}