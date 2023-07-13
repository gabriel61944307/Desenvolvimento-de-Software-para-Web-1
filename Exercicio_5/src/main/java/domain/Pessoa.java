package domain;

public class Pessoa {
	private long id;
	private String nome;
	private String telefone;
	private String estado;
	private String cidade;
	private String ocupacao;
	
	public Pessoa(Long id, String nome, String telefone, String estado, String cidade, String ocupacao) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.estado = estado;
		this.cidade = cidade;
		this.ocupacao = ocupacao;
	}
	public Pessoa(String nome, String telefone, String estado, String cidade, String ocupacao) {
		this.nome = nome;
		this.telefone = telefone;
		this.estado = estado;
		this.cidade = cidade;
		this.ocupacao = ocupacao;
	}
	
	public Pessoa(Long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
}
