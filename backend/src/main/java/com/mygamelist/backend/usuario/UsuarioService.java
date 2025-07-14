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

    // Retorna todos os usuários cadastrados no banco de dados.
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Busca e retorna um usuário pelo ID. Lança exceção se não for encontrado.
    public Usuario getUsuarioById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow();
    }

    // Retorna usuários que possuem a permissão especificada pelo nome.
    public List<Map<String, Usuario>> getPermissaoByNome(String nomePermissao) {
        return usuarioRepository.findUsuarioByPermissao(nomePermissao);
    }

    // Retorna todos os usuários junto com o nome da permissão associada a cada um.
    public List<Map<String, Usuario>> getAllUsuariosByPermissao() {
        return usuarioRepository.findAllUsuariosByPermissao();
    }

    // Cria um novo objeto Usuario, atribui a permissão com ID 1 e define os dados recebidos como parâmetros.
    // Em seguida, salva o novo usuário no banco.
    public Usuario registrarUsuario(String emailUsuario, String nomeUsuario, String apelidoUsuario,String senhaUsuario) {

        Usuario usuario = new Usuario();
        Permissao permissao = new Permissao();
        
        permissao.setIdPermissao(1L);
        usuario.setPermissao(permissao);
        usuario.getIdUsuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setApelidoUsuario(apelidoUsuario);
        usuario.setEmailUsuario(emailUsuario);
        usuario.setSenhaUsuario(senhaUsuario);
        return usuarioRepository.save(usuario);
    }

    // Verifica se o usuário existe (por nome ou e-mail) e se a senha informada corresponde.
    // Se válido, gera um token JWT contendo o nome de usuário e sua permissão.
    public String autenticar(Usuario usuario) {
        Usuario user;
        if (usuario.getEmailUsuario() != null) {
            user = usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario());
        } else {
            user = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());
        }
        if (user != null && user.getSenhaUsuario().equals(usuario.getSenhaUsuario())) {
            return jwtUtil.generateToken(user.getNomeUsuario(), user.getNomePermissao());
        }
        return null;
    }

    // Busca um usuário pelo nome de usuário. Se não encontrado, lança uma exceção.
    public Usuario getUsuarioByNomeUsuario(String nomeUsuario) {
        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado: " + nomeUsuario);
        }
        return usuario;
    }
}
