package com.mygamelist.backend.jogo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogo> getJogos() {
        return jogoService.getJogos();
    }

    @GetMapping("/{idJogo}")
    public Jogo getJogoById(@PathVariable Long idJogo) {
        return jogoService.getJogoById(idJogo);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<JogoDetalhesDTO> getDetalhesJogo(@PathVariable("id") Long idJogo) {
        JogoDetalhesDTO detalhes = jogoService.buscarDetalhesJogo(idJogo);
        
        if (detalhes == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(detalhes);
    }
    
}
