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
        
        @Test
        public void criarPedido() throws ParseException{
                Produto produto = new Produto();
                Pedido pedido = new Pedido();
                ArrayList<Produto> listaProdutos = produto.listaProdutos();
		ArrayList<Produto> lista = new ArrayList<Produto>();

                listaProdutos.get(1).setProdutoQuantidade(1);
                listaProdutos.get(2).setProdutoQuantidade(1);
                listaProdutos.get(3).setProdutoQuantidade(1);
                lista.add(listaProdutos.get(1));
                lista.add(listaProdutos.get(2));
                lista.add(listaProdutos.get(3));
                
		pedido.setPedidoNomeCliente("Claudio");
		pedido.setPedidoTelefoneCliente("(11)22222-3333");
		pedido.setPedidoId(1);
		pedido.setPedidoTotal(35.50f);
                pedido.setUsuarioId(1);
                
		assertTrue(pedido.criaPedido(pedido, lista));
        }
        
        @Test
        public void FechaPedido() throws ParseException{
                Pedido pedido = new Pedido();
                                     
		pedido.setPedidoNomeCliente("Claudio");
		pedido.setPedidoTelefoneCliente("(11)22222-3333");
		pedido.setPedidoId(1);
                pedido.setPedidoStatus("fechado");
                
		assertTrue(pedido.alterarPedido(pedido));
        }
        
}