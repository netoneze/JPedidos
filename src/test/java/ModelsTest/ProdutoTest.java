package ModelsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Produto;

public class ProdutoTest {
	@Test
	public void prodCon() {
		Produto produto = new Produto(1, "x-salada", "pao, carne, queijo e salada", 12.50f, 1);

		assertEquals("1" + "\n" + "x-salada" + "\n" + "pao, carne, queijo e salada" + "\n" + 12.50f + "\n",
				produto.toString());
	}

	@Test
	public void prodSetGet() {
		Produto produto = new Produto();
		produto.setProdutoId(1);
		produto.setProdutoNome("x-salada");
		produto.setProdutoDescricao("pao, carne, queijo e salada");
		produto.setProdutoPreco(12.50f);
		String res = String.valueOf(produto.getProdudoId()) + "\n" + produto.getProdutoNome() + "\n"
				+ produto.getProdutoDescricao() + "\n" + produto.getProdutoPreco() + "\n";

		assertEquals(res, produto.toString());
	}

}