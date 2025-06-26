package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Controller responsável pelos endpoints de avaliações de jogos.
 * Permite buscar avaliações por jogo (via slug) e outras operações futuras.
 */
@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {
    /**
     * Serviço de avaliações.
     */
    @Autowired
    private AvaliacaoService avaliacaoService;

    /**
     * Repositório de jogos.
     */
    @Autowired
    private JogoRepository jogoRepository;

    /**
     * Busca avaliações de um jogo a partir do slug (nome formatado).
     * 
     * @param slug     slug do nome do jogo
     * @param pageable informações de paginação
     * @return lista de avaliações do jogo
     */
    @GetMapping("/jogo/comment/{slug}")
    public List<Map<String, Object>> getAvaliacoesByJogo(@PathVariable("slug") String slug, Pageable pageable) {
        String nomeJogo = slug.replace("-", " ");
        // Buscar o jogo pelo nome
        Jogo jogo = jogoRepository.findByNomeJogo(nomeJogo);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }
        // Buscar avaliações pelo id do jogo
        return avaliacaoService.getAvaliacoesByJogo(jogo.getIdJogo(), pageable);
    }

    @GetMapping("/recentes")
    public ResponseEntity<List<Map<String, Object>>> getTresComentariosMaisRecentes() {
        List<Map<String, Object>> comentarios = avaliacaoService.getTresComentariosMaisRecentes();
        return ResponseEntity.ok(comentarios);
    }

    @PostMapping("/salvarNota")
    public ResponseEntity<?> salvarNota(@RequestBody String entity) {
        //TODO: process POST request
        
        return ResponseEntity.ok().build();
    }
    
}
