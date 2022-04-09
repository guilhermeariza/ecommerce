package com.grupo1.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String email;
	
	@NotNull
	private String dataNascimento;
	
	@NotNull
	@Size(min = 14, max = 14)
	private String cpf;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String enderecoCadastro;
	
	@NotNull
	@Size(min = 9, max = 9)
	private String cep;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario id_usuario;
	
	public PessoaFisica() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}