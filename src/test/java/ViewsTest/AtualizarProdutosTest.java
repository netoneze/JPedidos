/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Gerente.AtualizarProdutos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class AtualizarProdutosTest {
    @Test
    public void testViewAtualizarProdutos(){
        String[] args = null;
        AtualizarProdutos telaAtualizarProdutos = new AtualizarProdutos("1");
        telaAtualizarProdutos.main(args);
        telaAtualizarProdutos.dispose();
        assertNotNull(telaAtualizarProdutos);
    }
}