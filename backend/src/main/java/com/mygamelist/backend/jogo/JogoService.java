package com.mygamelist.backend.jogo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygamelist.backend.desenvolvedora.Desenvolvedora;
import com.mygamelist.backend.desenvolvedora.DesenvolvedoraRepository;
import com.mygamelist.backend.distribuidora.Distribuidora;
import com.mygamelist.backend.distribuidora.DistribuidoraRepository;
import com.mygamelist.backend.genero.Genero;
import com.mygamelist.backend.genero.GeneroRepository;
import com.mygamelist.backend.modo.Modo;
import com.mygamelist.backend.modo.ModoRepository;
import com.mygamelist.backend.plataforma.Plataforma;
import com.mygamelist.backend.plataforma.PlataformaRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private ModoRepository modoRepository;

    @Autowired
    private PlataformaRepository plataformaRepository;

    @Autowired
    private DesenvolvedoraRepository desenvolvedoraRepository;

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public List<Map<String, Object>> getJogos() {
        List<Jogo> jogos = jogoRepository.findAll(PageRequest.of(0, 12, Sort.by("totalNotaJogo").descending()))
                .getContent();
        return jogos.stream().map(jogo -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("nomeJogo", jogo.getNomeJogo());
            map.put("dataLancamentoJogo", jogo.getDataLancamentoJogo());
            map.put("sinopseJogo", jogo.getSinopseJogo());
            map.put("generos", jogo.getGeneros());
            map.put("plataformas", jogo.getPlataformas());
            map.put("modos", jogo.getModos());
            return map;
        }).toList();
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

    // Coleta uma lista com todos os jogos rankeados com paginação
    public List<Map<String, Object>> findRankJogos() {
        List<Jogo> jogos = jogoRepository.findAll(PageRequest.of(0, 10, Sort.by("totalNotaJogo").descending()))
                .getContent();

        // Monta um map para cada jogo com nome, nota, generos e a sua imagem
        return jogos.stream().map(jogo -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("nomeJogo", jogo.getNomeJogo());
            map.put("totalNotaJogo", jogo.getTotalNotaJogo());
            map.put("imagemJogo", jogo.getImagemJogo());
            return map;
        }).toList();
    }

    public void adicionarJogo(JogoRequestDTO dto) {

        Jogo jogo = new Jogo();
        jogo.setNomeJogo(dto.nomeJogo);
        jogo.setSinopseJogo(dto.sinopseJogo);
        jogo.setImagemJogo(dto.imagemJogo);
        jogo.setDataLancamentoJogo(dto.dataLancamentoJogo);

        Desenvolvedora desenvolvedora = desenvolvedoraRepository.findByNomeDesenvolvedora(dto.nomeDesenvolvedora)
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada"));
        jogo.setDesenvolvedora(desenvolvedora);

        Distribuidora distribuidora = distribuidoraRepository.findByNomeDistribuidora(dto.nomeDistribuidora)
                .orElseThrow(() -> new RuntimeException("Distribuidora não encontrada"));
        jogo.setDistribuidora(distribuidora);



        // Pode deixar null se não quiser calcular agora
        jogo.setTotalNotaJogo(null);

        jogoRepository.save(jogo);
    }
}