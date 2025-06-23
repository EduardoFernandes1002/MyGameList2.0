package com.mygamelist.backend.usuario;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygamelist.backend.permissao.Permissao;
import com.mygamelist.backend.security.JwtUtil;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

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

    // Registra o usuario adicionando todas suas informações obrigatorias ao banco de dados
    public Usuario registrarUsuario(String emailUsuario, String nomeUsuario, String apelidoUsuario,String senhaUsuario) {

        Usuario usuario = new Usuario();
        Permissao permissao = new Permissao();
        
        permissao.setIdPermissao(1L);
        usuario.setPermissao(permissao);
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setApelidoUsuario(apelidoUsuario);
        usuario.setEmailUsuario(emailUsuario);
        usuario.setSenhaUsuario(senhaUsuario);
        return usuarioRepository.save(usuario);
    }

    // Método para autenticar o usuário
    // Verifica se o usuário existe e se a senha está correta
    public String autenticar(Usuario usuario) {
        Usuario user;
        if (usuario.getEmailUsuario() != null) {
            user = usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario());
        } else {
            user = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());
        }
        if (user != null && user.getSenhaUsuario().equals(usuario.getSenhaUsuario())) {
            return jwtUtil.generateToken(user.getNomeUsuario());
        }
        return null;
    }

    public Usuario getUsuarioByNomeUsuario(String nomeUsuario) {
        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado: " + nomeUsuario);
        }
        return usuario;
    }
}
