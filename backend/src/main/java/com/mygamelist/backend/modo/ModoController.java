package com.mygamelist.backend.modo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/modos")
public class ModoController {

    @GetMapping
    public String getModos() {
        return "Lista de modos";
    }
}