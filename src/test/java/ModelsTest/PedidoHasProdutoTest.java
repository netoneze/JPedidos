package ModelsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.PedidoHasProduto;

public class PedidoHasProdutoTest {
	
	@Test
	public void testSetGet() {
		PedidoHasProduto pedidoHasProduto = new PedidoHasProduto();
		pedidoHasProduto.setPedidoId(2);
		pedidoHasProduto.setProdutoId(3);
		String comp = String.valueOf(pedidoHasProduto.getPedidoId()) + "\n" + String.valueOf(pedidoHasProduto.getProdutoId()) + "\n";

		assertEquals(comp, pedidoHasProduto.toString());
	}
	
	@Test
	public void testCon() {
		PedidoHasProduto pedidoHasProduto = new PedidoHasProduto(2, 3);

		assertEquals((2 +"\n" + 3 + "\n"), pedidoHasProduto.toString());
	}
}