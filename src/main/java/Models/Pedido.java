/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Nelson Toneze e Yohan Pessanha
 */
public class Pedido {

    /**
     * @return the order_total
     */
    public float getPedidoTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal valor total do pedido set
     */
    public void setPedidoTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    private int idPedido;
    private int pedidoQuantidade;
    private String nomeCliente;
    private String telefoneCliente;
    private int usuarioid;
    private float valorTotal;
    
    public Pedido(){
    }
    
    public Pedido(int id, int quantidade, String nomeCliente, String telefoneCliente, int usuarioid){
        this.idPedido = id;
        this.pedidoQuantidade = quantidade;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.usuarioid = usuarioid;
    }
    
    public String toString() {
        String resposta = this.getPedidoId()        + "\n";
        resposta += this.getPedidoQuantidade()          + "\n";
        resposta += this.getPedidoNomeCliente()   + "\n";
        resposta += this.getPedidoTelefoneCliente()  + "\n";
        resposta += this.getUsuarioId()               + "\n";
        return resposta;
    }

    public int getPedidoId() {
        return idPedido;
    }

    public int getPedidoQuantidade() {
        return pedidoQuantidade;
    }

    public String getPedidoNomeCliente() {
        return nomeCliente;
    }

    public String getPedidoTelefoneCliente() {
        return telefoneCliente;
    }

    public int getUsuarioId() {
        return usuarioid;
    }

    public void setPedidoId(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setPedidoQuantidade(int pedidoQuantidade) {
        this.pedidoQuantidade = pedidoQuantidade;
    }

    public void setPedidoNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setPedidoTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public void setUsuarioId(int usuarioid) {
        this.usuarioid = usuarioid;
    }
    
    
}
