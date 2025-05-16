package com.mygamelist.backend.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public PageResponse<Avaliacao> getAvaliacoesByJogo(@PathVariable("slug") String slug, Pageable pageable) {
        String nomeJogo = slug.replace("-", " ");
        Page<Avaliacao> page = avaliacaoService.getAvaliacoesByJogo(nomeJogo, pageable);
        PageResponse<Avaliacao> response = new PageResponse<>();
        response.setContent(page.getContent());
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());
        return response;
    }
}
