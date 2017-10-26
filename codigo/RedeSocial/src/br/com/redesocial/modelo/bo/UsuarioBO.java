package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.UsuarioDAO;
import br.com.redesocial.modelo.dto.Usuario;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Define as regras de negócio para os usuários
 * @author Ronneesley Moura Teles e Daniel Moreira Cardoso
 * @since 27/07/2017
 */
public class UsuarioBO extends BOCRUDBase<Usuario, UsuarioDAO> {
    @Override
    protected UsuarioDAO instanciarDAO() {
        return new UsuarioDAO();
    }
    
    /**
     * Validação de atributos de um usuário
     * @author Daniel Moreira Cardoso
     * @param dto idetificador de usuário
     * @throws Exception possíveis excessões que podem acontecer
     */
    @Override
    protected void validar(Usuario dto) throws Exception {
        //Validações
        if (dto.getNome() == null || dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do usuário");

        if (dto.getEmail().trim().equals("")) throw new Exception("Preencha o e-mail do usuário");

        if (dto.getSenha().trim().equals("")) throw new Exception("Preencha a senha do usuário");

        if (dto.getTelefone().trim().equals("")) throw new Exception("Preencha o telefone do usuário");

        if (dto.getDataNascimento() == null) throw new Exception("Preencha a data de nascimento do usuário");

        if (dto.getSexo() == null) throw new Exception("Preencha o sexo do usuário");

        if (dto.getDataCadastro() == null) throw new Exception("Preencha a data de cadastro do usuário");

        if (dto.getStatus() == null) throw new Exception("Preencha o status do usuário");

        //Validação de chave estrangeira
        if (dto.getCidade() == null) throw new Exception("Preencha a cidade do usuário");
        
    }

    @Override
    protected void validarChavePrimaria(Usuario dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }

    public Usuario logar(String email, String senha) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.logar(email, senha);
    }
    
    public Usuario selecionarEmail(String email) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.selecionarEmail(email);
    }    
    
    public String gerarSenha(){
        
        UUID uuid = UUID.randomUUID();  
        String gerarSenha = uuid.toString();  
        String novaSenha = gerarSenha.substring(0,10);   
        
        return novaSenha;
    }
    
    public void recuperarSenha(String email)throws Exception {
        
        Usuario usuarioSelecionado;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioSelecionado = usuarioDAO.selecionarEmail(email);
        
        if (usuarioSelecionado != null){
        
            String novaSenha = gerarSenha();
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("testarjavamail@gmail.com", "tjm123456");
                }
            });
            session.setDebug(true);
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testarjavamail@gmail.com"));
                Address[] toUser = InternetAddress.parse(usuarioSelecionado.getEmail());  
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Recuperação de Senha - Rede Social");
                message.setText("Sua nova senha para login no sistema: " + novaSenha);
                Transport.send(message);
                System.out.println("Feito!!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            
            usuarioSelecionado.setSenha(novaSenha);
            usuarioDAO.alterarSenha(usuarioSelecionado);
        } else{
            throw new Exception ("Email não encontrado");
        }
    }
}
