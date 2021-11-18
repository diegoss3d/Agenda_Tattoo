package Controller;

import Controller.Helper.LoginHelper;
import Controller.Helper.MenuUsuarioHelper;
import Model.Usuario;
import View.MenuUsuario;
import dao.UsuarioDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuUsuarioController {
    
    private final MenuUsuario view;
    private final MenuUsuario helper;
    
    
    /*
        public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    */

    public MenuUsuarioController(MenuUsuario view) throws SQLException {
        this.view = view;
        this.helper = view;
    }
    
    
    public void atualizaTabela() throws SQLException{
        // Buscar lista com os usuarios no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        ArrayList<Usuario> usuarios = usuarioDao.selectAll();
        
        // Exibir a lista na view
        helper.preencherTabela(usuarios);
        
    }
    
    
}
