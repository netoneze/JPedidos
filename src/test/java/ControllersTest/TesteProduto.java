package Controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Produto;

public class TesteProduto {
	@Test
	public void testProduto() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, "x-salada", "pao, carne, queijo e salada", 12.50f);

		assertTrue(prod.criaProduto(produto));
	}

	@Test
	public void testProdutoVazio() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto();

		assertFalse(prod.criaProduto(produto));
	}

	@Test
	public void testProdutoNome() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, null, "pao, carne, queijo e salada", 12.50f);

		assertTrue(prod.criaProduto(produto));
	}

	@Test
	public void testProdutoDesc() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, "x-salada", null, 12.50f);

		assertTrue(prod.criaProduto(produto));
	}

	@Test
	public void testDelProd() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, "x-salada", "pao, carne, queijo e salada", 12.50f);

		assertTrue(prod.deletaProduto(produto));
	}

	@Test
	public void testDelProdVazio() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto();

		assertFalse(prod.deletaProduto(produto));
	}

	@Test
	public void testDelProdNome() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, null, "pao, carne, queijo e salada", 12.50f);

		assertFalse(prod.deletaProduto(produto));
	}

	@Test
	public void testDelProdDesc() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, "x-salada", null, 12.50f);

		assertFalse(prod.deletaProduto(produto));
	}

	@Test
	public void testAttProd() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, "x-salada", "pao, carne, queijo e salada", 12.50f);

		assertTrue(prod.atualizaProduto(produto));
	}

	@Test
	public void testAttProdVazio() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto();

		assertFalse(prod.atualizaProduto(produto));
	}

	@Test
	public void testAttProdNome() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, null, "pao, carne, queijo e salada", 12.50f);

		assertFalse(prod.atualizaProduto(produto));
	}

	@Test
	public void testAttProdDesc() {
		ProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto(1, "x-salada", null, 12.50f);

		assertFalse(prod.atualizaProduto(produto));
	}

}