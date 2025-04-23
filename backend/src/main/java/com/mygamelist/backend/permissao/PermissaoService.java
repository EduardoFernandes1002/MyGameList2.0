package com.mygamelist.backend.permissao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissionRepository;

    public List<Permissao> getPermissoes() {
        return permissionRepository.findAll();
    }

    public Permissao getPermissaoById(Long idPermissao) {
        return permissionRepository.findById(idPermissao).orElse(null);

    }

}
