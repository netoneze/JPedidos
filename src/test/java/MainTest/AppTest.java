package MainTest;

import Main.App;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class AppTest {
    
	@Test
	public void test() {
            String[] args = null;
            App telaMain = new App();
            telaMain.main(args);
            assertNotNull(telaMain);
	}
}
