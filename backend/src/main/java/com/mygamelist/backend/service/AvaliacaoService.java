package com.mygamelist.backend.service;

import com.mygamelist.backend.model.Usuario;
import com.mygamelist.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Retorna todos os usuários
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
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