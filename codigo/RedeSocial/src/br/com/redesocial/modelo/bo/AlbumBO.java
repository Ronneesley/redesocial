package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.AlbumDAO;
import br.com.redesocial.modelo.dto.Album;

/**
 * Define as regras de negócio para os usuários
 * @author Andrey Silva Ribeiro
 * @since 11/08/2017
 */
public class AlbumBO extends BOCRUDBase<Album, AlbumDAO> {
    @Override
    protected AlbumDAO instanciarDAO() {
        return new AlbumDAO();
    }

    @Override
    protected void validar(Album dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do album");
        if  (dto.getData() == null) throw new Exception("Preencha o data do album");

        if (dto.getUsuario() == null) throw new Exception("Preencha o nome do usuário");
    }

    @Override
    protected void validarChavePrimaria(Album dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
}
