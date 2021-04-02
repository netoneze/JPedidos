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
public class UsuarioController {

    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection connection = null;

    ArrayList<Usuario> list = new ArrayList<>();

    public Usuario userAutentica(Usuario usuario) {
        Usuario usuario2 = new Usuario();

        try {
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            String sql = "select * from usuario where login = ? and senha = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, usuario.getUsuarioLogin());
            pstm.setString(2, usuario.getUsuarioPassword());

            ResultSet rs = pstm.executeQuery();

            String usuarioLogin = "";
            String usuarioPassword = "";
            String usuarioTipo = "";
            String usuarioId = "";

            if (rs != null) {
                try {
                    while (rs.next()) {
                        usuarioLogin = rs.getString("login");
                        usuarioPassword = rs.getString("senha");
                        usuarioTipo = rs.getString("tipo");
                        usuarioId = rs.getString("usuarioid");
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
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
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
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setUsuarioId(rs.getInt("usuarioid"));
                user.setUsuarioLogin(rs.getString("login"));
                user.setUsuarioEmail(rs.getString("email"));
                user.setUsuarioNome(rs.getString("nome"));
                user.setUsuarioPassword(rs.getString("senha"));
                user.setUsuarioTipo(rs.getString("tipo"));

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
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
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
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
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
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);
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
