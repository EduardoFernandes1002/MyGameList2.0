package com.mygamelist.backend.permissao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @GetMapping
    public String getPermissoes() {
        return "permissaos";
    }
}