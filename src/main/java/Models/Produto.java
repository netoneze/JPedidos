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
public class Produto {
    private int produtoId;
    private String nome;
    private String descricao;
    private float precoUnid;
    
    public Produto(){
    }
    
    public Produto(int id, String nome, String descricao, float precoUnid){
        this.produtoId = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnid = precoUnid;
    }
    
    @Override
    public String toString() {
        String resposta = this.getProdudoId()      + "\n";
        resposta += this.getProdutoNome()          + "\n";
        resposta += this.getProdutoDescricao()   + "\n";
        resposta += this.getProdutoPreco()         + "\n";
        return resposta;
    }

    public int getProdudoId() {
        return produtoId;
    }

    public String getProdutoNome() {
        return nome;
    }

    public String getProdutoDescricao() {
        return descricao;
    }

    public float getProdutoPreco() {
        return precoUnid;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public void setProdutoNome(String nome) {
        this.nome = nome;
    }

    public void setProdutoDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setProdutoPreco(float produtoPreco) {
        this.precoUnid = produtoPreco;
    }
    
    
}
