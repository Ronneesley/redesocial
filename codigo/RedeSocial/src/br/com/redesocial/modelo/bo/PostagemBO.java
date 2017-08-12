/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.PostagemDAO;
import br.com.redesocial.modelo.dto.Postagem;

/**
 *
 * @author aluno
 */
public class PostagemBO {
     protected PostagemDAO instanciarDAO() {
        return new PostagemDAO();
    }
    protected void validar(Postagem dto) throws Exception {
        //Validações
        if (dto.getCurtidas() == null) throw new Exception("Preencha o campo curtidas");
        if (dto.getDescricao() == null || dto.getDescricao().trim().equals("")) throw new Exception("Preencha o campo Descricao");
        if (dto.getData() == null) throw new Exception("Preencha a data");
        if (dto.getUsuario()== null) throw new Exception("Preencha o campo usuário");
        
    }
    
    protected void validarChavePrimaria(Postagem dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
}

