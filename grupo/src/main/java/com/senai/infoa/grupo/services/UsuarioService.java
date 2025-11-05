package com.senai.infoa.grupo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.grupo.models.Usuario;
import com.senai.infoa.grupo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    public String login(String email, String senha){
        Usuario usuario = usuarioRepository.findByEmail(email);
            if(usuario != null && senha.equals(usuario.getSenha())){
            return "Login efetuado com sucesso!";
            }
            return "Falha ao realizar login";
    }
    
    public Usuario salvar(Usuario usuario, String confSenha) {
        if(usuario.getSenha().equals(confSenha)){
        return usuarioRepository.save(usuario);
        }
        return null;
    }

}

