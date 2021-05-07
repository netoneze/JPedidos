package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controllers.ProdutoController;

public class ProdutoControllerTest {
	@Test
	public void testProduto() {
		ProdutoController produtoController = new ProdutoController();

		assertTrue(produtoController.criaProduto("x-salada", 15.99f, "pao, carne, queijo e salada"));
	}

	@Test
	public void testProdutoVazio() {
		ProdutoController produtoController = new ProdutoController();

		assertFalse(produtoController.criaProduto("", 0f, ""));
	}

	@Test
	public void testProdutoNome() {
		ProdutoController produtoController = new ProdutoController();

                assertThrows(NullPointerException.class, () -> {
                    assertFalse(produtoController.criaProduto(null, 15.99f, "pao, carne, queijo e salada"));
                });
	}

	@Test
	public void testProdutoDesc() {
		ProdutoController produtoController = new ProdutoController();

                assertThrows(NullPointerException.class, () -> {
                    assertFalse(produtoController.criaProduto("x-salada", 15.99f, null));
                });
	}

	@Test
	public void testDelProd() {
		ProdutoController produtoController = new ProdutoController();
		int produtoId = 1;

		assertTrue(produtoController.deletaProduto(produtoId, "x-salada", "pao, carne, queijo e salada"));
	}

	@Test
	public void testDelProdVazio() {
		ProdutoController produtoController = new ProdutoController();
                int produtoId = 1;
                
		assertFalse(produtoController.deletaProduto(produtoId, "", ""));
	}

	@Test
	public void testDelProdNome() {
		ProdutoController produtoController = new ProdutoController();
                int produtoId = 1;

                assertThrows(NullPointerException.class, () -> {
                    assertFalse(produtoController.deletaProduto(produtoId, null, "pao, carne, queijo e salada"));
                });
	}

	@Test
	public void testDelProdDesc() {
		ProdutoController produtoController = new ProdutoController();
                int produtoId = 1;

                assertThrows(NullPointerException.class, () -> {
                    assertFalse(produtoController.deletaProduto(produtoId, "x=salada", null));
                });
	}

	@Test
	public void testAttProd() {
		ProdutoController produtoController = new ProdutoController();
		int produtoId = 2;
                
		assertTrue(produtoController.atualizaProduto("x-salada PLUS", 15.99f, "pao, carne, queijo e muito mais salada", produtoId));
	}

	@Test
	public void testAttProdVazio() {
		ProdutoController produtoController = new ProdutoController();
		int produtoId = 2;
                
		assertFalse(produtoController.atualizaProduto("", 0f, "", produtoId));
	}

	@Test
	public void testAttProdNome() {
		ProdutoController produtoController = new ProdutoController();
		int produtoId = 2;
                
		assertThrows(NullPointerException.class, () -> {
                    produtoController.atualizaProduto(null, 0f, "pao, carne, queijo e salada", produtoId);
                });
	}

	@Test
	public void testAttProdDesc() {
		ProdutoController produtoController = new ProdutoController();
		int produtoId = 2;
                
                assertThrows(NullPointerException.class, () -> {
                    assertFalse(produtoController.atualizaProduto("x-salada", 15.99f, null, produtoId));
                });
	}

}