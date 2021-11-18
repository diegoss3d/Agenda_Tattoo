package Controller;

import Model.Servico;
import View.FormCadastroServico;
import dao.Conexao;
import dao.ServicoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormCadastroServicoController {    
        
    private FormCadastroServico view;

    public FormCadastroServicoController(FormCadastroServico view) {
        this.view = view;
    }
    
    public void salvaServico(){        

        String descricao = view.getTextDescricao().getText();
        float valor = Float.parseFloat(view.getTextValor().getText());
        
        Servico servico = new Servico(descricao, valor);   

        
        try {
            Connection conexao = new Conexao().getConnection();
            ServicoDAO servicoDao = new ServicoDAO(conexao);
            servicoDao.insert(servico);
            
            JOptionPane.showMessageDialog(null, "Servico salvo com sucesso!");
            
        } catch (SQLException ex) {
            //Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar servico!");
        }
        
    }
    
}


// Alter table name_of_tableALTER COLUMN name_of_column data_type;
