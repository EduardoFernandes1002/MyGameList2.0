package com.mygamelist.backend.plataforma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping
    public List<Plataforma> getPlataformas() {
        return plataformaService.getPlataformas();
    }

    @GetMapping("/{id}")
    public Plataforma getPlataformaById(@PathVariable Long idPlataforma) {
        return plataformaService.getPlataformaById(idPlataforma);
    }
}
