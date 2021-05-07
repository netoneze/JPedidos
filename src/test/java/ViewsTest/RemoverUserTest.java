/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Admin.RemoverUser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class RemoverUserTest {
    
    @Test
    public void testViewInserirUser(){
        String[] args = null;
        RemoverUser telaRemoverUser = new RemoverUser();
        telaRemoverUser.main(args);
        telaRemoverUser.dispose();
        assertNotNull(telaRemoverUser);
    }
}
