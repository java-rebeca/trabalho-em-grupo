package com.senai.infoa.grupo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.grupo.models.Usuario;
import com.senai.infoa.grupo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/count")
    public Long contador() {
        return usuarioService.contador();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
        boolean deletar = usuarioService.deletar(id);
        if (deletar) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover usuário";
    }

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/buscar/{id}") 
    public Usuario buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(usuario, id);
    }

}
