/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.PalavraChave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Salmi Nunes
 */
public class PalavraChaveDAO extends DAOCRUDBase<PalavraChave> {
    
    @Override
    public void inserir(PalavraChave p) throws Exception {
        
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into palavras_chave (descricao) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, p.getDescricao());
        pstmt.executeUpdate();

        p.setId(getId(pstmt));
    }

    @Override
    public void alterar(PalavraChave dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PalavraChave selecionar(int id) throws Exception {
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
