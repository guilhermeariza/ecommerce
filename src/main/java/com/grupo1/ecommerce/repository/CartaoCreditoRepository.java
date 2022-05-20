package com.grupo1.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo1.ecommerce.model.CartaoCredito;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long>{

	public List<CartaoCredito> findAllByApelidoContainingIgnoreCase(String apelido);

	//Busca por número de cartão
	public Optional<CartaoCredito> findByNumeroCartao(String numeroCartao);

}
