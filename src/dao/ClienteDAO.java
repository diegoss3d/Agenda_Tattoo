package dao;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

	private final Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	public Cliente insert(Cliente cliente) {

		String sql = "INSERT INTO cliente (nome, sexo, dataNascimento, telefone, email, rg, endereco, cep) VALUES(?,?,?,?,?,?,?,?);";

		

		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, cliente.getNome());
			statement.setString(2, String.valueOf(cliente.getSexo()));
			statement.setString(3, String.valueOf(cliente.getDataNascimento()));
			// statement.setString(3, String.valueOf(cliente.getDataNascimento()));
			statement.setString(4, cliente.getTelefone());
			statement.setString(5, cliente.getEmail());
			statement.setString(6, cliente.getRg());
			statement.setString(7, cliente.getEndereco());
			statement.setString(8, cliente.getCep());

			statement.execute();

			ResultSet resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {

				int id = resultSet.getInt("id");

				cliente.setId(id);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}

	public void update(Cliente cliente) throws SQLException {
		String sql = "update cliente set nome = ?, sexo = ?, dataNascimento = ?,  telefone = ?, email = ?, rg = ?, endereco = ?, cep = ? where id = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, cliente.getNome());
		statement.setString(2, String.valueOf(cliente.getSexo()));
		statement.setString(3, String.valueOf(cliente.getDataNascimento()));
		statement.setString(4, cliente.getTelefone());
		statement.setString(5, cliente.getEmail());
		statement.setString(6, cliente.getRg());
		statement.setString(7, cliente.getEndereco());
		statement.setString(8, cliente.getCep());

		statement.execute();
	}

	public void insertOrUpdate(Cliente cliente) throws SQLException {
		if (cliente.getId() > 0) {
			update(cliente);
		} else {
			insert(cliente);
		}
	}

	public void delete(Cliente cliente) throws SQLException {
		String sql = "delete from cliente where id = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, cliente.getId());
		statement.execute();
	}

	public ArrayList<Cliente> selectAll() throws SQLException {
		String sql = "select * from cliente;";
		PreparedStatement statement = connection.prepareStatement(sql);

		return pesquisa(statement);
	}

	private ArrayList<Cliente> pesquisa(PreparedStatement statement) throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<>();
		statement.execute();
		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String sexo = resultSet.getString("sexo");
			String dataNascimento = resultSet.getString("dataNascimento");
			String telefone = resultSet.getString("telefone");
			String email = resultSet.getString("email");
			String rg = resultSet.getString("rg");
			String endereco = resultSet.getString("endereco");
			String cep = resultSet.getString("cep");

			Cliente clienteComDadosDoBanco = new Cliente(nome, sexo.charAt(0), dataNascimento, telefone, email, rg,
					endereco, cep);
			clientes.add(clienteComDadosDoBanco);
		}
		return clientes;
	}

	public Cliente selectPorId(Cliente cliente) throws SQLException {
		String sql = "select * from cliente where id = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, cliente.getId());

		return pesquisa(statement).get(0);
	}

	public boolean existeNoBancoPorClienteESenha(Cliente cliente) throws SQLException {
		String sql = "select nome from cliente where id = ? and nome = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1, cliente.getId());
		statement.setString(2, cliente.getNome());
		statement.execute();

		ResultSet resultSet = statement.getResultSet();
		return resultSet.next();
	}

}
