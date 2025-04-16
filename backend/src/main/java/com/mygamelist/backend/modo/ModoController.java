package com.mygamelist.backend.modo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modo")
public class ModoController {
    
    @Autowired
    private ModoService modoService;

    @GetMapping
    public List<Modo> getModos() {
        return modoService.getModos();
    }  

    @GetMapping("/{id}")
    public Modo getModoById(@PathVariable Long idModo) {
        return modoService.getModoById(idModo);
    }
}
