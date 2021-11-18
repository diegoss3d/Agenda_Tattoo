package Controller;

import Model.Cliente;
import View.FormCadastroCliente;
import dao.Conexao;
import dao.ClienteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormCadastroClienteController {    
        
    private FormCadastroCliente view;

    public FormCadastroClienteController(FormCadastroCliente view) {
        this.view = view;
    }
    
    public void salvaCliente(){        

        String nome = view.getTextNome().getText();
        String sexo = view.getTextSexo().getText();
        String dataNascimento = view.getTextDataNascimento().getText();
        String telefone = view.getTextTelefone().getText();
        String email = view.getTextEmail().getText();
        String rg = view.getTextRg().getText();
        String endereco = view.getTextEndereco().getText();
        String cep = view.getTextCep().getText();
        

        Cliente cliente = new Cliente(nome, sexo.charAt(0), dataNascimento, telefone, email, rg, endereco, cep);
        

        
        try {
            Connection conexao = new Conexao().getConnection();
            ClienteDAO clienteDao = new ClienteDAO(conexao);
            clienteDao.insert(cliente);
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
            
        } catch (SQLException ex) {
            //Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
        }
        
    }
    
}


// Alter table name_of_tableALTER COLUMN name_of_column data_type;
