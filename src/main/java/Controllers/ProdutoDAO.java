/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Utils.JDBCUtil;
import Models.Produto;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nelson Toneze e Yohan Pessanha
 */
public class ProdutoDAO {
    private static final String caminho = System.getProperty("user.dir");
    private static final File configArquivo = new File(caminho + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection conexao = null;
    String sql;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    ArrayList<Produto> lista = new ArrayList<>();
    
    public ArrayList<Produto> listaProdutos() {
        sql = "select * from produto";
        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            conexao.setAutoCommit(false);

            preparedStatement = conexao.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setProdutoId(resultSet.getInt("produtoId"));
                produto.setProdutoNome(resultSet.getString("nome"));
                produto.setProdutoDescricao(resultSet.getString("descricao"));
                produto.setProdutoPreco(resultSet.getFloat("precoUnid"));

                lista.add(produto);
            }

            return lista;

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
            return null;
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha de conexao, no comando = " + erro);
            return null;
        }
    }
}
