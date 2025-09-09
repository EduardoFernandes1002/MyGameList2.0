package com.mygamelist.backend.modo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modos")
public class ModoController {

    @Autowired
    private ModoService modoService;

    @GetMapping
    public List<Modo> getModos() {
        return modoService.getModos();
    }

    @GetMapping("/{slugModo}/jogos")
    public List<?> getJogosByGenero(@PathVariable("slugModo") String slugModo) {
        String nomeModo = slugModo.replace("-", " ");
        return modoService.findJogosByModo(nomeModo);
    }
}
