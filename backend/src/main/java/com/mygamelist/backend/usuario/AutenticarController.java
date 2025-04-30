package com.mygamelist.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/autenticar")
public class AutenticarController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Usuario autenticarLogin(String login, String senhaUsuario) {
        return usuarioService.autenticarUsuario(login, senhaUsuario);
    }

    @PostMapping("/Registrar")
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }
}
