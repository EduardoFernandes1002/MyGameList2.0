package com.mygamelist.backend.avaliacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @GetMapping
    public String getAvalicoes() {
        return "Lista de avaliacoes";
    }
}