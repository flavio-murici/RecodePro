package PrincipalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Principal.Conexao;
import Principal.Pacotes;

public class PacotesDAO {

	private static Connection conexao;

	public PacotesDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarPacotes(Pacotes pacotes) {
		String sql = "INSERT * FROM  pacotes WHERE ( pacotes_id , quantidadeDias, quantidadeDePessoas , destino ,usuario_id) VALUES (?,?, ?,?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, pacotes.getPacotes_id());
			stmt.setString(2, pacotes.getQuantidadeDeDias());
			stmt.setString(3, pacotes.getQuantidadeDePessoas());
			stmt.setString(3, pacotes.getDestino());
			stmt.setInt(4, pacotes.getId_usuario());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static Pacotes buscarPacotes(int id) {
		Pacotes pacotes = null;
		String sql = "SELECT * FROM  pacotes WHERE date = ?, id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				pacotes.setPacotes_id(resultado.getInt(1));
				pacotes.setQuantidadeDeDias(resultado.getString("quantidadeDeDias"));
				pacotes.setQuantidadeDePessoas(resultado.getString("quanditadeDePessoas"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pacotes;
	}

	public void atualizarPacotes(Pacotes pacotes) {
		String sql = "UPDATE pacote SET nome = ?, idade = ? WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, pacotes.getId_usuario());
			stmt.setString(2, pacotes.getQuantidadeDeDias());
			stmt.setString(3, pacotes.getQuantidadeDePessoas());

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	public void excluirPacotes(int id) {
		String sql = "DELETE FROM pacotes WHERE id = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1,id);
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
