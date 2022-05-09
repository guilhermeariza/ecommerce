package com.grupo1.ecommerce.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

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

import com.grupo1.ecommerce.model.Usuario;
import com.grupo1.ecommerce.repository.UsuarioRepository;
import com.grupo1.ecommerce.service.UsuarioService;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
//cria uma unica instancia ( objeto) para ser testato em toda a classe // o mesmo objeto em todo os testes // O PER_METHOD ,cria uma instancia para cada metodo.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
// segue ordem crescente // prioridade em ordem crescente idenpendete do numero que for inserido no atributo

public class UsuarioControllerTest {


	@Autowired
	private TestRestTemplate testRestTemplate; 
	// é uma cliente http , similar ao postman , usamos para fazer a requisição
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll 
	// Anotação indica que o metodo precisa ser executado  antes dos demais , só executa uma vez // before eache - vai executar o metodo antes de cada teste
	void start()
	{
		usuarioRepository.deleteAll();
	}
	
	// ou seja neste caso vai limpar o banco somente uma vez
	
	@Test
	// indica que o metodo a ser executado vai pertencer a minha classe de teste
	
	@Order(1) 
	//ordena o meu teste
	
	@DisplayName("Cadastrar um Usuário")
	// cria um apelido para meu metodo para ele ser exibido no console de forma mais organizada // 
	//	bem util se o metodo estiver escrito em ingles e eu queira imprimir no console um apelido em portugues
	
	public void deveCriarUmUsuario() // ( preparação do contexto do teste)
	{
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L,"paloma.campanholi@gmail.com","13456789")); 
		// armazendo na memoria do computador do cliente// um tipo de mock , dado para dar contexto para o teste 
		
		ResponseEntity<Usuario> resposta = testRestTemplate // resposta da requisição //
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao,Usuario.class);
		// aqui efetivamente vai a requisição para o banco  // .exchange troca de informações 
		
		assertEquals(HttpStatus.CREATED,resposta.getStatusCode()); 
		//assertEquals > serve para  ver a validade  de uma condição ( que tem que ser assertiva) , 
		//se a condição for falsa ele vai retornar um erro no codigo 
		//metodo que se comunica direto com Junit e ao final do teste o Junit vai trazar um relatorio mostrando quais foram as assertivas e os erro 
		// vai comparar 2 argumentos e ver se o usuario foi criado pela resposta
		
	
		//(assertEquals espera 2 argumentos, e vai comparar as duas para ver se estão iguais )
		assertEquals(requisicao.getBody().getUsuario(),resposta.getBody().getUsuario()); 
		// vai comparar item a item
		
		
		//HttpEntity passando um objeto que vai ser um corpo da requisição, vai preencher o cabeçalho da requisição  
	}
	
	@Test
	@Order(2)
	@DisplayName("Não deve permitir duplicação de usuário")
	public void naoDeveDuplicarUsuario()
	{
		usuarioService.CadastrarUsuario(new Usuario(0L,"bianca.ariza@gmail.com","13456789"));
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L,"bianca.ariza@gmail.com","13456789"));
		ResponseEntity<Usuario> resposta = testRestTemplate
				.exchange("/usuarios/cadastrar",HttpMethod.POST,requisicao,Usuario.class);
		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode()); 
		// HttpEntity.bad _request é a resposta que me garante  que o usuario não foi duplicado  e esta puxando a exceção do Usuario service  // 
	}
	
	@Test
	@Order(3)
	@DisplayName("Alterar um usuário")
	public void deveAlterarUmUsuario()
	{
		Optional<Usuario> usuarioCreate = usuarioService.CadastrarUsuario(new Usuario(0L,"bianca.ariza@gmail.com","13456789"));
		Usuario usuarioUpdate = new Usuario(usuarioCreate.get().getId(),"bianca.arizaantunes@gmail.com","13456789");
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuarioUpdate);
		ResponseEntity<Usuario> resposta = testRestTemplate
				.withBasicAuth("root", "root") 
				// qualquer pessoa que usuar este usuario e senha poderá autenticar o acesso a end point´s diferentes dos que estão autenticado na BasicSecutityConfig 
				.exchange("/usuarios/cadastrar",HttpMethod.PUT,requisicao,Usuario.class);
		assertEquals(HttpStatus.OK,resposta.getStatusCode());
		assertEquals(usuarioUpdate.getUsuario(),resposta.getBody().getUsuario());
		
	}
}



