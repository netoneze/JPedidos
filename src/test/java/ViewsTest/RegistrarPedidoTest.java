/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Funcionario.RegistrarPedido;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class RegistrarPedidoTest {
    
    @Test
    public void testViewRegistrarPedido(){
        String[] args = null;
        RegistrarPedido telaRegistrarPedido = new RegistrarPedido("1");
        telaRegistrarPedido.main(args);
        telaRegistrarPedido.dispose();
        assertNotNull(telaRegistrarPedido);
    }
}
