package com.mygamelist.backend.avaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public Avaliacao createAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.saveAvaliacao(avaliacao);
    }

    @GetMapping("/jogo/comment/{slug}")
    public Page<Avaliacao> getAvaliacoesByJogo(@PathVariable("slug") String slug, Pageable pageable) {
        String nomeJogo = slug.replace("-", " ");
        return avaliacaoService.getAvaliacoesByJogo(nomeJogo, pageable);
    }
}
