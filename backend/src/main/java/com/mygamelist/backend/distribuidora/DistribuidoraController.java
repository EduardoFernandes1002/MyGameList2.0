package com.mygamelist.backend.distribuidora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/distribuidoras")
public class DistribuidoraController {
    
    @Autowired
    private DistribuidoraService distribuidoraService;
    
    @GetMapping
    public List<Distribuidora> getDistribuidoras() {
         return distribuidoraService.getDistribuidoras();
    }

    @GetMapping("/{id}")
    public Distribuidora getDistribuidoraById(@PathVariable Long idDistribuidora) {
        return distribuidoraService.getDistribuidoraById(idDistribuidora);
    }

}
