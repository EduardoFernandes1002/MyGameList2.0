package com.mygamelist.backend.jogo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> getJogos() {
        return jogoRepository.findAll();
    }

    public Jogo getJogoById(Long idJogo) {
        return jogoRepository.findById(idJogo).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }
}
