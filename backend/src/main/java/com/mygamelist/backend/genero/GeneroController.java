package com.mygamelist.backend.genero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @GetMapping
    public String getGeneros() {
        return "Lista de generos";
    }
}