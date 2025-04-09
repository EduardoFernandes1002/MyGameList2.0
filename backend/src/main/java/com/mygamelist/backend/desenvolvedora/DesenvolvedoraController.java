package com.mygamelist.backend.desenvolvedora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distribuidora")
public class DesenvolvedoraController {

    @GetMapping
    public String getDesenvolvedoras() {
        return "Lista de distribuidoras";
    }
}