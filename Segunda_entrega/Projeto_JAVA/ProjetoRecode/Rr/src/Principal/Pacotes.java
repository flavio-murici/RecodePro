package Principal;



public class Pacotes {
	
	
	private int id_pacote;
	private String nome_pacote;
	private String valor_pacote;
	
	

	public Pacotes(int id_pacote, String nome_pacote, String valor_pacote) {
		super();
		this.id_pacote = id_pacote;
		this.nome_pacote = nome_pacote;
		this.valor_pacote = valor_pacote;
		
	}
	public Pacotes() {
		
	}
	public int getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}
	public String getNome_pacote() {
		return nome_pacote;
	}
	public void setNome_pacote(String nome_pacote) {
		this.nome_pacote = nome_pacote;
	}
	public String getValor_pacote() {
		return valor_pacote;
	}
	public void setValor_pacote(String valor_pacote) {
		this.valor_pacote= valor_pacote;
	}	
	
}
	
	
