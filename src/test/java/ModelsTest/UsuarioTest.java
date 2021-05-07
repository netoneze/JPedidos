package ModelsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Usuario;

public class UsuarioTest {

	@Test
	public void testCon() {
		Usuario usuario = new Usuario(1, "Nelson", "nelsonadmin", "123456", "nelsontoneze@uol.com.br", "administrador");
		String comp = ("1" + "\n" + "Nelson" + "\n" + "nelsonadmin" + "\n" + "123456" + "\n" + "nelsontoneze@uol.com.br" + "\n" + "administrador" + "\n");
		assertEquals(comp, usuario.toString());
	}
	
	@Test
	public void testSetGet() {
		Usuario usuario = new Usuario();

		usuario.setUsuarioId(1);
		usuario.setUsuarioNome("Nelson");
		usuario.setUsuarioLogin("nelsonadmin");
		usuario.setUsuarioPassword("123456");
		usuario.setUsuarioEmail("nelsontoneze@uol.com.br");
		usuario.setUsuarioTipo("administrador");

		assertEquals(1, usuario.getUsuarioId());
		assertEquals("Nelson", usuario.getUsuarioNome());
		assertEquals("nelsonadmin", usuario.getUsuarioLogin());
		assertEquals("123456", usuario.getUsuarioPassword());
		assertEquals("nelsontoneze@uol.com.br", usuario.getUsuarioEmail());
		assertEquals("administrador", usuario.getUsuarioTipo());
	}
}