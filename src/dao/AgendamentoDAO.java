package dao;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;


public class AgendamentoDAO {
    
    
    private final Connection connection;    
    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }

    
    
    public Agendamento insert(Agendamento agendamento) throws SQLException {

        String sql = "INSERT INTO agendamento (id, cliente, servico, valor, data, observacao) VALUES(?,?,?,?,?,?);";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        statement.setInt(1, agendamento.getId());
        statement.setString(2, String.valueOf(agendamento.getCliente()));
        statement.setString(2, agendamento.getServico().getDescricao());
        statement.setFloat(4, agendamento.getValor());        
        statement.setString(5, String.valueOf(agendamento.getData()));        
        statement.setString(6, agendamento.getObservacao());      

        statement.execute();



        ResultSet resultSet = statement.getGeneratedKeys();



        if (resultSet.next()) {

            int id = resultSet.getInt("id");

            agendamento.setId(id);

        }

        return agendamento;
    }
    
    
    
        public void update(Agendamento agendamento) throws SQLException {
        String sql = "update agendamento set cliente = ?, servico = ?, valor = ?, data = ?, observacao = ? where id = ?;";          
        PreparedStatement statement = connection.prepareStatement(sql);
            
        statement.setString(1, String.valueOf(agendamento.getCliente()));
        statement.setString(2, agendamento.getServico().getDescricao());        
        statement.setFloat(3, agendamento.getValor());        
        statement.setString(4, String.valueOf(agendamento.getData()));        
        statement.setString(5, agendamento.getObservacao());        
        statement.setInt(6, agendamento.getId());
        
        statement.execute();
    }
        
        
        
        public void insertOrUpdate(Agendamento agendamento) throws SQLException {
        if (agendamento.getId() > 0) {
            update(agendamento);
        } else {
            insert(agendamento);
        }
    }
        
    
    
        public void delete(Agendamento agendamento) throws SQLException {
        String sql = "delete from agendamento where id = ?;";            
        PreparedStatement statement = connection.prepareStatement(sql);
            
        statement.setInt(1, agendamento.getId());
        statement.execute(); 
    }
        
        
        
        public ArrayList<Agendamento> selectAll() throws SQLException, ParseException {
        String sql = "select * from agendamento;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }
        
        
        
        private ArrayList<Agendamento> pesquisa(PreparedStatement statement) throws SQLException, ParseException {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            int clienteId = resultSet.getInt("cliente");
            String servico = resultSet.getString("servico");
            float valor = resultSet.getFloat("valor");
            String data = resultSet.getString("data");
            String observacao = resultSet.getString("observacao");
            
            Agendamento agendamentoComDadosDoBanco = new Agendamento(id, new Cliente(clienteId), servico, valor, data, observacao);
            agendamentos.add(agendamentoComDadosDoBanco);
        }
        
        for(Agendamento a : agendamentos) {
        	String sql = "select * from cliente where id = ?;";
    		PreparedStatement pesquisaCliente = connection.prepareStatement(sql);
    		pesquisaCliente.setInt(1, a.getCliente().getId());
    		ResultSet cliente = pesquisaCliente.executeQuery();
    		cliente.next();
    		a.getCliente().setNome(resultSet.getString("nome"));
    		a.getCliente().setSexo(resultSet.getString("sexo").charAt(0));
    		a.getCliente().setDataNascimento(resultSet.getDate("dataNascimento"));
    		a.getCliente().setTelefone(resultSet.getString("telefone"));
    		a.getCliente().setEmail(resultSet.getString("email"));
    		a.getCliente().setRg(resultSet.getString("rg"));
    		a.getCliente().setEndereco(resultSet.getString("endereco"));
    		a.getCliente().setCep(resultSet.getString("cep"));
    		
    		
        }
        return agendamentos;
    }        
        
        
        
        public Agendamento selectPorId(Agendamento agendamento) throws SQLException, ParseException {
        String sql = "select * from agendamento where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);        
        statement.setInt(1, agendamento.getId());
        
        return pesquisa(statement).get(0);
    }
}

















