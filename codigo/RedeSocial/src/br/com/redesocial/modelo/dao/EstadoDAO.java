package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dao.interfaces.DAOCRUD;
import br.com.redesocial.modelo.dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Warley Rodrigues
 */

public class EstadoDAO extends DAOBase implements DAOCRUD<Estado> { 

	/**
 	* Inseri um objeto no banco de dados na tabela usuários
 	* @param dto objeto com os dados de usuário já preenchido
 	* @throws Exception
 	*/

	@Override

	public void inserir(Estado dto) throws Exception {
    	Connection conexao = getConexao();
   	 
    	PreparedStatement pstmt = conexao.prepareStatement("insert into estado(nome, pais) values(?, ?)");
   	 
    	pstmt.setString(1, dto.getNome());
    	pstmt.setString(2, dto.getPais());
    	
   	 
    	pstmt.executeUpdate();
	}
}
