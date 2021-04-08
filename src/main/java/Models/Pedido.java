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
     * @param valorTotal valor total do pedido set
     */
    public void setPedidoTotal(float valorTotal) {
        this.setValorTotal(valorTotal);
    }
    private int idPedido;
    private String nomeCliente;
    private String telefoneCliente;
    private int usuarioid;
    private float valorTotal;
    private String pedidoStatus;
    private String criadoEm;
    private String fechadoEm;
    
    public Pedido(){
    }
    
    public Pedido(int id, String nomeCliente, String telefoneCliente, int usuarioid, String pedidoStatus, String criadoEm, String fechadoEm){
        this.idPedido = id;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.usuarioid = usuarioid;
        this.pedidoStatus = pedidoStatus;
        this.criadoEm = criadoEm;
        this.fechadoEm = fechadoEm;
    }
    
    public String toString() {
        String resposta = this.getPedidoId() + "\n";
        resposta += this.getPedidoNomeCliente() + "\n";
        resposta += this.getPedidoTelefoneCliente() + "\n";
        resposta += this.getUsuarioId() + "\n";
        resposta += this.getPedidoStatus() + "\n";
        resposta += this.getCriadoEm() + "\n";
        resposta += this.getFechadoEm() + "\n";
        return resposta;
    }

    public int getPedidoId() {
        return idPedido;
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

    public void setPedidoNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setPedidoTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public void setUsuarioId(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(String pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(String fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
