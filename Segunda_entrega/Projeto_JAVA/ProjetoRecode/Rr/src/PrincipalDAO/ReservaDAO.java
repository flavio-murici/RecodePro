package PrincipalDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Principal.Conexao;
import Principal.Reserva1;

public class ReservaDAO {
	private Connection conexao;

	public ReservaDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void criarReserva(Reserva1 reserva) {
		String sql = "INSERT INTO reserva ( dataEntrada, dataSaida , pagamento) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, reserva.getReserva_id());
			stmt.setDate(2, reserva.getDataEntrada());
			stmt.setDate(3, reserva.getDataSaida());
			stmt.setString(4, reserva.getPagamento());
		} catch (SQLException e) {
			System.out.println("erro em criar reserva");
			e.printStackTrace();
		}
	}

	public Reserva1 buscarReserva(int id) {
		Reserva1 reserva = null;
		String sql = "SELECT * FROM reserva WHERE ID = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(id, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				reserva = new Reserva1(1, null, null, sql);
				reserva.setReserva_id(resultado.getInt("id"));
				reserva.setDataSaida(resultado.getDate("dataEntrada"));
				reserva.setDataSaida(resultado.getDate("dataSaida"));
				reserva.setPagamento(resultado.getString("pagamento"));

			}

		} catch (SQLException e) {
			System.out.println("erro na busca da reserva");
			e.printStackTrace();
		}

		return reserva;
	}
	public void atualizarReserva(Reserva1 reserva) {
		String sql = " UPDATE RESERVA SET NOME = ?, dataPagamento = ?  WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, reserva.getReserva_id());
			stmt.setDate(2, reserva.getDataEntrada());
			stmt.setDate(3, reserva.getDataSaida());
			stmt.setString(4, reserva.getPagamento());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erro na atualiação");
			e.printStackTrace();
		}
	}
	

	public void excluirReserva(int date) {
		String sql = "DELETE FROM RESERVA WHERE ID = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1,date);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erro ao excluir reserva");
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
