/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsTest;

import Views.Admin.AtualizarUser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author COGETI_ESTÁGIO
 */
public class AtualizarUserTest {
    
    @Test
    public void testViewAtualizarUser(){
        String[] args = null;
        AtualizarUser telaAtualizarUser = new AtualizarUser();
        telaAtualizarUser.main(args);
        telaAtualizarUser.dispose();
        assertNotNull(telaAtualizarUser);
    }
    
}
