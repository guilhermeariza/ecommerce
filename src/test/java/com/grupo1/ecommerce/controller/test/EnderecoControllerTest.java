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

import com.grupo1.ecommerce.model.Endereco;
import com.grupo1.ecommerce.repository.EnderecoRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnderecoControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@BeforeAll
	void start() {
		enderecoRepository.deleteAll();
	}
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar um endereço")
	public void deveCriarUmEndereco() {
		HttpEntity<Endereco> requisicao = new HttpEntity<Endereco>(new Endereco(0L, "Avenida São João", "08717890", true));
		ResponseEntity<Endereco> resposta = testRestTemplate.exchange("/endereco/cadastrar", HttpMethod.POST, requisicao, Endereco.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getId(), resposta.getBody().getId());
	}
}





