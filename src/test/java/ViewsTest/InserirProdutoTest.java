/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Gerente.InserirProduto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class InserirProdutoTest {
    
    @Test
    public void testViewInserirProdutos(){
        InserirProduto telaInserirProduto = new InserirProduto("1");
                
        assertNotNull(telaInserirProduto);
    }
}
