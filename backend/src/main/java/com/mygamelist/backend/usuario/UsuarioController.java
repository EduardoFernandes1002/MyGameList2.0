package com.mygamelist.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Retorna um usuário pelo nome de login (nm_usuario)
    @GetMapping("/{usuario}")
    public ResponseEntity<Usuario> getUsuarioByNomeUsuario(@PathVariable String nmUsuario) {
        Optional<Usuario> usuario = usuarioService.getUsuarioByNomeUsuario(nmUsuario);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}