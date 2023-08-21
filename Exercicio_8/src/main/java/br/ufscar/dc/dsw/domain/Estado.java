package br.ufscar.dc.dsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Estado")
public class Estado extends AbstractEntity<Long> {
	@NotBlank
	@Size(min = 3, max = 60)
	@Column(nullable = false, unique = true, length = 60)
	private String nome;

	@NotBlank
	@Size(min = 2, max = 2)
	@Column(nullable = false, unique = true, length = 2)
	private String sigla;

	@NotBlank
	@Size(max = 20)
	@Column(nullable = false, length = 20)
	private String tamanho;

	@NotBlank
	@Size(min = 1, max = 10)
	@Column(nullable = false, length = 10)
	private String populacao;

	@NotBlank
	@Size(min = 1, max = 3)
	@Column(nullable = false, length = 3)
	private String qtdCidades;

	@OneToMany(mappedBy = "estado")
	private List<Pessoa> pessoas;

	public String getNome() {
		return nome;
	}
	public String getSigla() {
		return sigla;
	}
	public String getTamanho() {
		return tamanho;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public String getPopulacao() {
		return populacao;
	}
	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}
	public String getQtdCidades() {
		return qtdCidades;
	}
	public void setQtdCidades(String qtdCidades) {
		this.qtdCidades = qtdCidades;
	}
}
