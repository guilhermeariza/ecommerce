package com.grupo1.ecommerce.repository.test;

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

import com.grupo1.ecommerce.model.PessoaJuridica;
import com.grupo1.ecommerce.repository.PessoaJuridicaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Repository
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaJuridicaRepositoryTest {
	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@BeforeAll
	void start() {
		pessoaJuridicaRepository.deleteAll();
		pessoaJuridicaRepository.save(new PessoaJuridica(0L,"PortoSeguro","Porto","portoseguro@gmail.com","20.813.812/0001-63","Rua do Broto, 30","35625-010"));
		pessoaJuridicaRepository.save(new PessoaJuridica(0L,"Porto1","Porto","porto1@gmail.com","11.141.550/0001-47","Rua do Broto, 31", "35625-011"));
		pessoaJuridicaRepository.save(new PessoaJuridica(0L,"Porto2","Porto","porto2@gmail.com","37.571.747/0001-00","Rua do Broto, 32", "35625-012"));
		pessoaJuridicaRepository.save(new PessoaJuridica(0L,"Porto3","Porto","porto3@gmail.com","13.551.912/0001-01","Rua do Broto, 33", "35625-013"));
	}
	
	@Test
	@DisplayName("Retorna Pessoa Juridica")
	public void deveRetornarPessoaJuridica() {
		
		Optional<PessoaJuridica> PessoaJuridica = pessoaJuridicaRepository.findByCnpj("20.813.812/0001-63");
		assertTrue(PessoaJuridica.get().getCnpj().equals("20.813.812/0001-63"));
	}
	
	@Test
	@DisplayName("Retorna 3 Pessoas Juridicas")
	public void deveRetornarTresPessoaJuridica() {
		
		List<PessoaJuridica> listaDePessoaJuridica = pessoaJuridicaRepository.findAllBynomeFantasiaContainingIgnoreCase("Porto");
		assertEquals(3,listaDePessoaJuridica.size());
		assertTrue(listaDePessoaJuridica.get(0).getNomeFantasia().equals("PortoSeguro"));
		assertTrue(listaDePessoaJuridica.get(1).getNomeFantasia().equals("Porto1"));
		assertTrue(listaDePessoaJuridica.get(2).getNomeFantasia().equals("Porto2"));
	}
	

}
