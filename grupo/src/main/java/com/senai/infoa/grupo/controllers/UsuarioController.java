package com.senai.infoa.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.grupo.models.Usuario;
import com.senai.infoa.grupo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.login(email,senha);
    }

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario, @RequestParam String confSenha) {
        return usuarioService.salvar(usuario, confSenha);
    }

}
