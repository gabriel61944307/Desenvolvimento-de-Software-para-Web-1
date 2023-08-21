package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pessoa")
public class Pessoa extends AbstractEntity<Long> {

	@NotBlank(message = "{NotBlank.pessoa.nome}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

	@NotBlank(message = "{NotBlank.pessoa.idade}")
	@Size(max = 3)
	@Column(nullable = false, length = 60)
	private String idade;
    
	@NotNull(message = "{NotNull.pessoa.estado}")
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	@NotBlank(message = "{NotBlank.pessoa.cidade}")
	@Size(max = 20)
	@Column(nullable = false, length = 60)
	private String cidade;

	@NotBlank(message = "{NotBlank.pessoa.bairro}")
	@Size(max = 20)
	@Column(nullable = false, length = 60)
	private String bairro;

	public String getNome() {
		return nome;
	}
	public String getIdade() {
		return idade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
