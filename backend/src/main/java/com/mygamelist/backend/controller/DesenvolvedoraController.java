package com.mygamelist.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class DesenvolvedoraController {

    @GetMapping
    public String getJogos() {
        return "Lista de jogos";
    }
}