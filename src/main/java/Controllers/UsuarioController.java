/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Nelson Toneze e Yohan Pessanha
 */
public class UsuarioController {

    public Usuario userAutentica(Usuario usuario) {
        Usuario usuario2 = new Usuario();
        
        return usuario2.userAutentica(usuario);
    }

    public boolean criaUsuario(Usuario user) {
        Usuario usuario = new Usuario();
        
        return usuario.criaUsuario(user);
    }

    public ArrayList<Usuario> listaUsuario() {
        Usuario usuario = new Usuario();
        
        return usuario.listaUsuario();
    }

    public boolean alterarUsuario(Usuario user) {
        Usuario usuario = new Usuario();
        
        return usuario.alterarUsuario(user);
    }

    public boolean deletarUsuario(Usuario user) {
        Usuario usuario = new Usuario();
        
        return usuario.deletarUsuario(user);
    }

    public boolean verificaSeEmailExiste(String email) {
        ArrayList<Models.Usuario> listaUsuario = this.listaUsuario();
        
        if(listaUsuario == null) {
        	return false;
        }

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
        ArrayList<Models.Usuario> listaUsuario = this.listaUsuario();
        
        if(listaUsuario == null) {
        	return false;
        }

        if (listaUsuario.size() <= 0) {
            return false;
        }
        
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuarioLogin().equals(login)) {
                return true;
            }
        }

        listaUsuario.clear();
        return false;
    }
}
