package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade participantes
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */
public class ParticipanteDAO extends DAOCRUDBase<Participante> {

     /**
     * Método responsável pela inserção de um participante no banco de dados     
     * @param dto objeto com os dados de participante já preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Participante dto) throws Exception {
        Connection conexao = getConexao();        
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into participantes (grupo, usuario, cargo) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, dto.getGrupo().getId());
        pstmt.setInt(2, dto.getUsuario().getId());
        pstmt.setInt(3, dto.getCargo());
        
        pstmt.executeUpdate();
        
    }

    /**
    * Método responsável pela alteração de dados de um participante no banco de dados
    * @param dto novos dados alterados do participante, com o CARGO do participante a ser alterado
    * @throws Exception possíveis exceções que podem acontecer
    */
    @Override
    public void alterar(Participante dto) throws Exception {
        Connection conexao = getConexao();        

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update participantes set cargo = ? where grupo = ? and usuario = ?");
        
        pstmt.setInt(1, dto.getCargo());
        pstmt.setInt(2, dto.getGrupo().getId());
        pstmt.setInt(3, dto.getUsuario().getId());
           
        pstmt.executeUpdate();
    }

    /**
     * Método responsável pela exclusão de um participante no banco de dados     
     * @param cargo identificador do participante a ser excluído
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void excluir(int cargo) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from participantes where cargo = ?");

        pstmt.setInt(1, cargo);        
        
        pstmt.executeUpdate();
    }

    /**
     * Método que seleciona um participante já cadastrado no banco de dados     
     * @param cargo identificador do participante
     * @return participante selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public Participante selecionar(int cargo) throws Exception {        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("select * from participantes where cargo = ?");
        pstmt.setInt(1, cargo);        

        ResultSet rs;
        rs = pstmt.executeQuery();
        
        GrupoDAO grupoDAO = new GrupoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        if(rs.next()){
            Participante dto = new Participante();
            
            dto.setGrupo(grupoDAO.selecionar(rs.getInt("grupo")));
            dto.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            dto.setCargo(rs.getInt("cargo"));
            
            return dto;
        }else{
            return null;
        }
    }

    /**
     * Método que lista todos os participantes em ordem alfabética do banco de dados     
     * @return lista de participantes ordenados por cargo decrescente
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {        
       Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from participantes order by cargo desc");

       ResultSet rs;
       rs = pstmt.executeQuery();
       
       GrupoDAO grupoDAO = new GrupoDAO();
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       
       List lista;
       lista = new ArrayList();

       while (rs.next()){
            Participante dto = new Participante();
           
            dto.setGrupo(grupoDAO.selecionar(rs.getInt("grupo")));
            dto.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            dto.setCargo(rs.getInt("cargo"));           

            lista.add(dto);
       }
       return lista;
    }    
}