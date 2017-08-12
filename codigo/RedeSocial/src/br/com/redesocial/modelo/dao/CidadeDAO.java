package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        pstmt = conexao.prepareStatement("insert into cidades(nome, estado) values(?, ?)");
        
        pstmt.setString(1, dto.getNome());
        pstmt.setInt(2, dto.getEstado().getId());
        
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));     
    }

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
        pstmt = conexao.prepareStatement("select * from cidade where id = ?");
        
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
        throw new UnsupportedOperationException("Not supported yet."); //Apague a linha e escreva o código
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
