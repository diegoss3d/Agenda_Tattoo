package Controller;

import Model.Usuario;
import View.FormCadastroUsuario;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormCadastroUsuarioController {
    
    private FormCadastroUsuario view;

    public FormCadastroUsuarioController(FormCadastroUsuario view) {
        this.view = view;
    }
    
    public void salvaUsuario(){        

        String user = view.getTextUsuario().getText();
        String senha = String.valueOf(view.getjPassword().getPassword());

        Usuario usuario = new Usuario(user, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
            
        } catch (SQLException ex) {
            //Logger.getLogger(FormCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario!");
        }
        
    }
    
}
