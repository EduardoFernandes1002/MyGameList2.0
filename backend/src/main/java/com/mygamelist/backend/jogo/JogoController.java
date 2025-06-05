package com.mygamelist.backend.jogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogo> getJogos() {
        return jogoService.getJogos();
    }

    @GetMapping("/{slug}")
    public Jogo getJogoBySlug(@PathVariable("slug") String slug) {
        String nomeJogo = slug.replace("-", " ");
        return jogoService.findJogoByNome(nomeJogo);
    }
    
    @GetMapping("/rank/cinco")
    public List<?> getJogosByTopCinco() {
        return jogoService.findJogosByTopCinco();
    }

}
