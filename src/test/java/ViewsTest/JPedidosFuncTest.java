/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Funcionario.JPedidosFunc;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class JPedidosFuncTest {
    
    @Test
    public void testViewFuncionario(){
        String[] args = null;
        JPedidosFunc telaJPedidosFuncionario = new JPedidosFunc("1");
        telaJPedidosFuncionario.main(args);
        telaJPedidosFuncionario.dispose();
        assertNotNull(telaJPedidosFuncionario);
    }
}
