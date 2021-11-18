package Controller;

import Controller.Helper.LoginHelper;
import dao.UsuarioDAO;
import View.Login;
import Model.Usuario;
import View.MenuPrincipal;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    
    public void autenticar() throws SQLException{
        // Pegar um usuário da view
        String user = view.getTextUsuario().getText();
        String senha = String.valueOf(view.getTextPassword().getPassword());

        Usuario usuarioAutenticar = new Usuario(user, senha);
        
        
        //Usuario usuario = helper.obterModelo();
        
        
        // Persquisa Usuário no Banco
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);

        
        
        // Se o usuário da view tiver o mesmo usuário e senha que o usuário vindo do banco, direcionar para o menu principal
        // Se for diferente, mostrar mensagem "usuário ou senha inválidos"
        if(existe) {
            //direcionar para o menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {            
            JOptionPane.showMessageDialog(view, "usuário ou senha inválidos!");
        }
        
        
        
    }
    
}
