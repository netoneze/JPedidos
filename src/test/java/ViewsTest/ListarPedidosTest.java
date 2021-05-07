/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Funcionario.ListarPedidos;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class ListarPedidosTest {
    
    @Test
    public void testViewListarPedidosComoFuncionario() throws ParseException{
        ListarPedidos telaListarPedidos = new ListarPedidos("1", "funcionario");
        
        assertNotNull(telaListarPedidos);
    }
    
    @Test
    public void testViewListarPedidos() throws ParseException{
        ListarPedidos telaListarPedidos = new ListarPedidos("1", "");
        
        assertNotNull(telaListarPedidos);
    }
}
