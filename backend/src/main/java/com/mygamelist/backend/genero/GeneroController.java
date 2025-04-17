package com.mygamelist.backend.genero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {
    
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> getGeneros() {
        return generoService.getGeneros();
    }

    @GetMapping("/{id}")
    public Genero getGeneroById(@PathVariable Long idGenero) {
        return generoService.getGeneroById(idGenero);
    }

}
