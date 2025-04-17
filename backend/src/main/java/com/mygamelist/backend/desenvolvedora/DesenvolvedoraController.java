package com.mygamelist.backend.desenvolvedora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/desenvolvedoras")
public class DesenvolvedoraController {
    
    @Autowired
    private DesenvolvedoraService desenvolvedoraService;
    
    @GetMapping
    public List<Desenvolvedora> getDesenvolvedoras() {
         return desenvolvedoraService.getDesenvolvedoras();
    }

}
