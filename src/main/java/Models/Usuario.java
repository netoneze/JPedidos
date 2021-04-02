/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Nelson Toneze e Yohan Pessanha
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
    
    
}
