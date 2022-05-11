package com.grupo1.ecommerce.repository.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo1.ecommerce.model.CartaoCredito;
import com.grupo1.ecommerce.repository.CartaoCreditoRepository;

public class CartaoCreditoRepositoryTest {

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	@BeforeAll
	void start() {
		cartaoCreditoRepository.deleteAll();
		cartaoCreditoRepository.save(new CartaoCredito(0L, "Nubank", "Vinicius", "5349078312606358", "04/23", "986"));
		cartaoCreditoRepository.save(new CartaoCredito(0L, "Inter", "Vanessa", "5210489004377925", "05/25", "448"));
		cartaoCreditoRepository.save(new CartaoCredito(0L, "Master", "Guilherme", "5557173100478511", "12/26", "734"));
	}
	
	@Test
	@DisplayName("Retorna 1 cartão")
	public void retornaUmCartao() {
		Optional<CartaoCredito> cartao = cartaoCreditoRepository.findByNumero("5349078312606358");
		assertTrue(cartao.get().getNumeroCartao().equals("5349078312606358"));
	}
}
