/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Produto;
import java.util.ArrayList;

/**
 *
 * @author Nelson Toneze
 */
public class ProdutoController {
    
    public ArrayList<Produto> listaProdutos() {
        Produto produto = new Produto();
        
        return produto.listaProdutos();
    }
    
    public boolean criaProduto(String nome, Float preco, String descricao){
        Produto produto2 = new Produto();
        
        if(!nome.equals("") && preco > 0 && !descricao.equals("")){
            produto2.setProdutoNome(nome);
            produto2.setProdutoPreco(preco);
            produto2.setProdutoDescricao(descricao);
            
            return produto2.criaProduto(produto2);
        }   
        
        return false;
    }
    
    public boolean atualizaProduto(String nome, Float preco, String descricao, int id) {
        Produto produto2 = new Produto();
        if(!nome.equals("") && preco > 0 && !descricao.equals("")){
            produto2.setProdutoNome(nome);
            produto2.setProdutoPreco(preco);
            produto2.setProdutoDescricao(descricao);
            produto2.setProdutoId(id);

            return produto2.atualizaProduto(produto2);
        }
        
        return false;
    }
    
    public boolean deletaProduto(int id, String nome, String descricao) {
        Produto produto2 = new Produto();
        
        if(!nome.equals("") && !descricao.equals("")){
            produto2.setProdutoId(id);
            produto2.setProdutoNome(nome);
            produto2.setProdutoDescricao(descricao);
            
            return produto2.deletaProduto(produto2);
        }
        
        return false;
    }
}
