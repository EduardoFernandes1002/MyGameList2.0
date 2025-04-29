package com.mygamelist.backend.usuario;

import java.util.List;
import java.util.Map;

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
}
