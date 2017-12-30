package br.com.redesocial.modelo.utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ronneesley
 */
public class Utilitarios {
    
    public static String diferencaHumanizada(Date dataAnterior) throws ParseException{
        return diferencaHumanizada(dataAnterior, new Date());
    }
    
    public static String diferencaHumanizada(Date dataAnterior, Date dataPosterior) throws ParseException{
        
        Date dataPostagem = dataAnterior;      
        Date dataAtual = dataPosterior;
        
        String mensagemData;

        long diferencaSeg = (dataAtual.getTime() - dataPostagem.getTime())/1000;
        
        long diferencaMins, diferencaHrs, diferencaDias;
        
        if(diferencaSeg < 60){
            mensagemData = "agora";            
        } else if (diferencaSeg < 3600){
            diferencaMins = diferencaSeg / 60;
            if(diferencaMins==1){
               mensagemData = diferencaMins + " minuto";
            }else{
                mensagemData = diferencaMins + " minutos";
            }
            
        } else if (diferencaSeg < 86400){
            diferencaHrs = (diferencaSeg / 60)/ 60;
            if(diferencaHrs==1){
               mensagemData = diferencaHrs + " hora";
            }else{
                mensagemData = diferencaHrs + " horas";
            }            
        } else if(diferencaSeg<345600){
            diferencaDias = ((diferencaSeg / 60)/ 60)/24;
            if(diferencaDias==1){
               mensagemData = diferencaDias + " dia";
            }else{
                mensagemData = diferencaDias + " dias";
            }
            
        } else {
            SimpleDateFormat diaHoraPostagem = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");
            
            mensagemData = diaHoraPostagem.format(dataPostagem);
        }

        return mensagemData;
    }

    public static byte[] lerArquivo(File arquivo) throws Exception {
        byte[] bytes;
        try (FileReader arq = new FileReader(arquivo)) {
            
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String conteudo = linha;
            
            while (linha != null) {
                linha = lerArq.readLine(); // lê da segunda até a última linha
                
                if (linha != null){
                    conteudo += linha;
                }
            }   
            
            bytes = conteudo.getBytes();
        }
        
        return bytes;
    }
}
