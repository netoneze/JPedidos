package UtilsTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Utils.JDBCUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilTest {
	
	@Test
	public void testFile() throws ClassNotFoundException, IOException, SQLException {
		String caminho = System.getProperty("user.dir");
		File config_file = new File(caminho + "/src/main/java/Utils/configuracaobd.properties");
		Connection conexao = null;
                JDBCUtil.init(config_file);
                conexao = JDBCUtil.getConnection();
                
		assertNotNull(conexao);
	}

}
