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
        
        /** 
         * 
         *  Implementar lógica de recomendação de jogos para o usuário
         *  Isso pode envolver análise de dados, filtragem, etc.
         *  A logica inclui:
         *    - Analisar as listas de jogos do usuário
         *    - Analisar as avaliações dos jogos
         *    - Considerar jogos populares ou bem avaliados
         *    - Considerar jogos de gêneros ou categorias que o usuário gosta
         *    - Considerar nota de jogos que o usuário já jogou
         *    - Retornar uma lista de jogos recomendados para o usuário
         * 
        **/
        

        return null;
    }
}
