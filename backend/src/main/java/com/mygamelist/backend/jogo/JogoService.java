package com.mygamelist.backend.jogo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> getJogos() {
        return jogoRepository.findAll();
    }

    public Jogo findJogoByNome(String nomeJogo) {
        return jogoRepository.findByNomeJogo(nomeJogo);
    }

    public List<Map<String, Object>> findJogosByTopCinco() {
        List<Jogo> jogos = jogoRepository.findAll(PageRequest.of(0, 5, Sort.by("totalNotaJogo").descending()))
                .getContent();

        // Monta um map para cada jogo com nome, nota, generos e plataformas (listas
        // completas)
        return jogos.stream().map(jogo -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("nomeJogo", jogo.getNomeJogo());
            map.put("totalNotaJogo", jogo.getTotalNotaJogo());
            map.put("generos", jogo.getGeneros());
            map.put("plataformas", jogo.getPlataformas());
            map.put("imagemJogo", jogo.getImagemJogo());
            return map;
        }).toList();
    }

     public List<Map<String, Object>> findRankJogos() {
        List<Jogo> jogos = jogoRepository.findAll(PageRequest.of(0, 5, Sort.by("totalNotaJogo").descending()))
                .getContent();

        // Monta um map para cada jogo com nome, nota, generos e plataformas (listas completas)
        return jogos.stream().map(jogo -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("nomeJogo", jogo.getNomeJogo());
            map.put("totalNotaJogo", jogo.getTotalNotaJogo());
            map.put("generos", jogo.getGeneros());
            map.put("plataformas", jogo.getPlataformas());
            map.put("imagemJogo", jogo.getImagemJogo());
            return map;
        }).toList();
    }
}
