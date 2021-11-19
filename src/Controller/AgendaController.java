package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import dao.AgendamentoDAO;
import dao.ClienteDAO;
import dao.Conexao;
import dao.ServicoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class AgendaController {
    
    
    private final Agenda view;
    private final AgendaHelper helper;


    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    
    
    public void atualizaTabela() throws SQLException, ParseException{
        
        
        // Buscar lista com agendamentos do banco de dados
        Connection conexao = new Conexao().getConnection();
        AgendamentoDAO agendamentoDao = new AgendamentoDAO(conexao);
        ArrayList<Agendamento> agendamentos = agendamentoDao.selectAll();  
        
        // Exibir a lista na view
        helper.preencherTabela(agendamentos);     
    }
    
    
    public void atualizaCliente() throws SQLException {
        // Buscar clientes do banco de dados
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        // Exibir clientes no combobox cliente
        helper.preencherClientes(clientes);
        
    }
    
    
    public void atualizaServico() throws SQLException {
        // Buscar clientes do banco de dados
        Connection conexao = new Conexao().getConnection();
        ServicoDAO servicoDAO = new ServicoDAO(conexao);
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        // Exibir clientes no combobox cliente
        helper.preencherServicos(servicos);
        
    }
    
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar() throws SQLException, ParseException{
        //Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
        //Salvar objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
        
        //Inserir elemento na tabela
        atualizaTabela();
        helper.limparTela();
    }

    
}


// 