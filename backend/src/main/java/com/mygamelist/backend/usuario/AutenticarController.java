package com.mygamelist.backend.usuario;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autenticar")
public class AutenticarController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        String token = usuarioService.autenticar(usuario);
        if (token != null) {
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.registrarUsuario(
                usuario.getEmailUsuario(),
                usuario.getNomeUsuario(),
                usuario.getApelidoUsuario(),
                usuario.getSenhaUsuario());
        return ResponseEntity.ok(Map.of("message", "Usuário registrado com sucesso!"));
    }
}
