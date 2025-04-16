package com.mygamelist.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long idUsuario) {
        return usuarioService.getUsuarioById(idUsuario);
    }

    @GetMapping("/administradores")
    public List<Usuario> getAdministrators() {
        return usuarioService.getAdministrators();
    }
    

}