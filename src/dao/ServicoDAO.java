package dao;

import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicoDAO {
    
    private final Connection connection;

    public ServicoDAO(Connection connection) {
        this.connection = connection;
    }

    public ServicoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public Servico insert(Servico servico) throws SQLException {

        String sql = "INSERT INTO servico (descricao, valor) VALUES(?,?);";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, servico.getDescricao());
        //statement.setString(2, String.valueOf(servico.getValor()));
        statement.setFloat(2, servico.getValor());

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();


        if (resultSet.next()) {

            int id = resultSet.getInt("id");
            servico.setId(id);
        }

        return servico;
    }
    
    
    
    
    public void update(Servico servico) throws SQLException {
        String sql = "update servico set descricao = ?, valor = ? where id = ?;";          
        PreparedStatement statement = connection.prepareStatement(sql);
            
        statement.setString(1, servico.getDescricao());
        statement.setFloat(2, servico.getValor());
        statement.setInt(3, servico.getId());
        statement.execute();
    }
    
    
    public void insertOrUpdate(Servico servico) throws SQLException {
        if (servico.getId() > 0) {
            update(servico);
        } else {
            insert(servico);
        }
    }
    
    
    public void delete(Servico servico) throws SQLException {
        String sql = "delete from servico where id = ?;";            
        PreparedStatement statement = connection.prepareStatement(sql);
            
        statement.setInt(1, servico.getId());
        statement.execute(); 
    }
    
    
    public ArrayList<Servico> selectAll() throws SQLException {
        String sql = "select * from servico;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }

    private ArrayList<Servico> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Servico> servicos = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String descricao = resultSet.getString("descricao");
            float valor = resultSet.getFloat("valor");
            
            Servico servicoComDadosDoBanco = new Servico(id, descricao, valor);
            servicos.add(servicoComDadosDoBanco);
        }
        return servicos;
    }
    
    
    public Servico selectPorId(Servico servico) throws SQLException {
        String sql = "select * from servico where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);        
        statement.setInt(1, servico.getId());
        
        return pesquisa(statement).get(0);
    }

    
}
