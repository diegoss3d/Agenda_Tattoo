package Controller.Helper;

import Model.Usuario;
import View.Login;


public class LoginHelper  implements IHelper{
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    
    public Usuario obterModelo(){
        // Pegar um usuário da view
        String nome = view.getTextUsuario().getText();
        //String senha = view.getTextPassword().getPassword();
        String senha = String.valueOf(view.getTextPassword().getPassword());
        
        Usuario modelo = new Usuario(123, "Diego", "American");
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUsuario().setText(nome);
        view.getTextPassword().setText(senha);
    }
    
    public void limparTela(){
        view.getTextUsuario().setText("");
        view.getTextPassword().setText("");
    }
    
}
