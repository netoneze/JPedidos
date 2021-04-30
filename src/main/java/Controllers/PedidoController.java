/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Pedido;
import Models.Produto;
import java.util.ArrayList;

/**
 *
 * @author Nelson Toneze 
 */
public class PedidoController {
    
    public boolean criaPedido(String nomeCliente, String telefoneCliente, float total, int usuarioId, ArrayList<Produto> listaDeProduto){
        Pedido pedido2 = new Pedido();
        
        pedido2.setPedidoNomeCliente(nomeCliente);
        pedido2.setPedidoTelefoneCliente(telefoneCliente);
        pedido2.setPedidoTotal(total);
        pedido2.setUsuarioId(usuarioId);
        
        return pedido2.criaPedido(pedido2, listaDeProduto);
    }
    
    public ArrayList<Pedido> listaPedidos() {
        Pedido pedido = new Pedido();
        
        return pedido.listaPedidos();
    }
    
    public boolean alteraPedido(String status, int id, String nomeCliente){
        Pedido pedido2 = new Pedido();
        
        pedido2.setPedidoId(id);
        pedido2.setPedidoStatus(status);
        pedido2.setPedidoNomeCliente(nomeCliente);
        
        return pedido2.alterarPedido(pedido2);
    }
    
    public ArrayList<Produto> retornaArrayTipoPedido() {
        ArrayList<Produto> ProdutosLista = new ArrayList<Produto>();
        return ProdutosLista;
    }
}
