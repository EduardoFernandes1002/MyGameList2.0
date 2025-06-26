package com.mygamelist.backend.jogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<?> getJogos() {
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

    @GetMapping("/rank")
    public List<?> getRank() {
        return jogoService.findRankJogos();
    }

    @PostMapping("/adicionar/jogo")
    public ResponseEntity<?> adicionarJogo(@RequestBody Jogo jogo, @RequestBody List<String> generos,
            @RequestBody List<String> plataformas, @RequestBody List<String> modos) {

        jogoService.adicionarJogo(jogo, generos, plataformas, modos);

        return ResponseEntity.ok("Jogo adicionado com sucesso!");
    }

}
