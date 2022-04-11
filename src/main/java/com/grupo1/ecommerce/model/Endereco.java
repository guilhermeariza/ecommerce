package com.grupo1.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min = 1, max = 20)
	private String status;
	

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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}