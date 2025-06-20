package com.mygamelist.backend.genero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> getGeneros() {
        return generoService.getGeneros();
    }

    /*
     * Todos jogos de um unico Genero pelo id do Genero,
     * Retornando um Json para o frontend, nao um Objeto Genero.
     * pela rota de "api/generos/{id}/jogos", onde {id} é o id do Genero.
     */
    @GetMapping("/{slugGemero}/jogos")
    public List<?> getJogosByGenero(@PathVariable("slugGemero") String slugGemero) {
        String nomeGenero = slugGemero.replace("-", " ");
        return generoService.findJogosByGenero(nomeGenero);
    }
    

}
