package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AgendaHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o table model
        for (Agendamento agendamento : agendamentos){
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBox_Cliente().getModel();
        
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
        
    }
    
    
    public void preencherServicos(ArrayList<Servico> servicos) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBox_Servico().getModel();
        
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
        
    }
    
    

    
}
