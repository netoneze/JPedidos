package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controllers.UsuarioController;

public class TesteUsuario {

	@Test
	public void testeCria() {
		UsuarioController usuarioController = new UsuarioController();

		assertTrue(usuarioController.criaUsuario("Claudio", "claudinho@bol.com.br", "claudioadmin", "123456", "administrador"));
	}

	@Test
	public void testeAutenticaCon() {
		UsuarioController usuarioController = new UsuarioController();

		assertTrue(usuarioController.userAutentica("claudioadmin", "123456"));
	}

	@Test
	public void testeAlterar() {
		UsuarioController usuarioController = new UsuarioController();

		assertTrue(usuarioController.alterarUsuario(4, "Claudio Ferreira", "claudinho2@bol.com.br", "claudioadmin", "administrador", "123456"));
	}

	@Test
	public void testeDeletar() {
		UsuarioController usuarioController = new UsuarioController();

		assertTrue(usuarioController.deletarUsuario(4, "Claudio Ferreira", "claudinho2@bol.com.br"));
	}

	@Test
	public void testeEmail() {
		UsuarioController usuarioController = new UsuarioController();

		assertFalse(usuarioController.verificaSeEmailExiste("bol@hotmail.com.br"));
	}

	@Test
	public void testeLogin() {
		UsuarioController usuarioController = new UsuarioController();

		assertFalse(usuarioController.verificaSeLoginExiste("login"));
	}
}