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
 * @author Nelson Toneze e Yohan Pessanha
 */
public class ProdutoController {
    
    public ArrayList<Produto> listaProdutos() {
        Produto produto = new Produto();
        
        return produto.listaProdutos();
    }
    
    public boolean criaProduto(Produto produto){
        Produto produto2 = new Produto();
        
        return produto2.criaProduto(produto);
    }
    
    public boolean atualizaProduto(Produto produto) {
        Produto produto2 = new Produto();
        
        return produto2.atualizaProduto(produto);
    }
    
    public boolean deletaProduto(Produto produto) {
        Produto produto2 = new Produto();
        
        return produto2.deletaProduto(produto);
    }
}
