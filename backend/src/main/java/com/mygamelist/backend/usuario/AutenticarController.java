package com.mygamelist.backend.usuario;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> autenticarLogin(String login, String senhaUsuario) {
        Usuario usuario = usuarioService.autenticarUsuario(login, senhaUsuario);
        String token = usuarioService.gerarToken(usuario);
        Map<String, Object> response = new HashMap<>();
        response.put("usuario", usuario);
        response.put("token", token);
        return response;
    }

    @PostMapping("/Registrar")
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }
}
