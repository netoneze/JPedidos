/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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
 * @author Nelson Toneze 
 */
public class Pedido {
    private static final String caminho = System.getProperty("user.dir");
    private static final File configArquivo = new File(caminho + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection conexao = null;
    String sql;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ArrayList<Pedido> lista = new ArrayList<>();
    
    
    /**
     * @param valorTotal valor total do pedido set
     */
    public void setPedidoTotal(float valorTotal) {
        this.setValorTotal(valorTotal);
    }
    private int idPedido;
    private String nomeCliente;
    private String telefoneCliente;
    private int usuarioid;
    private float valorTotal;
    private String pedidoStatus;
    private String criadoEm;
    private String fechadoEm;
    
    public Pedido(){
    }
    
    public Pedido(int id, String nomeCliente, String telefoneCliente, int usuarioid, String pedidoStatus, String criadoEm, String fechadoEm){
        this.idPedido = id;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.usuarioid = usuarioid;
        this.pedidoStatus = pedidoStatus;
        this.criadoEm = criadoEm;
        this.fechadoEm = fechadoEm;
    }
    
    public String toString() {
        String resposta = this.getPedidoId() + "\n";
        resposta += this.getPedidoNomeCliente() + "\n";
        resposta += this.getPedidoTelefoneCliente() + "\n";
        resposta += this.getUsuarioId() + "\n";
        resposta += this.getPedidoStatus() + "\n";
        resposta += this.getCriadoEm() + "\n";
        resposta += this.getFechadoEm() + "\n";
        return resposta;
    }

    public int getPedidoId() {
        return idPedido;
    }

    public String getPedidoNomeCliente() {
        return nomeCliente;
    }

    public String getPedidoTelefoneCliente() {
        return telefoneCliente;
    }

    public int getUsuarioId() {
        return usuarioid;
    }
    
    public void setPedidoId(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setPedidoNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setPedidoTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public void setUsuarioId(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(String pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(String fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
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
                pedido.setUsuarioId(rs.getInt("usuarioId"));
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
    
    public boolean alterarPedido(Pedido pedido){
        if(pedido.getPedidoNomeCliente()!= null && pedido.getPedidoStatus()!= null){     
            try {
                JDBCUtil.init(configArquivo);
                conexao = JDBCUtil.getConnection();
                String sql = "update pedido set pedidoStatus = ?, fechadoEm = ? WHERE idPedido = ?";
                PreparedStatement pstm = conexao.prepareStatement(sql);
                
                java.sql.Timestamp hoje;
                hoje = new java.sql.Timestamp(new java.util.Date().getTime()); 
                
                pstm.setString(1, pedido.getPedidoStatus());
                pstm.setTimestamp(2, hoje);
                pstm.setInt(3, pedido.getPedidoId());

                pstm.execute();
                pstm.close();

            } catch (ClassNotFoundException erro) {
                System.out.println("Falha ao carregar o driver JDBC." + erro);
            } catch (IOException erro) {
                System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            } catch (SQLException erro) {
                System.out.println("Falha na conexao, comando sql = " + erro);
            }
        } else { 
            return false;
        }
        return true;
    }
    
}
