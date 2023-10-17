package PrincipalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Principal.Conexao;
import Principal.Usuario;

public class UsuarioDAO {

	private  Connection conexao;

	public UsuarioDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarUsuario(Usuario usuario) {
		String sql = "INSERT INTO Usuarios ( nome, cpf, email, telefone, endereco ) VALUES (?, ? , ? , ? ,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getCpf());
			stmt.setString(3, usuario.getEmail());
			stmt.setInt(4, usuario.getTelefone());
			stmt.setString(5, usuario.getEndereco());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao se cadastrar!");
			e.printStackTrace();

		}
	}


	public Usuario buscarUsuario(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM Usuarios WHERE id = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				usuario = new Usuario();
				usuario.setUsuario_id(id);
				usuario.setNome(resultado.getString("nome"));
				usuario.setCpf(resultado.getInt("cpf"));
			}
			} catch (SQLException e) {
				System.out.println("Erro encontrado");
				e.printStackTrace();
			}

		return usuario;
	}

	public void atualizarUsuario(Usuario usuario) {
		String sql = "UPDATE Usuarios SET id = ? , nome = ?, cpf = ? , email = ? , WHERE ID = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, usuario.getUsuario_id());
			stmt.setString(2, usuario.getNome());
			stmt.setInt(3, usuario.getCpf());
			stmt.setNString(3, usuario.getEmail());
		} catch (SQLException e) {
			System.out.println("Erro encontrado");
			e.printStackTrace();
		}
	}

	public void  excluirUsuario(int id) {
		String sql = "DELETE FROM Usuarios WHERE ID = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
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
