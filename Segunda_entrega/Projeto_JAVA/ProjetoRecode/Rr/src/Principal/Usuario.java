package Principal;
import Principal.Usuario;

public class Usuario {
	private int id_usuario;
	private String nome_usuario;
	private String cpf_usuario;
	private String email;
	private String telefone;
	
	
	
	public Usuario(int id_usuario, String nome_usuario, String cpf_usuario, String email, String telefone) {
		
		super();
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.cpf_usuario = cpf_usuario;
		this.email = email;
		this.telefone = telefone;
		
		
	}
	
		
		public Usuario() {
		
	}


		public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getCpf_usuario() {
		return cpf_usuario;
	}
	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
	
	

	