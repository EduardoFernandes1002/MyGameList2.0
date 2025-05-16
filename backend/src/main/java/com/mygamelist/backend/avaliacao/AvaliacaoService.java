package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.jogo.JogoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public Avaliacao saveAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> getAvaliacoesByJogo(String nomeJogo) {
        for (Jogo j : jogoRepository.findAll()) {
            if (j.getNomeJogo().trim().equalsIgnoreCase(nomeJogo.trim())) {
                return avaliacaoRepository.findByJogoId(j.getIdJogo());
            }
        }
        throw new IllegalArgumentException("Jogo não encontrado: " + nomeJogo);
    }

    public Page<Avaliacao> getAvaliacoesByJogo(String nomeJogo, Pageable pageable) {
        for (Jogo j : jogoRepository.findAll()) {
            if (j.getNomeJogo().trim().equalsIgnoreCase(nomeJogo.trim())) {
                return avaliacaoRepository.findByJogoId(j.getIdJogo(), pageable);
            }
        }
        throw new IllegalArgumentException("Jogo não encontrado: " + nomeJogo);
    }
}
