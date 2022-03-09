package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L,"Marcelo Abreu","marcelinho13","marcelo12345"));
		usuarioRepository.save(new Usuario(0L,"Henrique Abreu","henrique123","henrique12345"));
		usuarioRepository.save(new Usuario(0L,"Luciana Abreu","luciana123","luciana12345"));
		usuarioRepository.save(new Usuario(0L,"Pedo Abreu","pedro123","pedro12345"));	
	}
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("marcelinho13");
		assertTrue(usuario.get().getUsuario().equals("marcelinho13"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllbyNomeContainingIgnoreCase("Abreu");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Marcelo Abreu"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Henrique Abreu"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Pedro Abreu"));
		
	}
}
