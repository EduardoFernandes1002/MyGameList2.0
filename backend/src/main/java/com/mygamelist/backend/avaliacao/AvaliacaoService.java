package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.jogo.JogoRepository;
import com.mygamelist.backend.usuario.UsuarioRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AvaliacaoService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private JogoRepository jogoRepository;

    AvaliacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Avaliacao saveAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Page<Avaliacao> getAvaliacoesByJogo(String nomeJogo, Pageable pageable) {
        for (Jogo j : jogoRepository.findAll()) {
            if (j.getNomeJogo().trim().equalsIgnoreCase(nomeJogo.trim())) {
                return avaliacaoRepository.findByJogoId(j.getIdJogo(), pageable);
            }
        }
        throw new IllegalArgumentException("Jogo não encontrado: " + nomeJogo);
    }

    public Avaliacao saveComentarioSemNota(Long idJogo, Long idUsuario, String comentarioUsuario,
            BigDecimal notaUsuario, LocalDate dataEnvioComentario, LocalDate dataEnvioNota) {

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setJogo(jogoRepository.findById(idJogo).orElseThrow());
        avaliacao.setUsuario(usuarioRepository.findById(idUsuario).orElseThrow());
        avaliacao.setComentarioUsuario(comentarioUsuario);
        avaliacao.setNotaUsuario(notaUsuario);
        avaliacao.setDataComentario(dataEnvioComentario);
        avaliacao.setDataEnvio(dataEnvioNota);
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao saveComentarioComNota(Long idJogo, Long idUsuario, String comentarioUsuario,
            BigDecimal notaUsuario, LocalDate dataEnvioComentario) {

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setJogo(jogoRepository.findById(idJogo).orElseThrow());
        avaliacao.setUsuario(usuarioRepository.findById(idUsuario).orElseThrow());
        avaliacao.setComentarioUsuario(comentarioUsuario);
        avaliacao.setDataComentario(dataEnvioComentario);
        return avaliacaoRepository.save(avaliacao);
    }
}
