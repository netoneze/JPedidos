package ModelsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Usuario;

public class TesteUsuario {

	@Test
	public void testCon() {
		Usuario usuario = new Usuario(1, "Claudio", "admin1", "12345", "claudio@uol.com.br", "admin");
		String res = ("1" + "\n" + "Claudio" + "\n" + "admin1" + "\n" + "12345" + "\n" + "claudio@uol.com.br" + "\n" + "admin" + "\n");
		assertEquals(res, usuario.toString());
	}
	
	@Test
	public void testSetGet() {
		Usuario usuario = new Usuario();

		usuario.setUsuarioId(1);
		usuario.setUsuarioNome("Claudio");
		usuario.setUsuarioLogin("admin1");
		usuario.setUsuarioPassword("12345");
		usuario.setUsuarioEmail("claudio@uol.com.br");
		usuario.setUsuarioTipo("admin");

		assertEquals(1, usuario.getUsuarioId());
		assertEquals("Claudio", usuario.getUsuarioNome());
		assertEquals("admin1", usuario.getUsuarioLogin());
		assertEquals("12345", usuario.getUsuarioPassword());
		assertEquals("claudio@uol.com.br", usuario.getUsuarioEmail());
		assertEquals("admin", usuario.getUsuarioTipo());
	}
}