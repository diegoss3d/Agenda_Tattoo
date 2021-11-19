package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AgendaHelper implements IHelper{
    
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
    
    public Cliente obterCliente() {
        return (Cliente) view.getjComboBox_Cliente().getSelectedItem();
    }

    public Servico obterServico() {
        return (Servico) view.getjComboBox_Servico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTxtValor().setText(valor+"");
    }

    @Override
    public Agendamento obterModelo() {
        //String idString = view.getTxtID().getText();
        //int id = Integer.parseInt(idString);
        //String id = String.valueOf(view.getTxtID().getText());
        //int idUsuario = Integer.parseInt(idUsuarioString);
        int id = Integer.parseInt(view.getTxtID().getText());
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getTxtValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTxtData().getText();
        String hora = view.getTxtHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getTxtObservacao().getText();
        
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        return agendamento;
    }

    @Override
    public void limparTela() {
        view.getTxtID().setText("");
        view.getTxtData().setText("");
        view.getTxtHora().setText("");
        view.getTxtObservacao().setText("");

    }
    
    

    
}
