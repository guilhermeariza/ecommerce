package com.grupo1.ecommerce.model;


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
@Table(name = "tb_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size(min = 5, max = 100)
	private String enderecoCadastro;
	
	@NotNull
	@Size(min = 9, max = 9)
	private String cep;
	
	@NotNull
	private Boolean status;
	
	@ManyToOne
    @JsonIgnoreProperties("endereco")
    private PessoaJuridica pessoaJuridica;
	
	
	
	public Endereco(Long id, String enderecoCadastro, String cep, Boolean status) {
		this.id = id;
		this.enderecoCadastro = enderecoCadastro;
		this.cep = cep;
		this.status = status;
	}
	
	public Endereco() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnderecoCadastro() {
		return enderecoCadastro;
	}

	public void setEnderecoCadastro(String enderecoCadastro) {
		this.enderecoCadastro = enderecoCadastro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}


	

}