package Controller.Helper;

import Model.Usuario;
import View.MenuUsuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MenuUsuarioHelper {
    
    private final MenuUsuario view;

    public MenuUsuarioHelper(MenuUsuario view) {
        this.view = view;
    }


    public MenuUsuarioHelper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public void preencherTabela(ArrayList<Usuario> usuarios) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableUsuario().getModel();
        tableModel.setNumRows(0);
        
        // Percorrer a lista preenchendo o tableModel
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[]{                
                usuario.getId(),
                usuario.getNome(),
                usuario.getSenha()            
            });
        }
        
        
    }
    

    
    
    
}
