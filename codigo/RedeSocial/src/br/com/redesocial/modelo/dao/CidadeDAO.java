package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Ronneesley Moura Teles
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
    }

    @Override
    public void alterar(Cidade dto) throws Exception {
        
    }

    @Override
    public Cidade selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //Apague a linha e escreva o código
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //Apague a linha e escreva o código
    }

    @Override
    public void excluir(int id) throws Exception {
        
    }

}
