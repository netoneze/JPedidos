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
import java.util.ArrayList;

/**
 *
 * @author Nelson Toneze 
 */
public class Usuario {
    private int usuarioid;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String tipo;
    
    private static final String caminho = System.getProperty("user.dir");
    private static final File configArquivo = new File(caminho + "/src/main/java/Utils/configuracaobd.properties");
    private static Connection conexao = null;
    ArrayList<Usuario> list = new ArrayList<>();
    
    public Usuario(){
    }
    
    public Usuario(int id, String nome, String login, String password, String email, String tipo) {
        this.usuarioid = id;
        this.nome = nome;
        this.login = login;
        this.senha = password;
        this.email = email;
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        String resposta = this.getUsuarioId() + "\n";
        resposta += this.getUsuarioNome()     + "\n";
        resposta += this.getUsuarioLogin()    + "\n";
        resposta += this.getUsuarioPassword() + "\n";
        resposta += this.getUsuarioEmail()     + "\n";
        resposta += this.getUsuarioTipo()     + "\n";
        return resposta;
    }

    public int getUsuarioId() {
        return usuarioid;
    }

    public String getUsuarioNome() {
        return nome;
    }

    public String getUsuarioLogin() {
        return login;
    }

    public String getUsuarioPassword() {
        return senha;
    }

    public String getUsuarioEmail() {
        return email;
    }

    public String getUsuarioTipo() {
        return tipo;
    }

    public void setUsuarioId(int usuario_id) {
        this.usuarioid = usuario_id;
    }

    public void setUsuarioNome(String usuario_nome) {
        this.nome = usuario_nome;
    }

    public void setUsuarioLogin(String usuario_login) {
        this.login = usuario_login;
    }

    public void setUsuarioPassword(String usuario_password) {
        this.senha = usuario_password;
    }

    public void setUsuarioEmail(String usuario_email) {
        this.email = usuario_email;
    }

    public void setUsuarioTipo(String usuario_tipo) {
        this.tipo = usuario_tipo;
    }
    
    public Usuario userAutentica(Usuario usuario) {
        Usuario usuario2 = new Usuario();

        try {
            JDBCUtil.init(configArquivo);
            conexao = JDBCUtil.getConnection();

            String sql = "select * from usuario where login = ? and senha = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getUsuarioLogin());
            preparedStatement.setString(2, usuario.getUsuarioPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            String usuarioLogin = "";
            String usuarioTipo = "";
            String usuarioId = "";

            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        usuarioLogin = resultSet.getString("login");
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
    
    public boolean criaUsuario(Usuario user) {
        if(user.getUsuarioNome() != null && user.getUsuarioEmail() != null){
            try {
                JDBCUtil.init(configArquivo);
                conexao = JDBCUtil.getConnection();
                String sql = "insert into usuario (nome, login, senha, email, tipo) values(?,?,?,?,?)";
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
        } else {
            return false;
        }
        return true;
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
    
    public boolean alterarUsuario(Usuario user) {
        if(user.getUsuarioNome() != null && user.getUsuarioEmail() != null){
            try {
                JDBCUtil.init(configArquivo);
                conexao = JDBCUtil.getConnection();
                String sql = "select senha from usuario where usuarioid = ?";
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

            try {
                JDBCUtil.init(configArquivo);
                conexao = JDBCUtil.getConnection();
                String sql = "update usuario set nome = ?, login = ?, senha = ?, email = ?, tipo = ? where usuarioid = ?";
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
        } else { 
            return false;
        }
        return true;
    }
    
    public boolean deletarUsuario(Usuario user) {
        if(user.getUsuarioNome() != null && user.getUsuarioEmail()!= null){
            try {
                JDBCUtil.init(configArquivo);
                conexao = JDBCUtil.getConnection();
                String sql = "delete from usuario where usuarioid = ?";
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
        } else {
            return false;
        }
        return true;
    }
    
}
