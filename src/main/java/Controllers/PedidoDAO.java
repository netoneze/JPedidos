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
    ArrayList<Pedido> lista = new ArrayList<>();
    
    public boolean criaPedido(Pedido pedido, ArrayList<Produto> listaDeProduto){
        if(pedido.getPedidoNomeCliente()!= null && pedido.getPedidoTelefoneCliente()!= null){
            try {
                JDBCUtil.init(configArquivo);
                conexao = JDBCUtil.getConnection();

                java.sql.Timestamp hoje;
                hoje = new java.sql.Timestamp(new java.util.Date().getTime());

                sql = "insert into pedido(nomeCliente, telefoneCliente, usuarioid, valorTotal, pedidoStatus, criadoEm) values(?, ?, ?, ?, ?, ?)";
                preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, pedido.getPedidoNomeCliente());
                preparedStatement.setString(2, pedido.getPedidoTelefoneCliente());
                preparedStatement.setInt(3, pedido.getUsuarioId());
                preparedStatement.setFloat(4, pedido.getValorTotal());
                preparedStatement.setString(5, "aberto");
                preparedStatement.setTimestamp(6, hoje);
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
        } else {
            return false;
        }
        return true;
    }
    
    public ArrayList<Pedido> listaPedidos() {
        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            String sql = "select * from pedido";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setPedidoId(rs.getInt("idPedido"));
                pedido.setPedidoStatus(rs.getString("pedidoStatus"));
                pedido.setPedidoNomeCliente(rs.getString("nomeCliente"));
                pedido.setPedidoTelefoneCliente(rs.getString("telefoneCliente"));
                pedido.setPedidoId(rs.getInt("usuarioId"));
                pedido.setPedidoTotal(rs.getFloat("valorTotal"));

                lista.add(pedido);
            }

            return lista;

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
            return null;
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha no comando sql = " + erro);
            return null;
        }
    }
}
