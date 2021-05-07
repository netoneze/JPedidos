package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import Models.*;
import java.text.ParseException;

public class PedidoControllerTest {
	@Test
	public void criarVazio() throws ParseException {
		Pedido pedido = new Pedido();
		ArrayList<Produto> lista = new ArrayList<Produto>();

		pedido.setPedidoNomeCliente("Claudio");
		pedido.setPedidoTelefoneCliente("(11)22222-3333");
		pedido.setPedidoId(1);
		pedido.setPedidoTotal(35.50f);
                pedido.setUsuarioId(1);
                
		assertTrue(pedido.criaPedido(pedido, lista));
	}
}