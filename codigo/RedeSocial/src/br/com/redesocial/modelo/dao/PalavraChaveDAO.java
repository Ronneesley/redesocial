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

/**
 *
 * @author Salmi Nunes
 */
public class PalavraChaveDAO {
    
    public void inserir(PalavraChave p) throws Exception {
        
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into palavras_chave (descricao) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, p.getDescricao());
        pstmt.executeUpdate();

        p.setId(getId(pstmt));
    }
    
}
