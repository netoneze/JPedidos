package UtilsTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Utils.JDBCUtil;

public class TesteJDBC {
	@Test
	public void test() {
		String path = System.getProperty("user.dir");
		File config_file = new File(path + "/configuracaobd.properties");

		assertThrows(ClassNotFoundException.class, () -> {
			JDBCUtil.init(config_file);
		});

		assertThrows(IOException.class, () -> {
			JDBCUtil.init(config_file);
		});
	}

}