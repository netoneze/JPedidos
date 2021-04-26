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
 * @author Nelson Toneze e Yohan Pessanha
 */
public class PedidoController {
    
    public boolean criaPedido(Pedido pedido, ArrayList<Produto> listaDeProduto){
        Pedido pedido2 = new Pedido();
        
        return pedido2.criaPedido(pedido, listaDeProduto);
    }
    
    public ArrayList<Pedido> listaPedidos() {
        Pedido pedido = new Pedido();
        
        return pedido.listaPedidos();
    }
    
}
