package com.mygamelist.backend.lista;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygamelist.backend.avaliacao.Avaliacao;
import com.mygamelist.backend.avaliacao.AvaliacaoRepository;
import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.usuario.Usuario;
import com.mygamelist.backend.usuario.UsuarioRepository;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Lista> getListas() {
        return listaRepository.findAll();
    }

    public Lista getListaById(Long idLista) {
        return listaRepository.findById(idLista).orElse(null);
    }

    public List<Map<String, Object>> findJogosPerfilUsuario(Long idLista,
            String nomeUsuario) {

        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (usuario == null)
            return List.of();
        Long idUsuario = usuario.getIdUsuario();

        List<Jogo> jogos = listaRepository.findJogosAdicionados(idLista, idUsuario);

        return jogos.stream().map(jogo -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("idJogo", jogo.getIdJogo());
            map.put("nomeJogo", jogo.getNomeJogo());
            map.put("imagemJogo", jogo.getImagemJogo());

            // Buscar a nota do usuário para esse jogo caso exista
            Avaliacao avaliacao = avaliacaoRepository.findByUsuario_IdUsuarioAndJogo_IdJogo(
                    idUsuario,
                    jogo.getIdJogo());
            map.put("notaUsuario", avaliacao != null
                    ? avaliacao.getNotaUsuario()
                    : null);
            return map;
        }).toList();
    }
}
