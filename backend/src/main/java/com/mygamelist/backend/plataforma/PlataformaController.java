package com.mygamelist.backend.plataforma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/plataformas")
public class PlataformaController {

    @GetMapping
    public String getPlataformas() {
        return "Lista de plataformas";
    }
}