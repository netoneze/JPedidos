/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Gerente.JPedidosGer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class JPedidosGerTest {
    
    @Test
    public void testViewJPedidosGerente(){
        String[] args = null;
        JPedidosGer telaJPedidosGerente = new JPedidosGer("1");
        telaJPedidosGerente.main(args);
        telaJPedidosGerente.dispose();
        assertNotNull(telaJPedidosGerente);
    }
}
