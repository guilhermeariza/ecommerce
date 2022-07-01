package com.grupo1.ecommerce.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeProduto;
	
	private int idProduto;
	
	private String foto;
	
	private String descricao;
	
	private String categoria;
	
	private int quantidade;
	
	private double valorUnitario;
	
	private double valorTotal;
	
	@UpdateTimestamp
	private Date data;
	
	private String status;
	
	@ManyToOne
	@JsonIgnoreProperties("carrinho")
	private Usuario usuario;
	
	
	//Endereço
	private String endereco;
	private String cep;

	//Cartao de Crédito
	private String apelidoCartao;
	private String nomeCartao;
	private String numeroCartao;
	private String dataValidadeCartao;
	private String cvvCartao;
	
	public Carrinho(Long id, String nomeProduto,int idProduto,String foto,String descricao, String categoria, int quantidade, double valorUnitario,double valorTotal,Date data,String status,String endereco,String cep,String apelido,String nomeCartao,String numeroCartao,String dataValidade,String cvvCartao) {
		this.id = id;
		this.status = status;
		this.quantidade = quantidade;
		this.idProduto = idProduto;
		this.foto = foto;
		this.descricao = descricao;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.data = data;
		this.status = status;
	}

	public Carrinho() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getApelidoCartao() {
		return apelidoCartao;
	}

	public void setApelidoCartao(String apelidoCartao) {
		this.apelidoCartao = apelidoCartao;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getDataValidadeCartao() {
		return dataValidadeCartao;
	}

	public void setDataValidadeCartao(String dataValidadeCartao) {
		this.dataValidadeCartao = dataValidadeCartao;
	}

	public String getCvvCartao() {
		return cvvCartao;
	}

	public void setCvvCartao(String cvvCartao) {
		this.cvvCartao = cvvCartao;
	}
	
	
}
