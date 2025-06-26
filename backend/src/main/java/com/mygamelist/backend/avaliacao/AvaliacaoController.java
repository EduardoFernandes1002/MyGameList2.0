package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/salvar-nota")
    public ResponseEntity<?> salvarNota(@RequestBody Map<String, Object> payload) {
        {
            try {
                Long idJogo = Long.valueOf(payload.get("idJogo").toString());
                Long idUsuario = Long.valueOf(payload.get("idUsuario").toString());
                BigDecimal notaUsuario = payload.get("notaUsuario") != null
                        ? new BigDecimal(payload.get("notaUsuario").toString())
                        : null;
                String comentarioUsuario = (String) payload.getOrDefault("comentarioUsuario", null);

                String dataEnvioNotaStr = (String) payload.get("dataEnvioNota");
                LocalDate dataEnvioNota = dataEnvioNotaStr != null ? LocalDate.parse(dataEnvioNotaStr)
                        : LocalDate.now();

                if (notaUsuario == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota é obrigatória.");
                }
                if (dataEnvioNota == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nota é obrigatória.");
                }

                Avaliacao avaliacao = avaliacaoService.salvarNotaOuComentario(idJogo, idUsuario, notaUsuario,
                        comentarioUsuario, dataEnvioNota);
                return ResponseEntity.ok(avaliacao);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Erro ao salvar avaliação: " + e.getMessage());
            }
        }

    }

    @GetMapping("/usuario/{idUsuario}/jogo/{idJogo}")
    public ResponseEntity<?> getAvaliacaoUsuarioJogo(@PathVariable Long idUsuario, @PathVariable Long idJogo) {
        Avaliacao avaliacao = avaliacaoService.getAvaliacaoUsuarioJogo(idUsuario, idJogo);
        if (avaliacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacao);
    }
}
