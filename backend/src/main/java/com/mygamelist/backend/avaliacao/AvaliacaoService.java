package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.jogo.JogoRepository;
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

    public Page<Avaliacao> getAvaliacoesByJogo(String nomeJogo, Pageable pageable) {
        Jogo jogo = jogoRepository.findByNomeJogo(nomeJogo);
        if (jogo == null) {
            throw new IllegalArgumentException("Jogo não encontrado: " + nomeJogo);
        }
        return avaliacaoRepository.findByJogoNome(nomeJogo, pageable);
    }
}
