package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestePedido {
	
	@Test
	public void testSetGet() {
		Pedido ped = new Pedido();
		ped.setPedidoId(1);
		ped.setUsuarioId(1);
		ped.setCriadoEm("16:28");
		ped.setFechadoEm("17:30");
		ped.setPedidoNomeCliente("Claudio Duarte");
		ped.setPedidoStatus("Aberto");
		ped.setPedidoTelefoneCliente("11222223333");
		String res = String.valueOf(ped.getPedidoId()) + "\n" + ped.getPedidoNomeCliente() + "\n" + ped.getPedidoTelefoneCliente() + "\n" + ped.getUsuarioId() + "\n" +
		ped.getPedidoStatus() + "\n" + ped.getCriadoEm() + "\n" + ped.getFechadoEm() + "\n";
		
		assertEquals(res, ped.toString());
	}

	
	@Test
	public void testCon() {
		Pedido ped = new Pedido(1, "Claudio Duarte", "11222223333", 1, "Aberto", "16:28", "17:30");
		
		assertEquals((1 + "\n" + "Claudio Duarte" + "\n" + "11222223333" + "\n" + 1 + "\n" + "Aberto" + "\n" + "16:28" + "\n" + "17:30" + "\n"), ped.toString());
	}
	
}