package com.grupo1.ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_cartao_credito")
public class CartaoCredito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 10)
	private String apelido;
	
	@NotNull
	@Size(min = 5, max = 10)
	private String pessoaCartao;
	
	@NotNull
	@Size(min = 16, max = 16)
	private String numeroDoCartao;
	
	@NotNull
	private String dataValidade;
	
	@NotNull
	@Size(min = 3, max = 3)
	private String cvv;
	
	@ManyToOne
	@JsonIgnoreProperties("CartaoCredito")
	private PessoaJuridica pessoaJuridica;
	
	public CartaoCredito() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getPessoaCartao() {
		return pessoaCartao;
	}

	public void setPessoaCartao(String pessoaCartao) {
		this.pessoaCartao = pessoaCartao;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(String numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	
}