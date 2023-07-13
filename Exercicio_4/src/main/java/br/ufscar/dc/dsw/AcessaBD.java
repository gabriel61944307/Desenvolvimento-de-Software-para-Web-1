package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Livraria";
			Connection con = (Connection) DriverManager.getConnection(url,
					"root", "12345678");

			Statement stmt = con.createStatement();
			Statement stmt_aux = con.createStatement();
			stmt.executeUpdate("INSERT INTO editora (cnpj, nome) VALUES ('87.557.922/0001-82', 'Seguinte')");

			//Recuperando o id da editora
			ResultSet rs = stmt.executeQuery("SELECT id FROM editora WHERE nome = 'Seguinte'");
			long id_editora = -1;
			while(rs.next()) id_editora = rs.getInt("id");

			//Adicionar novo livro
			PreparedStatement add_livro = con.prepareStatement("INSERT INTO livro (titulo, autor, ano, preco, editora_id) VALUES (? , ?, ?, ?, ?)");
			add_livro.setString(1, "O Dia do Curinga");
			add_livro.setString(2, "Jostein Gaarder");
			add_livro.setInt(3, 1996);
			add_livro.setDouble(4, 29.99);
			add_livro.setLong(5, id_editora);
			add_livro.executeUpdate();

			//Recuperando o id da editora
			rs = stmt.executeQuery("SELECT id FROM editora WHERE nome = 'Companhia das Letras'");
			id_editora = -1;
			while(rs.next()) id_editora = rs.getInt("id");

			//Adicionar novo livro
			PreparedStatement add_novo_livro = con.prepareStatement("INSERT INTO livro (titulo, autor, ano, preco, editora_id) VALUES (? , ?, ?, ?, ?)");
			add_novo_livro.setString(1, "A Revolução dos Bichos");
			add_novo_livro.setString(2, "George Orwell");
			add_novo_livro.setInt(3, 2007);
			add_novo_livro.setDouble(4, 23.90);
			add_novo_livro.setLong(5, id_editora);
			add_novo_livro.executeUpdate();


			rs = stmt.executeQuery("SELECT * FROM Livro ORDER BY preco ASC");
			while (rs.next()) {
				System.out.print(rs.getString("Titulo"));
				System.out.print(", " + rs.getString("Autor"));

				ResultSet aux = stmt_aux.executeQuery("SELECT nome FROM editora WHERE id =" + rs.getInt("editora_id"));
				while(aux.next()) System.out.print(", " + aux.getString("nome"));
				aux.close();

				System.out.print(", " + rs.getInt("Ano"));
				System.out.println(" (R$ " + rs.getFloat("Preco") + ")");
			}

			add_novo_livro.close();
			add_livro.close();
			stmt.close();
			stmt_aux.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de conexão não foi encontrada!");
		} catch (SQLException e) {
			System.out.println("O comando SQL não pode ser executado!");
		}
	}
}
