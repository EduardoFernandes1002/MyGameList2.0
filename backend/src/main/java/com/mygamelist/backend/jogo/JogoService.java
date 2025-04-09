package com.mygamelist.backend.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    // Retorna todos os jogos
    public List<Jogo> getAllJogos() {
        return jogoRepository.findAll();
    }

    // Retorna um jogo por ID
    public Optional<Jogo> getJogoById(Long id) {
        return jogoRepository.findById(id);
    }

    // Salva ou atualiza um jogo
    public Jogo saveJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    // Deleta um jogo por ID
    public void deleteJogo(Long id) {
        jogoRepository.deleteById(id);
    }
}