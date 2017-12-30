
package br.com.redesocial.modelo.bo;
import br.com.redesocial.modelo.dao.AporteDAO;
import br.com.redesocial.modelo.dto.Aporte;

/**
 *
 * @author Lara
 */
public class AporteBO extends BOCRUDBase <Aporte, AporteDAO>{

    @Override
    protected AporteDAO instanciarDAO() {
        return new AporteDAO();
    }

    @Override
    protected void validarChavePrimaria(Aporte dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }

    @Override
    protected void validar(Aporte dto) throws Exception {
        if(dto.getTitulo().trim().equals("") || dto.getTitulo() == null) throw new Exception("Preencha o título do aporte.");
        if(dto.getCategoria() == null) throw new Exception("Preencha a categoria do aporte.");
        if(dto.getPostagem() == null) throw new Exception("Preencha a postagem.");
    }
    
}
