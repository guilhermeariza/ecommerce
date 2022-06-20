package com.grupo1.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho {
	
	@Id
	private Long id;
	
	@NotNull
	private Boolean status;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	private int periodoLocacao;
	
	@ManyToOne
	@JsonIgnoreProperties("carrinho")
	private Produto produto;
	
	@OneToOne
	@JsonIgnoreProperties("carrinho")
	private PessoaJuridica pessoaJuridica;
	
	
	public Carrinho(Long id, Boolean status, int quantidade, int periodoLocacao) {
		this.id = id;
		this.status = status;
		this.quantidade = quantidade;
		this.periodoLocacao = periodoLocacao;

	}

	public Carrinho() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getPeriodoLocacao() {
		return periodoLocacao;
	}

	public void setPeriodoLocacao(int periodoLocacao) {
		this.periodoLocacao = periodoLocacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

}
