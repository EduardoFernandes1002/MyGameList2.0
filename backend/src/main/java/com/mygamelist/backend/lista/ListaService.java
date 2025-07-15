package com.mygamelist.backend.lista;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygamelist.backend.avaliacao.Avaliacao;
import com.mygamelist.backend.avaliacao.AvaliacaoRepository;
import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.jogo.JogoRepository;
import com.mygamelist.backend.security.JwtUtil;
import com.mygamelist.backend.usuario.Usuario;
import com.mygamelist.backend.usuario.UsuarioRepository;

@Service
public class ListaService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private JogoAdicionadoRepository jogoAdicionadoRepository;

    ListaService(JogoAdicionadoRepository jogoAdicionadoRepository) {
        this.jogoAdicionadoRepository = jogoAdicionadoRepository;
    }

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

    public void adicionarJogoNaLista(Long idLista, Long idUsuario, Long idJogo) {
        Lista lista = listaRepository.findById(idLista).orElseThrow();
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        Jogo jogo = jogoRepository.findById(idJogo).orElseThrow();

        JogoAdicionado ja = new JogoAdicionado();
        ja.setListas(lista);
        ja.setUsuario(usuario);
        ja.setJogos(jogo);
        jogoAdicionadoRepository.save(ja);
    }

    public void removerJogoDaLista(Long idLista, Long idJogo, String token) {
        // Extrai nome de usuário do token
        String nomeUsuario = jwtUtil.getSubject(token.replace("Bearer ", ""));

        // Busca o usuário no banco
        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (usuario == null)
            throw new RuntimeException("Usuário não encontrado");

        // Caso a lista seja '7' (favoritos), remove só dos favoritos
        if (idLista == 7L) {
            jogoAdicionadoRepository.deleteByUsuarioIdAndListaIdAndJogoId(
                    usuario.getIdUsuario(), idLista, idJogo);
            return;
        }

        // Remove da lista específica
        jogoAdicionadoRepository.deleteByUsuarioIdAndListaIdAndJogoId(
                usuario.getIdUsuario(), idLista, idJogo);

        // Remove também da lista 'Geral' (id 1), se for diferente
        if (!idLista.equals(1L)) {
            jogoAdicionadoRepository.deleteByUsuarioIdAndListaIdAndJogoId(
                    usuario.getIdUsuario(), 1L, idJogo);
        }

        // Remove também dos favoritos (lista 7), se não for ele próprio
        if (!idLista.equals(7L)) {
            jogoAdicionadoRepository.deleteByUsuarioIdAndListaIdAndJogoId(
                    usuario.getIdUsuario(), 7L, idJogo);
        }
    }
}
