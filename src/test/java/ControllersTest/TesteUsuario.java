package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controllers.UsuarioDAO;
import Models.Usuario;

public class TesteUsuario {

	@Test
	public void testeCria() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		Usuario usuario = new Usuario();

		usuario.setUsuarioNome("Claudio");
		usuario.setUsuarioLogin("admin1");
		usuario.setUsuarioPassword("12345");
		usuario.setUsuarioEmail("claudio@uol.com.br");
		usuario.setUsuarioTipo("admin");

		daoUsuario.criaUsuario(usuario);
	}

	@Test
	public void testeAutenticaCon() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		Usuario usuario = new Usuario(1, "Claudio", "claudio", "12345", "claudio@uol.com.br", "admin");

		daoUsuario.userAutentica(usuario);
	}

	@Test
	public void testeAutenticaSet() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		Usuario usuario = new Usuario();

		usuario.setUsuarioNome("Claudio");
		usuario.setUsuarioLogin("admin1");
		usuario.setUsuarioPassword("12345");
		usuario.setUsuarioEmail("claudio@uol.com.br");
		usuario.setUsuarioTipo("admin");

		daoUsuario.userAutentica(usuario);
	}

	@Test
	public void testeAlterar() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		Usuario usuario = new Usuario();

		usuario.setUsuarioNome("Claudio");
		usuario.setUsuarioLogin("admin1");
		usuario.setUsuarioPassword("12345");
		usuario.setUsuarioEmail("claudio@uol.com.br");
		usuario.setUsuarioTipo("admin");

		daoUsuario.alterarUsuario(usuario);
	}

	@Test
	public void testeDeletar() {
		UsuarioDAO daoUsuario = new UsuarioDAO();
		Usuario usuario = new Usuario();

		usuario.setUsuarioNome("Claudio");
		usuario.setUsuarioLogin("admin1");
		usuario.setUsuarioPassword("12345");
		usuario.setUsuarioEmail("claudio@uol.com.br");
		usuario.setUsuarioTipo("admin");

		daoUsuario.deletarUsuario(usuario);
	}

	@Test
	public void testeEmail() {
		UsuarioDAO daoUsuario = new UsuarioDAO();

		assertFalse(daoUsuario.verificaSeEmailExiste("uol@uol.com.br"));
	}

	@Test
	public void testeLogin() {
		UsuarioDAO daoUsuario = new UsuarioDAO();

		assertFalse(daoUsuario.verificaSeLoginExiste("login"));
	}
}