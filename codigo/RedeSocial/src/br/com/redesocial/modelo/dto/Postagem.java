package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 *
 * @author Lara, Gusttavo Nunes
 */
public class Postagem {
    private Integer id;

    private Integer curtidas;

    private String descricao;

    private Date data;

    private Usuario usuario;
    
    private Integer visualizacoes;
    
    /*public String getTempoPostagem(Calendar calendario){//Recebe uma data{Y,M,D,h,m,s}
        //se < 60 segundos -> x seg.
        //se < 60 minutos  -> x min.
        //se < 24 horas -> x hora ou horas
        //se < 48 horas -> ontem
        //se < 30 dias ->  x dias
        //se > 30 dias -> dd/mm/YYYY
        
        Calendar dataPostagem = Calendar.getInstance();
        dataPostagem = calendario;//Recebe a data da postagem
        Calendar dataAtual = Calendar.getInstance();
        dataAtual.setTime(dataAtual.getTime());//Recebe a data atual        
        
        int ano = calendario.get(Calendar.YEAR); 
        int mes = calendario.get(Calendar.MONTH); 
        int h = calendario.get(Calendar.HOUR_OF_DAY);//Hora no formato de 24 horas e não no de 12  
        int m = calendario.get(Calendar.MINUTE);  
        int s = calendario.get(Calendar.SECOND);  
        int segundos = (h * 60 + m) * 60 + s;  
        
        return "";
    }*/

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getCurtidas(){
        return curtidas;
    }

    public void setCurtidas(Integer curtidas){
        this.curtidas = curtidas;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Date getData(){
        return data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Integer getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(Integer visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
}
