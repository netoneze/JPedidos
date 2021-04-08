package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestePedidoHasProduto {
	
	@Test
	public void testSetGet() {
		PedidoHasProduto php = new PedidoHasProduto();
		php.setPedidoId(1);
		php.setProdutoId(1);
		String res = String.valueOf(php.getPedidoId()) + "\n" + String.valueOf(php.getProdutoId()) + "\n";

		assertEquals(res, php.toString());
	}
	
	@Test
	public void testCon() {
		PedidoHasProduto php = new PedidoHasProduto(1, 1);

		assertEquals((1 +"\n" + 1 + "\n"), php.toString());
	}
}