package com.mygamelist.backend.distribuidora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distribuidora")
public class DistribuidoraController {

    @GetMapping
    public String getDistribuidoras() {
        return "Lista de distribuidoras";
    }
}