package br.com.redesocial.modelo.dao;


import br.com.redesocial.modelo.dto.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade categoria
 * @author Lucas Pereira de Azevedo
 * @since 05/09/2017
 */
public class CategoriasDAO extends DAOCRUDBase<Categorias> {

    /**
     * Método responsável pela inserção de um categoria no banco de dados
     * @author Lucas Azevedo
     * @param c Categoria a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Categorias c) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into categorias (descricao) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1,c.getDescricao());
        pstmt.executeUpdate();

        c.setId(getId(pstmt));
    }

    @Override
    public void alterar(Categorias dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categorias selecionar(int id) throws Exception {
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
