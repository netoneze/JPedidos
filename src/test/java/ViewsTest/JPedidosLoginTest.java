/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.JPedidosLogin;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author COGETI_ESTÁGIO
 */
public class JPedidosLoginTest {
    
    @Test
    public void testViewLogin(){
        JPedidosLogin telaLogin = new JPedidosLogin();
        assertNotNull(telaLogin);
    }
    
}
