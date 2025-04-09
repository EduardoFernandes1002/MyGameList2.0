package com.mygamelist.backend.jogo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jogo")
public class JogoController {

    @GetMapping
    public String getJogos() {
        return "Lista de jogos";
    }
}