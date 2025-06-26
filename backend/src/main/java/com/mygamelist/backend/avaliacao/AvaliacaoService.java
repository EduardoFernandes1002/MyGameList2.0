package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.JogoRepository;
import com.mygamelist.backend.usuario.UsuarioRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

/**
 * Serviço responsável pelas regras de negócio relacionadas às avaliações de
 * jogos.
 * Permite buscar avaliações por jogo, salvar comentários e notas.
 */
@Service
public class AvaliacaoService {
    /**
     * Repositório de usuários.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Repositório de avaliações.
     */
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    /**
     * Repositório de jogos.
     */
    @Autowired
    private JogoRepository jogoRepository;

    /**
     * Construtor para injeção de dependência do repositório de usuários.
     */
    AvaliacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Busca todas as avaliações de um jogo específico, com suporte a paginação.
     * 
     * @param idJogo   id do jogo
     * @param pageable informações de paginação
     * @return lista de avaliações em formato de mapa (id, usuário, comentário,
     *         nota, data do comentário)
     */
    public List<Map<String, Object>> getAvaliacoesByJogo(Long idJogo, Pageable pageable) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByJogo_IdJogo(
                idJogo, pageable);
        return avaliacoes.stream().map(avaliacao -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("idAvaliacao", avaliacao.getIdAvaliacao());
            map.put("apelidoUsuario", avaliacao.getUsuario().getApelidoUsuario());
            map.put("comentarioUsuario", avaliacao.getComentarioUsuario());
            map.put("notaUsuario", avaliacao.getNotaUsuario());
            map.put("dataComentario", avaliacao.getDataComentario());
            return map;
        }).toList();
    }

    /**
     * Salva um comentário de avaliação sem nota.
     * 
     * @param idJogo              id do jogo
     * @param idUsuario           id do usuário
     * @param comentarioUsuario   texto do comentário
     * @param notaUsuario         nota atribuída
     * @param dataEnvioComentario data do comentário
     * @param dataEnvioNota       data da nota
     * @return avaliação salva juntamente com a nota
     */
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

    /**
     * Salva um comentário de avaliação com nota.
     * 
     * @param idJogo              id do jogo
     * @param idUsuario           id do usuário
     * @param comentarioUsuario   texto do comentário
     * @param notaUsuario         nota atribuída
     * @param dataEnvioComentario data do comentário
     * @return avaliação salva
     */
    public Avaliacao saveComentarioComNota(Long idJogo, Long idUsuario, String comentarioUsuario,
            BigDecimal notaUsuario, LocalDate dataEnvioComentario) {

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setJogo(jogoRepository.findById(idJogo).orElseThrow());
        avaliacao.setUsuario(usuarioRepository.findById(idUsuario).orElseThrow());
        avaliacao.setComentarioUsuario(comentarioUsuario);
        avaliacao.setDataComentario(dataEnvioComentario);
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Map<String, Object>> getTresComentariosMaisRecentes() {
        Pageable limit = PageRequest.of(0, 3);
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAllByOrderByDataComentarioDesc(limit);
        return avaliacoes.stream().map(avaliacao -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("idAvaliacao", avaliacao.getIdAvaliacao());
            map.put("nomeUsuario", avaliacao.getUsuario().getNomeUsuario());
            map.put("apelidoUsuario", avaliacao.getUsuario().getApelidoUsuario());
            map.put("nomeJogo", avaliacao.getJogo().getNomeJogo());
            map.put("comentarioUsuario", avaliacao.getComentarioUsuario());
            map.put("notaUsuario", avaliacao.getNotaUsuario());
            map.put("dataEnvioComentario", avaliacao.getDataComentario());
            return map;
        }).toList();
    }

    public Avaliacao saveNota(Long idJogo, Long idUsuario, BigDecimal notaUsuario, LocalDate dataEnvioNota) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setJogo(jogoRepository.findById(idJogo).orElseThrow());
        avaliacao.setUsuario(usuarioRepository.findById(idUsuario).orElseThrow());
        avaliacao.setNotaUsuario(notaUsuario);
        avaliacao.setDataEnvio(dataEnvioNota);
        return avaliacaoRepository.save(avaliacao);
    }
}
