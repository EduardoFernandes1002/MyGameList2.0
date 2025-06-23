package com.mygamelist.backend.lista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<?> getJogosAdicionados(@PathVariable("lista") Long idLista, @PathVariable("nomeUsuario") String nomeUsuario) {
        return listaService.findJogosPerfilUsuario(idLista, nomeUsuario);
    }
}
