package ModelsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Pedido;

public class TestePedido {
	
	@Test
	public void testSetGet() {
		Pedido pedido = new Pedido();
		pedido.setPedidoId(1);
		pedido.setUsuarioId(1);
		pedido.setCriadoEm("12/10/2021 12:00");
		pedido.setFechadoEm("12/10/2021 12:00");
		pedido.setPedidoNomeCliente("Nelson Toneze");
		pedido.setPedidoStatus("Fechado");
		pedido.setPedidoTelefoneCliente("4398489595");
		String comp = String.valueOf(pedido.getPedidoId()) + "\n" + pedido.getPedidoNomeCliente() + "\n" + pedido.getPedidoTelefoneCliente() + "\n" + pedido.getUsuarioId() + "\n" +
		pedido.getPedidoStatus() + "\n" + pedido.getCriadoEm() + "\n" + pedido.getFechadoEm() + "\n";
		
		assertEquals(comp, pedido.toString());
	}

	
	@Test
	public void testCon() {
		Pedido pedido = new Pedido(1, "Nelson Toneze", "4398489595", 1, "Fechado", "12/10/2021 12:00", "12/10/2021 12:00");
		
		assertEquals((1 + "\n" + "Nelson Toneze" + "\n" + "4398489595" + "\n" + 1 + "\n" + "Fechado" + "\n" + "12/10/2021 12:00" + "\n" + "12/10/2021 12:00" + "\n"), pedido.toString());
	}
	
}