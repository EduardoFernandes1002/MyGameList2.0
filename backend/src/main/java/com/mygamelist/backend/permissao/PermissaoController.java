package com.mygamelist.backend.permissao;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public List<Permissao> getPermissoes() {
        return permissaoService.getPermissoes();
    }

    @GetMapping("{id}")
    public Permissao getPermissaoById(@PathVariable Long id) {
        return permissaoService.getPermissaoById(id);
    }

}