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

import com.grupo1.ecommerce.model.Usuario;
import com.grupo1.ecommerce.repository.UsuarioRepository;

@Repository
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {



@Autowired
private UsuarioRepository usuarioRepository;

@BeforeAll
void start()
{
	usuarioRepository.deleteAll();
	usuarioRepository.save(new Usuario(0L,"paula.campanholi@hotmail.com","12345678"));
	usuarioRepository.save(new Usuario(0L,"vinicius.campanholi@gmail.com","13456789"));
	usuarioRepository.save(new Usuario(0L,"sandra.campanholi@hotmail.com","234567890"));
	usuarioRepository.save(new Usuario(0L,"guilhereme.ariza@hotmail.com","345678901"));
}

@Test
@DisplayName("Retorna 1 usuario")
public void deveRetornarUmUsuario()
{
	Optional<Usuario> usuario = usuarioRepository.findByUsuario("vinicius.campanholi@gmail.com");
	assertTrue(usuario.get().getUsuario().equals("vinicius.campanholi@gmail.com"));
}

@Test
@DisplayName("Retorna 3 usuarios")
public void deveRetornarTresUsuarios()
{
	List<Usuario> listaDeUsuarios = usuarioRepository.findAllByUsuarioContainingIgnoreCase("campanholi");
	// cria uma lista de usuarios que tenham em alguma parte do nome o nome colmeia
	assertEquals(3,listaDeUsuarios.size()); // neste assert para o teste ser positivo ( que é a intenção) 3 usuario tem que ter o nome colmeia 
	assertTrue(listaDeUsuarios.get(0).getUsuario().equals("paula.campanholi@hotmail.com"));// vai pegar o primeiro usuario criado na minha lista cima  e comparar com o nome que esta no meu teste
	assertTrue(listaDeUsuarios.get(1).getUsuario().equals("vinicius.campanholi@gmail.com"));
	assertTrue(listaDeUsuarios.get(2).getUsuario().equals("guilhereme.ariza@hotmail.com"));
}

}
