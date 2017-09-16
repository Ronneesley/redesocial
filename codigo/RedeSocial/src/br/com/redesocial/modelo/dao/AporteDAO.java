package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Aporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Henrique
 */

public class AporteDAO extends DAOCRUDBase<Aporte>  {
    
/**
* Método que lista todos os aportes do banco de dados
* @author Paulo Henrique Araujo
* @return lista de aportes ordenados pelo título
* @throws Exception possíveis exceções que podem acontecer
*/
    @Override
     public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from aportes order by titulo asc");
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        PostagemDAO postagemDAO = new PostagemDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List lista;
        lista = new ArrayList();
        
        while (rs.next()){
            Aporte a = new Aporte();
            a.setId(rs.getInt("id"));
            a.setCategoria(categoriaDAO.selecionar(rs.getInt("categoria")));//classe  CategoriaDAO ainda não implementada
            a.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            a.setTitulo(rs.getString("titulo"));
          
            lista.add(a);
        }
        
        return lista;
    }

    @Override
    public void inserir(Aporte dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Aporte dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aporte selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
