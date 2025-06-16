package com.mygamelist.backend.usuario;

import com.mygamelist.backend.jogo.JogoRepository;
import com.mygamelist.backend.lista.ListaRepository;
import com.mygamelist.backend.avaliacao.AvaliacaoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecomendacaoService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JogoRepository jogoRepository;
    
    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    List<?> recomendarJogosParaUsuario() {
        

        

        return null;
    }
}
