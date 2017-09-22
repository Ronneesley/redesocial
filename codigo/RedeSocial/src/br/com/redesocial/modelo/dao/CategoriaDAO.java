package br.com.redesocial.modelo.dao;

import java.sql.ResultSet;
import br.com.redesocial.modelo.dto.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade categoria
 * @author Lucas Pereira de Azevedo
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

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into categorias (descricao) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, c.getDescricao());
        pstmt.executeUpdate();

        c.setId(getId(pstmt));
    }
    
    /**
     * Método que seleciona uma categoria já cadastrada no banco de dados
     * @author Macilon Arruda
     * @param id identificador da categoria
     * @return Categoria selecionada no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
   
    @Override
    public Categoria selecionar(int id) throws Exception{
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from multimidias where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if (rs.next()){
            Categoria c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));

            return c;
        } else {
            return null;
        }
    }
    
    /**
     * Método que altera uma categoria já cadastrada no banco de dados
     * @author Lara Caroline
     * @param c novos dados da categoria, com o ID da categoria, a ser alterada, preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void alterar(Categoria c) throws Exception {
        Connection conexao = getConexao();
        
        if (c.getDescricao().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update categorias set descricao = ? where id = ?");

        pstmt.setString(1, c.getDescricao());
        pstmt.setInt(2, c.getId());
        
        pstmt.executeUpdate();
    }


   /**
     * Método que lista uma categoria já cadastrada no banco de dados
     * @author José Gilvan
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
    Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from categorias order by data desc");
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        while (rs.next()){
            Categoria c = new Categoria();
            pstmt.setString(1, c.getDescricao());
            pstmt.setInt(2, c.getId());
        
            lista.add(c);
        }
        
        return lista;
    }
    
    /**
     * Método responsável por excluir uma categoria do banco de dados
     * @author Luciano de Carvalho Borba
     * @param id da categoria a ser excluida
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void excluir(int id) throws Exception {
        
       Connection conexao = getConexao();
       
       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement ("delete from categorias where id = ?");
       
       pstmt.setInt(1, id);
       pstmt.executeUpdate();
    }

}
