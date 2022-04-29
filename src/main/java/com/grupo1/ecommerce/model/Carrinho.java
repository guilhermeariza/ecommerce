package com.grupo1.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Boolean status;
	
	@NotNull
	private int quantidade;
	
	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("carrinho")
	private List<Produto> produto;
	
	@OneToOne
	@JsonIgnoreProperties("carrinho")
	private PessoaJuridica pessoaJuridica;
	
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
	
	

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	



}

/*@JoinTable(name = "produto_carrinho", 
uniqueConstraints = @UniqueConstraint(columnNames = {"idProduto", "idCarrinho"}),
joinColumns = @JoinColumn(name = "idCarrinho"),
inverseJoinColumns = @JoinColumn(name = "idProduto")
)*/

//@ManyToMany(mappedBy = "carrinho", cascade = CascadeType.REMOVE)