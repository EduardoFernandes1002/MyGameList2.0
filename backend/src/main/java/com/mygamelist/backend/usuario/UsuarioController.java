package com.mygamelist.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/permissao/{nomePermissao}")
    public List<Map<String, Usuario>> getPermissaoByNome(@PathVariable String nomePermissao) {
        return usuarioService.getPermissaoByNome(nomePermissao);
    }

    @GetMapping("/permissao")
    public List<Map<String, Usuario>> getAllUsuariosByPermissao() {
        return usuarioService.getAllUsuariosByPermissao();
    }

}