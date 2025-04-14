package com.mygamelist.backend.permissao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PermissaoController {

    @Autowired
    private PermissaoRepository permissionRepository;

    @GetMapping("/permissions")
    public List<Permissao> getPermissions() {
        return permissionRepository.findAll();
    }
}