package inserir_banco;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserir_banco {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        
        // TODO code application logic here
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bd_teste1", "root", "251180");
    
        PreparedStatement pstmt = con.prepareStatement("insert into usuarios (nome) values(?)");
    
        String nomes[] = {"Wilson", "Cleuza", "Weslley", "Renata", "Lourdes",  "William", "Welton", "Willy", "Wallace", "Wermeson", "Warley", "Warlen", "Kenia", "Cleusa", "Maria", "Simone", "Marilia", "Allan", "Eliany", "Emilly", "Karla", "Clara", "Julia", "Lara", "Adrey", "jonatas", "Gilvan", "Jose", "Eduardo", "Abrao", "Absalao", "Abssilao", "Acacio", "Acilino", "Acilio", "Acursio", "Adail", "Adalberto", "Adalsindo", "Adalsino", "Adamantino", "Adamastor", "Adao", "Adauto", "Adauto", "Adelindo","Adelmiro", "Adelmo", "Ademar", "Ademir", "Adeodato", "Aderico", "Aderio", "Aderito", "Barac", "Barao", "Barbaro", "Barcino", "Barnabe", "Bartolomeu", "Bartolomeu", "Basilio", "Balbino", "Baldemar", "Baldomero", "Balduino", "Baltasar", "Baptista", "Bassarme", "Bastiao", "Carlo", "Carlos", "Carmerio", "Carmim", "Carsta", "Casimiro", "Cassiano", "Caetano", "Caio", "Caleb", "Calisto", "Calvino", "Camilo", "Candido", "Canto", "Cassio", "Davi", "David", "Davide", "Decimo", "Decio", "Deivid", "Dejalme", "Delcio", "Delfino", "Delio", "Delmano", "Delmar", "Delmiro", "Demetrio", "Dacio", "Dagmar", "Damas", "Damasceno", "Damiao", "Daniel", "Danilo", "Dante", "Darcio", "Dario", "Dario", "Dener", "Denil", "Denis", "Deodato", "Deolindo", "Dercio", "Deusdedito", "Dhruva", "Diamantino", "Didaco", "Diego", "Edmundo", "Edmur", "Edo", "Eduardo", "Eduartino", "Eduino", "Edvaldo", "Edvino", "Egas", "Egidio", "Egil", "Eladio", "Eleazar", "Eleuterio", "Dario", "Dario", "Dener", "Denil", "Denis", "Deodato", "Deolindo", "Dercio", "Deusdedito", "Dhruva", "Diamantino", "Didaco", "Diego", "Edmundo", "Edmur", "Edo", "Eduardo", "Eduartino", "Eduino", "Edvaldo", "Edvino", "Egas", "Egidio", "Egil", "Eladio", "Eleazar", "Eleuterio", "Elgar", "Eli", "Eberardo", "Eda", "Eder", "Edgar", "Fabiano", "Fabiao", "Fabio", "Fabricio", "Falcao", "Falco", "Faustino", "Fausto", "Feliciano", "Felicio", "Felicissimo", "Felisberto", "Felismino", "Felix", "Feliz", "Ferdinando", "Fernandino", "Fernando", "Fernao", "Gabinio", "Gabino", "Gabriel", "Galiano", "Galileu", "Gamaliel", "Garcia", "Garibaldo", "Gascao", "Gaspar", "Gastao", "Gaudencio", "Gavio", "Gedeao", "Haraldo", "Haroldo", "Hazael", "Heber", "Heitor", "Heldemaro", "Helder", "Heldo", "Heleno", "Iag", "Iago", "Ian", "Ianis", "Iberico", "icaro", "Idalecio", "Idalio"};
        String sobreNomes[] = {"OLiveira", "Coelho", "Silva", "Rosa", "Pereira", "Godofredo", "Jesus", "Almeida", "Mendoca", "Delfim", "Delfino", "Delio", "Delmano", "Delmar", "Delmiro", "Demetrio", "Dacio", "Dagmar", "Damas", "Damasceno", "Damiao", "Daniel", "Danilo", "Dante", "Darcio", "Dario", "Dario", "Dener", "Denil", "Denis", "Deodato", "Deolindo", "Dercio", "Deusdedito", "Dhruva", "Diamantino", "Didaco", "Diego", "Edmundo", "Edmur", "Edo", "Eduardo", "Eduartino", "Eduino", "Edvaldo", "Edvino", "Egas", "Egidio", "Egil", "Eladio", "Eleazar", "Eleuterio", "Elgar", "Eli", "Eberardo", "Eda", "Eder", "Edgar", "Fabiano", "Fabiao", "Fabio", "Fabricio", "Falcao", "Falco", "Faustino", "Fausto", "Feliciano", "Felicio", "Felicissimo", "Felisberto", "Felismino", "Felix", "Feliz", "Ferdinando", "Fernandino", "Fernando", "Fernao", "Gabinio", "Gabino", "Gabriel", "Galiano", "Galileu", "Gamaliel", "Garcia", "Garibaldo", "Gascao", "Gaspar", "Gastao", "Gaudencio", "Gavio", "Gedeao", "Haraldo", "Haroldo", "Hazael", "Heber", "Heitor", "Heldemaro", "Helder", "Heldo", "Heleno", "Iag", "Iago", "Ian", "Ianis", "Iberico", "icaro", "Idalecio", "Idalio", "Abrao", "Absalao", "Abssilao", "Acacio", "Acilino", "Acilio", "Acursio", "Adail", "Adalberto", "Adalsindo", "Adalsino", "Adamantino", "Adamastor", "Adao", "Adauto", "Adauto", "Adelindo","Adelmiro", "Adelmo", "Ademar", "Ademir", "Adeodato", "Aderico", "Aderio", "Aderito", "Barac", "Barao", "Barbaro", "Barcino", "Barnabe", "Bartolomeu", "Bartolomeu", "Basilio", "Balbino", "Baldemar", "Baldomero", "Balduino", "Baltasar", "Baptista", "Bassarme", "Bastiao", "Carlo", "Carlos", "Carmerio", "Carmim", "Carsta", "Casimiro", "Cassiano", "Caetano", "Caio", "Caleb", "Calisto", "Calvino", "Camilo", "Candido", "Canto", "Cassio", "Davi", "David", "Davide", "Decimo", "Decio", "Deivid", "Dejalme", "Delcio", "Zacarias", "Zaido", "Zaido", "Zairo", "Zaqueu", "Zadeao", "Zadoque", "Zafriel", "Zalman", "Zarco", "Zared", "Zarao", "Zebadiah"};
        
        for (int i = 0; i < nomes.length; i++){
            for (int j = 0; j < sobreNomes.length; j++){
                for (int k = 0; k < sobreNomes.length; k++){
                    String nome = nomes[i] + " " + sobreNomes[j] + " " + sobreNomes[k];
        
                    pstmt.setString(1, nome);
                    pstmt.executeUpdate();
                }
            }
        }
    
        con.close();
    
    }
    
}