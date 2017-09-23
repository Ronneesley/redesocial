package br.com.redesocial.modelo.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo, Willian e Salmi
 */
public class UtilitariosTest {
    @Test
    public void testDiferencaHoraHumanizada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data1, data2;
        
        try {
            data1 = sdf.parse("20/09/2017 21:00:00"); 
            data2 = sdf.parse("20/09/2017 21:00:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("agora", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        
        try {
            data1 = sdf.parse("20/09/2017 21:00:00"); 
            data2 = sdf.parse("20/09/2017 21:00:40");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("agora", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 21:00:00"); 
            data2 = sdf.parse("20/09/2017 21:01:10");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("1 minuto", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 21:00:00"); 
            data2 = sdf.parse("20/09/2017 21:19:10");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("19 minutos", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 18:00:00"); 
            data2 = sdf.parse("20/09/2017 18:43:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("43 minutos", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 21:00:02"); 
            data2 = sdf.parse("20/09/2017 22:09:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("1 hora", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 18:00:50"); 
            data2 = sdf.parse("20/09/2017 22:15:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("4 horas", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 10:25:00"); 
            data2 = sdf.parse("20/09/2017 22:15:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("11 horas", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/09/2017 00:05:00"); 
            data2 = sdf.parse("20/09/2017 23:33:30");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("23 horas", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("19/09/2017 10:05:00"); 
            data2 = sdf.parse("20/09/2017 00:36:40");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("14 horas", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("17/09/2017 12:05:00"); 
            data2 = sdf.parse("18/09/2017 14:04:32");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("1 dia", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("17/09/2017 00:00:00"); 
            data2 = sdf.parse("18/09/2017 00:00:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("1 dia", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("12/09/2017 10:09:00"); 
            data2 = sdf.parse("15/09/2017 09:00:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("2 dias", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("27/09/2017 00:10:36"); 
            data2 = sdf.parse("30/09/2017 06:00:00");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("3 dias", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
        try {
            data1 = sdf.parse("20/07/2017 12:00:36"); 
            data2 = sdf.parse("18/11/2017 11:40:10");

            String resultado = Utilitarios.diferencaHumanizada(data1, data2);

            assertEquals("20/07/2017 12:00", resultado);
        } catch (Exception ex){
            fail(ex.getMessage());
        }
        
    }
}