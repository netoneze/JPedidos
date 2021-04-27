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
 * @author Nelson Toneze 
 */
public class UsuarioController {

    public Usuario userAutentica(Usuario usuario) {
        Usuario usuario2 = new Usuario();
        
        return usuario2.userAutentica(usuario);
    }

    public boolean criaUsuario(String name, String email, String username, String senha, String tipo) {
        Usuario usuario = new Usuario();
        
        usuario.setUsuarioNome(name);
        usuario.setUsuarioLogin(username);
        usuario.setUsuarioEmail(email);
        usuario.setUsuarioPassword(senha);
        usuario.setUsuarioTipo(tipo);
        
        return usuario.criaUsuario(usuario);
    }

    public ArrayList<Usuario> listaUsuario() {
        Usuario usuario = new Usuario();
        
        return usuario.listaUsuario();
    }

    public boolean alterarUsuario(int id, String name, String email, String username, String role, String senha) {
        Usuario usuario = new Usuario();
        
        usuario.setUsuarioId(id);
        usuario.setUsuarioNome(name);
        usuario.setUsuarioLogin(username);
        usuario.setUsuarioEmail(email);
        usuario.setUsuarioTipo(role);
        usuario.setUsuarioPassword(senha);
        
        return usuario.alterarUsuario(usuario);
    }

    public boolean deletarUsuario(int id, String name, String email) {
        Usuario usuario = new Usuario();
        
        usuario.setUsuarioId(id);
        usuario.setUsuarioNome(name);
        usuario.setUsuarioEmail(email);
        
        return usuario.deletarUsuario(usuario);
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
