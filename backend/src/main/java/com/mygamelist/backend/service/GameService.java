package com.mygamelist.backend.service;

import com.mygamelist.backend.model.Jogo;
import com.mygamelist.backend.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private JogoRepository gameRepository;

    public List<Jogo> getAllGames() {
        return gameRepository.findAll();
    }

    public Jogo saveGame(Jogo game) {
        return gameRepository.save(game);
    }
}