package com.mygamelist.backend.jogo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

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
    public ResponseEntity<String> adicionarJogo(@RequestBody JogoRequestDTO dto) {

        StringBuilder msgFaltantes = new StringBuilder();

        try {
            jogoService.adicionarJogo(dto, msgFaltantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar o jogo: " + e.getMessage());
        }

        if (msgFaltantes.length() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Jogo adicionado com sucesso! Porém: " + msgFaltantes.toString());
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Jogo adicionado com sucesso!");
        }
    }

    @PutMapping("/{id}")
    public String editarJogo(@PathVariable Long id, @RequestBody JogoRequestDTO dto) {
        jogoService.editarJogo(id, dto);
        return "Jogo editado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletarJogo(@PathVariable Long id) {
        jogoService.deletarJogo(id);
        return "Jogo deletado com sucesso!";
    }

}
