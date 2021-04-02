/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author henrique
 */
public class Usuario {
    private int usuarioid;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String tipo;
    
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
        String resposta = this.getUsuario_id() + "\n";
        resposta += this.getUsuario_nome()     + "\n";
        resposta += this.getUsuario_login()    + "\n";
        resposta += this.getUsuario_password() + "\n";
        resposta += this.getUsuario_email()     + "\n";
        resposta += this.getUsuario_tipo()     + "\n";
        return resposta;
    }

    public int getUsuario_id() {
        return usuarioid;
    }

    public String getUsuario_nome() {
        return nome;
    }

    public String getUsuario_login() {
        return login;
    }

    public String getUsuario_password() {
        return senha;
    }

    public String getUsuario_email() {
        return email;
    }

    public String getUsuario_tipo() {
        return tipo;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuarioid = usuario_id;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.nome = usuario_nome;
    }

    public void setUsuario_login(String usuario_login) {
        this.login = usuario_login;
    }

    public void setUsuario_password(String usuario_password) {
        this.senha = usuario_password;
    }

    public void setUsuario_email(String usuario_email) {
        this.email = usuario_email;
    }

    public void setUsuario_tipo(String usuario_tipo) {
        this.tipo = usuario_tipo;
    }
    
    
}
