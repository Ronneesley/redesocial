package br.com.redesocial.controle;

import br.com.redesocial.modelo.dto.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class ControleBase extends HttpServlet {
    public Usuario getUsuario(HttpServletRequest request){
        return (Usuario) request.getSession().getAttribute("usuario");
    }
    
    public boolean estaLogado(HttpServletRequest request){
        return getUsuario(request) != null;
    }
    
    protected void redirecionarNaoAutenticado(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        mostrar(request, response, "paginas/mensagem_logar.html");
    }
    
    public void mostrar(HttpServletRequest request, HttpServletResponse response, 
            String pagina) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
    }
}
