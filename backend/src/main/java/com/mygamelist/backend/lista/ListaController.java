package com.mygamelist.backend.lista;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lista")
public class ListaController {

    @GetMapping
    public String getLista() {
        return "Lista de jogos do usuario";
    }
}