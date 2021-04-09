package UtilsTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Utils.JDBCUtil;

public class TesteJDBC {
	
	@Test
	public void testFile() throws ClassNotFoundException, IOException {
		String path = System.getProperty("a.dir");
		File config_file = new File(path + "/src/Utils/configuracaobd.properties");
		
		assertThrows(IOException.class, () -> {
			JDBCUtil.init(config_file);
			});
	}

}
