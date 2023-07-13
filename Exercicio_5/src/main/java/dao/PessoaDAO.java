package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Pessoa;


public class PessoaDAO extends GenericDAO {

    public void insert(Pessoa pessoa) {

        String sql = "INSERT INTO pessoa (nome, telefone, estado, cidade, ocupacao) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getTelefone());
            statement.setString(3, pessoa.getEstado());
            statement.setString(4, pessoa.getCidade());
            statement.setString(5, pessoa.getOcupacao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pessoa> getAll() {

        List<Pessoa> listaPessoas = new ArrayList<>();

        String sql = "SELECT * from pessoa";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	Long id = resultSet.getLong("id");
            	String nome = resultSet.getString("nome");
            	String telefone = resultSet.getString("telefone");
            	String estado = resultSet.getString("estado");
            	String cidade = resultSet.getString("cidade");
            	String ocupacao = resultSet.getString("ocupacao");
            	
            	Pessoa pessoa = new Pessoa(id, nome, telefone, estado, cidade, ocupacao);
            	
            	listaPessoas.add(pessoa);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPessoas;
    }

    public void delete(Pessoa pessoa) {
        String sql = "DELETE FROM pessoa where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, pessoa.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, telefone = ?, estado = ?, cidade = ?, ocupacao = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getTelefone());
            statement.setString(3, pessoa.getEstado());
            statement.setString(4, pessoa.getCidade());
            statement.setString(5, pessoa.getOcupacao());
            statement.setLong(6, pessoa.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pessoa get(Long id) {
    	Pessoa pessoa = new Pessoa(id, null, null, null, null, null);

        String sql = "SELECT nome, telefone, estado, cidade, ocupacao from pessoa WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	pessoa.setNome(resultSet.getString("nome"));
            	pessoa.setTelefone(resultSet.getString("telefone"));
            	pessoa.setEstado(resultSet.getString("estado"));
            	pessoa.setCidade(resultSet.getString("cidade"));
            	pessoa.setOcupacao(resultSet.getString("ocupacao"));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoa;
    }
}
