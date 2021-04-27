/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Nelson Toneze 
 */
public class PedidoHasProduto {
    private int pedido_idPedido;
    private int produto_id;
    
    public PedidoHasProduto(){
    }
    
    public PedidoHasProduto(int idPedido, int produtoId){
        this.pedido_idPedido = idPedido;
        this.produto_id = produtoId;
    }
    
    @Override
    public String toString() {
        String resposta = this.getPedidoId() + "\n";
        resposta += this.getProdutoId() + "\n";
        return resposta;
    }

    public int getPedidoId() {
        return pedido_idPedido;
    }

    public int getProdutoId() {
        return produto_id;
    }

    public void setPedidoId(int pedidoId) {
        this.pedido_idPedido = pedidoId;
    }

    public void setProdutoId(int produtoId) {
        this.produto_id = produtoId;
    }
    
}
