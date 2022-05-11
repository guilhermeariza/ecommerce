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

import com.grupo1.ecommerce.model.Carrinho;
import com.grupo1.ecommerce.repository.CarrinhoRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarrinhoControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@BeforeAll
	void start() {
		carrinhoRepository.deleteAll();
	}
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar um carrinho")
	public void deveCriarUmCarrinho() {
		HttpEntity<Carrinho> requisicao = new HttpEntity<Carrinho>(new Carrinho(
				0L, true, 40));
		ResponseEntity<Carrinho> resposta = testRestTemplate
				.exchange("/carrinho/cadastrar", HttpMethod.POST, requisicao, Carrinho.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getId(), resposta.getBody().getId());
		
	}
	
	
}
