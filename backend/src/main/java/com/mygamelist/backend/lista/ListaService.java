package com.mygamelist.backend.lista;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Lista listaAlvo = listaRepository.findById(idLista).orElseThrow();
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        Jogo jogo = jogoRepository.findById(idJogo).orElseThrow();

        // Garante que o jogo esteja na lista "Geral" (ID = 1)
        if (!jogoAdicionadoRepository.existsByUsuario_IdUsuarioAndJogos_IdJogoAndListas_IdLista(idUsuario, idJogo,
                1L)) {
            Lista listaGeral = listaRepository.findById(1L).orElseThrow();
            JogoAdicionado geral = new JogoAdicionado();
            geral.setListas(listaGeral);
            geral.setUsuario(usuario);
            geral.setJogos(jogo);
            jogoAdicionadoRepository.save(geral);
        }
// abobora
        // Se a lista for 1 (Geral) ou 7 (Favoritos), não precisa remover de outras
        if (idLista != 1L && idLista != 7L) {
            // Remove o jogo de qualquer outra lista do usuário (exceto Geral e Favoritos)
            List<JogoAdicionado> existentes = jogoAdicionadoRepository.findByUsuario_IdUsuarioAndJogos_IdJogo(idUsuario,
                    idJogo);
            for (JogoAdicionado existente : existentes) {
                Long idExistente = existente.getListas().getIdLista();
                if (idExistente != 1L && idExistente != 7L) {
                    jogoAdicionadoRepository.delete(existente);
                }
            }
        }

        // Adiciona o jogo na nova lista, se ainda não estiver
        boolean jaExiste = jogoAdicionadoRepository.existsByUsuario_IdUsuarioAndJogos_IdJogoAndListas_IdLista(idUsuario,
                idJogo, idLista);
        if (!jaExiste) {
            JogoAdicionado novo = new JogoAdicionado();
            novo.setListas(listaAlvo);
            novo.setUsuario(usuario);
            novo.setJogos(jogo);
            jogoAdicionadoRepository.save(novo);
        }
    }

    @Transactional
    public void removerJogoDaLista(Long idLista, Long idJogo, String token) {
        // Extrai nome de usuário do token
        String nomeUsuario = jwtUtil.getSubject(token.replace("Bearer ", ""));

        // Busca o usuário no banco
        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (usuario == null)
            throw new RuntimeException("Usuário não encontrado");

        Long userId = usuario.getIdUsuario();

        // Se for favoritos, remove só dos favoritos
        if (idLista.equals(7L)) {
            jogoAdicionadoRepository.deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(userId, 7L, idJogo);
            return;
        }

        // Remove da lista informada
        jogoAdicionadoRepository.deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(userId, idLista, idJogo);

        // Sempre remove dos favoritos (exceto se já for a lista 7, que já saiu acima)
        jogoAdicionadoRepository.deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(userId, 7L, idJogo);

        if (idLista.equals(1L)) {
            // Se for Geral, remove de todas as listas 2~6
            for (long i = 2; i <= 6; i++) {
                jogoAdicionadoRepository.deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(userId, i, idJogo);
            }
        } else {
            // Se for qualquer outra lista, também remove de Geral
            jogoAdicionadoRepository.deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(userId, 1L, idJogo);
        }
    }

}
