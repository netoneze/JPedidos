/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Gerente.RemoverProdutos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class RemoverProdutosTest {
    
    @Test
    public void testViewRemoverProdutos(){
        String[] args = null;
        RemoverProdutos telaRemoverProdutos = new RemoverProdutos("1");
        telaRemoverProdutos.main(args);
        telaRemoverProdutos.dispose();
        assertNotNull(telaRemoverProdutos);
    }
}
