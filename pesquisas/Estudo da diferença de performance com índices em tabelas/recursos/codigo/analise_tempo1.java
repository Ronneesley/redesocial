package inserir_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AnaliseTempo1 {
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String nomeBuscado = "Antonio Moreira Almeida";
        
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bd_teste1", "root", "251180");
        
        Statement stmt = con.createStatement();
        
        long tempoInicial = new Date().getTime();
        
        for (int i = 0; i < 100000; i++){
            String sqlConsulta = "SELECT * FROM bd_teste1.usuarios"
                    + " where nome = '" + nomeBuscado +" ' ";
            
            stmt.executeQuery(sqlConsulta);
        }
        
        long tempoFinal = new Date().getTime();
        
        con.close();
        
        long duracao = tempoFinal - tempoInicial;
        System.out.println("* " + duracao + " *");
     }
    
}