package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronneesley Moura Teles, Ianka
 * @since 08/08/2017
 */
public class CidadeDAO extends DAOCRUDBase<Cidade> {

    @Override
    public void inserir(Cidade dto) throws Exception {
        Connection conexao = getConexao();
        
        if (dto.getNome().trim().equals("")){
            throw new Exception("O campo estado não pode estar vazio.");
        }
        
        if (dto.getEstado() == null){
            throw new Exception("O campo nome não pode estar vazio.");
        }
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into cidades(nome, estado) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getNome());
        pstmt.setInt(2, dto.getEstado().getId());
        
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));     
    }

    /**
     * Método responsável pela alteração de uma cidade no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @param dto novos dados de cidade, com o ID da cidade a ser alterado preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void alterar(Cidade dto) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt = conexao.prepareStatement("update cidades set estado  = ?, nome = ? where id = ?"); 
        
        pstmt.setInt(1, dto.getEstado().getId()); 
        pstmt.setString(2, dto.getNome());        
        pstmt.setInt(3, dto.getId());

        pstmt.executeUpdate();
    }

    @Override
    public Cidade selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from cidades where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Cidade p = new Cidade();
            EstadoDAO estadoDAO = new EstadoDAO();
            
            p.setId(rs.getInt("id"));
            p.setEstado(estadoDAO.selecionar(rs.getInt("estado")));
            p.setNome(rs.getString("nome"));
            
            return p;
        } else {
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from cidades order by nome asc"); 

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();
        
        EstadoDAO estadoDAO = new EstadoDAO();
        while (rs.next()){
            Cidade c = new Cidade();

            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            lista.add(c);
        }

        return lista;
    }

    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from cidades where id = ?");
        
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
        
    } 
}
