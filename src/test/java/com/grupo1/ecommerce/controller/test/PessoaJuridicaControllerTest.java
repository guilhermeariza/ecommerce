package com.grupo1.ecommerce.controller.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import com.grupo1.ecommerce.model.PessoaJuridica;
import com.grupo1.ecommerce.model.Usuario;
import com.grupo1.ecommerce.repository.PessoaJuridicaRepository;
import com.grupo1.ecommerce.service.PessoaJuridicaService;

@Controller
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaJuridicaControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;
	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@BeforeAll
	void start() {
		pessoaJuridicaRepository.deleteAll();
		
	}
	@Test
	@Order(1)
	public void deveCriarPessoaJuridica() {
		HttpEntity<PessoaJuridica> requisicao = new HttpEntity<PessoaJuridica>(new PessoaJuridica(0L,"PortoSeguro","Porto","portoseguro@gmail.com","20.813.812/0001-63","Rua do Broto, 30","35625-010"));
		
		ResponseEntity<PessoaJuridica> resposta = testRestTemplate.exchange("/pessoajuridica/cadastrar",HttpMethod.POST,requisicao,PessoaJuridica.class);
		
		assertEquals(HttpStatus.CREATED,resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNomeFantasia(),resposta.getBody().getNomeFantasia());
		assertEquals(requisicao.getBody().getRazaoSocial(),resposta.getBody().getRazaoSocial());
		assertEquals(requisicao.getBody().getCnpj(),resposta.getBody().getCnpj());
		}
		
		@Test
		@Order(2)
		@DisplayName("Não deve permitir duplicação de Pessoa Juridica")
		public void naoDeveDuplicarPessoaJuridica() {
			
			pessoaJuridicaService.CadastrarPessoaJuridica(new PessoaJuridica(0L,"Porto1","Porto","porto1@gmail.com","11.141.550/0001-47","Rua do Broto, 31", "35625-011"));
		}

		@Test
		@Order(3)
		@DisplayName("Alterar uma Pessoa Juridica")
		public void deveAlterarUmPessoaJuridica() {
			PessoaJuridica pessoaJuridicaUpdate = new PessoaJuridica(0L,"Porto2","Porto","porto2@gmail.com","37.571.747/0001-00","Rua do Broto, 32", "35625-012");
			HttpEntity<PessoaJuridica> requisicao = new HttpEntity<PessoaJuridica>(pessoaJuridicaUpdate);
			ResponseEntity<PessoaJuridica> resposta = testRestTemplate.withBasicAuth("root", "root")
					.exchange("/pessoajuridica/cadastrar", HttpMethod.PUT, requisicao, PessoaJuridica.class);
			assertEquals(HttpStatus.OK, resposta.getStatusCode());
			assertEquals(pessoaJuridicaUpdate.getCnpj(), resposta.getBody().getCnpj());
	}

}
