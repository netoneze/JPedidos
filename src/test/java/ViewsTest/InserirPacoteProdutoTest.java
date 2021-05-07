/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Gerente.InserirPacoteProduto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class InserirPacoteProdutoTest {
    
    @Test
    public void testViewInserirPacoteProduto(){
        String[] args = null;
        InserirPacoteProduto telaInserirPacoteProduto = new InserirPacoteProduto("1");
        telaInserirPacoteProduto.main(args);
        telaInserirPacoteProduto.dispose();
        assertNotNull(telaInserirPacoteProduto);
    }
    
}
