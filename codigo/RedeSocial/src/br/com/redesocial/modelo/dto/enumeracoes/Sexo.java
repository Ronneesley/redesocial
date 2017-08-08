package br.com.redesocial.modelo.dto.enumeracoes;

/**
 *
 * @author Ronneesley Moura Teles
 * @since 29/07/2017
 */
public enum Sexo {
    MASCULINO('m', "Masculino"), FEMININO('f', "Feminino");
    
    private char id;
    
    private String descricao;

    private Sexo(char id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public static Sexo getSexo(char id){
        switch (id){
            case 'm': return MASCULINO;
            case 'f': return FEMININO;
        }
        
        return null;
    }
}
