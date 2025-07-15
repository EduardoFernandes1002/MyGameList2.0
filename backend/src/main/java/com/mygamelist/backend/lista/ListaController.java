package com.mygamelist.backend.lista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lista")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping
    public List<Lista> getListas() {
        return listaService.getListas();
    }

    @GetMapping("/{id}")
    public Lista getListaById(@PathVariable Long id) {
        return listaService.getListaById(id);
    }

    @GetMapping("/{nomeUsuario}/{lista}/jogos")
    public List<?> getJogosAdicionados(@PathVariable("lista") Long idLista,
            @PathVariable("nomeUsuario") String nomeUsuario) {
        return listaService.findJogosPerfilUsuario(idLista, nomeUsuario);
    }

    @PostMapping("/{idUsuario}/{idLista}/{idJogo}/adicionar")
    public ResponseEntity<?> adicionarJogoNaLista(
            @PathVariable Long idUsuario,
            @PathVariable Long idLista,
            @PathVariable Long idJogo) {
        try {
            listaService.adicionarJogoNaLista(idLista, idUsuario, idJogo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao adicionar jogo: " + e.getMessage());
        }
    }

    @DeleteMapping("/{idLista}/jogo/{idJogo}")
    public ResponseEntity<?> removerJogoDaLista(
            @PathVariable Long idLista,
            @PathVariable Long idJogo,
            @RequestHeader("Authorization") String token) {
        try {
            listaService.removerJogoDaLista(idLista, idJogo, token);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
