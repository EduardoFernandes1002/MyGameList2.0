package com.mygamelist.backend.usuario;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow();
    }

    public List<Map<String, Usuario>> getPermissaoByNome(String nomePermissao) {
        return usuarioRepository.findUsuarioByPermissao(nomePermissao);
    }

    public List<Map<String, Usuario>> getAllUsuariosByPermissao() {
        return usuarioRepository.findAllUsuariosByPermissao();
    }

    public Usuario autenticarUsuario(String login, String senhaUsuario) {
        if (login.contains("@")) {
            return Optional.ofNullable(usuarioRepository.findByEmailUsuario(login))
                .filter(usuario -> usuario.getSenhaUsuario().equals(senhaUsuario))
                    .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));
        } else {
            return Optional.ofNullable(usuarioRepository.findByNomeUsuario(login))
                .filter(usuario -> usuario.getSenhaUsuario().equals(senhaUsuario))
                    .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));
        }
    }

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuario.getSenhaUsuario() == null) {
            throw new RuntimeException("Senha é obrigatória");
        }
        if (usuario.getApelidoUsuario() == null) {
            throw new RuntimeException("Apelido é obrigatório");
        }
        if (usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario()) != null) {
            throw new RuntimeException("Usuário já cadastrado");
        } else if (usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario()) != null) {
            throw new RuntimeException("Email já cadastrado");
        } else {
            return usuarioRepository.save(usuario);
        }
    }
}
