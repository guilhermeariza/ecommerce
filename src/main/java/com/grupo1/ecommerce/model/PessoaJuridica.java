package com.grupo1.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_pessoa_juridica" , uniqueConstraints = {@UniqueConstraint(columnNames = {"razaoSocial","cnpj"})})
public class PessoaJuridica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nomeFantasia;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String razaoSocial;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String email;
	
    @NotNull
    @Size(min = 18, max = 18)
    private String cnpj;
    
    @OneToMany(mappedBy = "pessoaJuridica", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("pessoaJuridica")
	private List <CartaoCredito> cartaoCredito;
    
	public PessoaJuridica() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nomeFantasia;
	}

	public void setNome(String nome) {
		this.nomeFantasia = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<CartaoCredito> getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(List<CartaoCredito> cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}	