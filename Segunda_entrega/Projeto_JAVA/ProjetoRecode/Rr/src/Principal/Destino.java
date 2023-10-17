package Principal;

import Principal.Usuario;

public class Destino {

	private int id_destino;
	private String nome_destino;
	private String valor_destino;
	private int usuario_id;
	private String consulta_destino;
	private String destino_atualizar;
	

	public Destino(int id_destino, String nome_destino, String valor_destino, int usuario_id, String destino_atualizar) {
		super();
		this.id_destino = id_destino;
		this.nome_destino = nome_destino;
		this.valor_destino = valor_destino;
		this.usuario_id = usuario_id;
	}
	public Destino() {
		
	}
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public String getNome_destino() {
		return nome_destino;
	}
	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}
	public String getValor_viagem() {
		return valor_destino;
	}
	public static void setValor_destino(String valor_destino) {
		this.valor_destino = valor_destino;
	}

	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public void setUsuario_id(Usuario usuarioConsulta) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
	
	