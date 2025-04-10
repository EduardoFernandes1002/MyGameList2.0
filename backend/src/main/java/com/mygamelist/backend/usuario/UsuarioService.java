package com.mygamelist.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Retorna um usuário pelo nome de login (nm_usuario)
    public Optional<Usuario> getUsuarioByNomeUsuario(String nomeUsuario) {
        return usuarioRepository.findByNomeUsuario(nomeUsuario);
    }

    // Salva ou atualiza um usuário
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Deleta um usuário por ID
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}