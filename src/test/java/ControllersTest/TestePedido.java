package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import Controllers.PedidoDAO;
import Models.*;

public class TestePedido {
	@Test
	public void criarVazio() {
		PedidoDAO daoPedido = new PedidoDAO();
		Pedido pedido = new Pedido();
		ArrayList<Produto> lista = new ArrayList<>();

		pedido.setPedidoNomeCliente("Claudio");
		pedido.setPedidoTelefoneCliente("(11)22222-3333");
		pedido.setPedidoId(1);
		pedido.setPedidoTotal(35.50f);

		daoPedido.criaPedido(pedido, lista);
		assertEquals(null, daoPedido.listaPedidos());
	}
}