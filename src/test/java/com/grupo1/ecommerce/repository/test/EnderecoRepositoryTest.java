package com.grupo1.ecommerce.repository.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.stereotype.Repository;

import com.grupo1.ecommerce.model.Endereco;
import com.grupo1.ecommerce.repository.EnderecoRepository;

@Repository
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@BeforeAll
	void start() {
		enderecoRepository.deleteAll();
		enderecoRepository.save(new Endereco(0L, "Avenida 1", "123456789"));
		enderecoRepository.save(new Endereco(0L, "Avenida 2", "123456789"));
		enderecoRepository.save(new Endereco(0L, "Avenida 3", "123456789"));
		enderecoRepository.save(new Endereco(0L, "Avenida 4", "123456789"));

	}
	
}

