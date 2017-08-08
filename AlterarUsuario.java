package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * Alteração dados usuario
 * @author Lucas Azevedo
 * @since 08/08/2017
 */
    
public class AlterarUsuario extends DAOCRUDBase<Usuario> {
   



    @Override
    public void alterar (Usuario  u) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("update usuario set id = ?, nome = ?, email=?, telefone=? senha =?, nascimento =?, sexo = ?, data_cadastro =?, status =?, foto=?, cidade=?");
        

        pstmt.setInt(1, u.getId);
        pstmt.setString(2, u.getNome);
        pstmt.setString(3, u.getEmail);
        pstmt.setChar(4, u.getTelefone);
        pstmt.setString(5, u.getSenha);   
        pstmt.setDate(6, u.getNascimento);
        pstmt.setChar(7, u.getSexo);
        pstmt.setDate(8, u.getData_Cadastro);
        pstmt.setBoolean(9, u.getStatus);
        pstmt.setInt(10, u.getFoto);
        pstmt.setString(11, u.getCidade);

        pstmt.executeUpdate();
      
    
    }

    private Connection getConexao() {
        throw new UnsupportedOperationException("Operação não suportada.");
        //Para alterar o corpo dos métodos gerados, escolha de Ferramentas | Modelos..
    }
    }
