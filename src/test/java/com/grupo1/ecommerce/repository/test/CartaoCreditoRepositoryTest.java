package com.grupo1.ecommerce.repository.test;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.stereotype.Repository;

import com.grupo1.ecommerce.model.CartaoCredito;
import com.grupo1.ecommerce.repository.CartaoCreditoRepository;

@Repository
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
		Optional<CartaoCredito> cartao = cartaoCreditoRepository.findByNumeroCartao("5349078312606358");
		assertTrue(cartao.get().getNumeroCartao().equals("5349078312606358"));
	}
}