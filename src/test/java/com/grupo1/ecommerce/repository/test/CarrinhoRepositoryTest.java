package com.grupo1.ecommerce.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.stereotype.Repository;

import com.grupo1.ecommerce.model.Carrinho;

import com.grupo1.ecommerce.repository.CarrinhoRepository;

@Repository
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarrinhoRepositoryTest {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@BeforeAll
	void start() {
		carrinhoRepository.deleteAll();
		carrinhoRepository.save(new Carrinho(0L, true, 40, 1));
		carrinhoRepository.save(new Carrinho(0L, false, 30, 10));
		carrinhoRepository.save(new Carrinho(0L, false, 10, 20));
		carrinhoRepository.save(new Carrinho(0L, false, 20, 20));
	}
	
	@Test
	@DisplayName("Retorna 1 carrinho")
	public void deveRetornarUmUsuario() {
		Optional<Carrinho> carrinho = carrinhoRepository.findByStatus(true);
		assertTrue(carrinho.get().getStatus().equals(true));
	}
	
	@Test
	@DisplayName("Retorna 3 carrinho")
	public void deveRetornarTresUsuarios() {
		List<Carrinho> listaDeCarrinhos = carrinhoRepository.findAll();
		
		assertEquals(3, listaDeCarrinhos.size());
		assertTrue(listaDeCarrinhos.get(0).getStatus().equals(true));																			
		assertTrue(listaDeCarrinhos.get(1).getStatus().equals(false));

	}
}
