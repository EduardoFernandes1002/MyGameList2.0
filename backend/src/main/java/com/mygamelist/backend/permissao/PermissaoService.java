package com.mygamelist.backend.permissao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    // Retorna todos os usuários
    public List<Permissao> getAllPermissoes() {
        return permissaoRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Permissao> getPermissaoById(Long id) {
        return permissaoRepository.findById(id);
    }

    // Salva ou atualiza um usuário
    public Permissao savePermissao(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    // Deleta um usuário por ID
    public void deletePermissao(Long id) {
        permissaoRepository.deleteById(id);
    }
}