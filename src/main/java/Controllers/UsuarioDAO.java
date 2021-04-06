/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Usuario;
import Utils.JDBCUtil;
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
public class UsuarioDAO {

    private static final String caminho = System.getProperty("user.dir");
    private static final File configArquivo = new File(caminho + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection conexao = null;

    ArrayList<Usuario> list = new ArrayList<>();

    public Usuario userAutentica(Usuario usuario) {
        Usuario usuario2 = new Usuario();

        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            conexao.setAutoCommit(false);

            String sql = "select * from usuario where login = ? and senha = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getUsuarioLogin());
            preparedStatement.setString(2, usuario.getUsuarioPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            String usuarioLogin = "";
            String usuarioPassword = "";
            String usuarioTipo = "";
            String usuarioId = "";

            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        usuarioLogin = resultSet.getString("login");
                        usuarioPassword = resultSet.getString("senha");
                        usuarioTipo = resultSet.getString("tipo");
                        usuarioId = resultSet.getString("usuarioid");
                    }
                    
                    if (!usuarioId.equals("")) {
                        usuario2.setUsuarioId(Integer.parseInt(usuarioId));
                        usuario2.setUsuarioLogin(usuarioLogin);
                        usuario2.setUsuarioTipo(usuarioTipo);
                    } else return null;
                } catch (SQLException ex) {
                    System.out.println("Something went wrong trying to log in:" + ex);
                }
            }

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
            return null;
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return null;
        }

        return usuario2;
    }

    public void criaUsuario(Usuario user) {
        String sql = "insert into usuario (nome, login, senha, email, tipo) values(?,?,?,?,?)";

        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, user.getUsuarioNome());
            pstm.setString(2, user.getUsuarioLogin());
            pstm.setString(3, user.getUsuarioPassword());
            pstm.setString(4, user.getUsuarioEmail());
            pstm.setString(5, user.getUsuarioTipo());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
    }

    public ArrayList<Usuario> listaUsuario() {
        String sql = "select * from usuario";
        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            conexao.setAutoCommit(false);

            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setUsuarioId(resultSet.getInt("usuarioid"));
                user.setUsuarioLogin(resultSet.getString("login"));
                user.setUsuarioEmail(resultSet.getString("email"));
                user.setUsuarioNome(resultSet.getString("nome"));
                user.setUsuarioPassword(resultSet.getString("senha"));
                user.setUsuarioTipo(resultSet.getString("tipo"));

                list.add(user);
            }

            return list;

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
            return null;
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            return null;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return null;
        }
    }

    public void alterarUsuario(Usuario user) {

        String sql = "select senha from usuario where usuarioid = ?";

        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            conexao.setAutoCommit(false);

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, user.getUsuarioId());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }


        sql = "update usuario set nome = ?, login = ?, senha = ?, email = ?, tipo = ? where usuarioid = ?";
        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            conexao.setAutoCommit(false);

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, user.getUsuarioNome());
            pstm.setString(2, user.getUsuarioLogin());
            pstm.setString(3, user.getUsuarioPassword());
            pstm.setString(4, user.getUsuarioEmail());
            pstm.setString(5, user.getUsuarioTipo());
            pstm.setInt(6, user.getUsuarioId());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
    }

    public void deletarUsuario(Usuario user) {
        String sql = "delete from usuario where usuarioid = ?";
        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();
            conexao.setAutoCommit(false);

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, user.getUsuarioId());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha de conexao, no comando = " + erro);
        }
    }

    public boolean verificaSeEmailExiste(String email) {
        ArrayList<Models.Usuario> listaUsuario = this.listaUsuario();

        if (listaUsuario.size() <= 0) {
            return false;
        }
        
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuarioEmail().equals(email)) {
                return true;
            }
        }

        listaUsuario.clear();
        return false;
    }
    
    public boolean verificaSeLoginExiste(String login) {
        ArrayList<Models.Usuario> usersList = this.listaUsuario();

        if (usersList.size() <= 0) {
            return false;
        }
        
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUsuarioLogin().equals(login)) {
                return true;
            }
        }

        usersList.clear();
        return false;
    }
}
