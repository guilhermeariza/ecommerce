package com.grupo1.ecommerce.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.grupo1.ecommerce.model.CartaoCredito;
import com.grupo1.ecommerce.repository.CartaoCreditoRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartaoCreditoControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	@BeforeAll
	void start() {
		cartaoCreditoRepository.deleteAll();
	}
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar um cartão")
	public void deveCriarUmCartao() {
		HttpEntity<CartaoCredito> requisicao = new HttpEntity<CartaoCredito>(new CartaoCredito(0L, "Inter", "Fabio", "5568643725859482", "02/26", "487"));
		ResponseEntity<CartaoCredito> resposta = testRestTemplate.exchange("/cartaocredito/cadastrar", HttpMethod.POST, requisicao, CartaoCredito.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNumeroCartao(), resposta.getBody().getNumeroCartao());
	}
}