/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Pedido;
import Models.PedidoHasProduto;
import Models.Produto;
import Utils.JDBCUtil;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nelson Toneze e Yohan Pessanha
 */
public class PedidoDAO {
    private static final String caminho = System.getProperty("user.dir");
    private static final File configArquivo = new File(caminho + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection conexao = null;
    String sql;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public void criaPedido(Pedido pedido, ArrayList<Produto> listaDeProduto){
        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();

            sql = "insert into pedido(nomeCliente, telefoneCliente, usuarioid, valorTotal) values(?, ?, ?, ?)";
            preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pedido.getPedidoNomeCliente());
            preparedStatement.setString(2, pedido.getPedidoTelefoneCliente());
            preparedStatement.setInt(3, pedido.getUsuarioId());
            preparedStatement.setFloat(4, pedido.getPedidoTotal());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int generatedKey = 0;
            if (resultSet.next()) {
                generatedKey = resultSet.getInt(1);
            }   
            System.out.println("Inserido ID: " + generatedKey);
            preparedStatement.close();
            
            for(int n=0 ; n<listaDeProduto.size() ; n++){
                sql = "insert into pedido_has_produto(pedido_idPedido, produto_id) values(?,?)";
                preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setInt(1, generatedKey);
                preparedStatement.setInt(2, listaDeProduto.get(n).getProdudoId());
                preparedStatement.execute();
                preparedStatement.close();
            }
            
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha de conexao, no comando = " + erro);
        }
    }
}
