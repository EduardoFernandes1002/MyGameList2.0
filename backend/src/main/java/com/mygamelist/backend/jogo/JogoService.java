package com.mygamelist.backend.jogo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygamelist.backend.avaliacao.AvaliacaoRepository;
import com.mygamelist.backend.desenvolvedora.Desenvolvedora;
import com.mygamelist.backend.desenvolvedora.DesenvolvedoraRepository;
import com.mygamelist.backend.distribuidora.Distribuidora;
import com.mygamelist.backend.distribuidora.DistribuidoraRepository;
import com.mygamelist.backend.genero.Genero;
import com.mygamelist.backend.genero.GeneroRepository;
import com.mygamelist.backend.lista.JogoAdicionadoRepository;
import com.mygamelist.backend.modo.Modo;
import com.mygamelist.backend.modo.ModoRepository;
import com.mygamelist.backend.plataforma.Plataforma;
import com.mygamelist.backend.plataforma.PlataformaRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private JogoAdicionadoRepository jogoAdicionadoRepository;

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

    public Jogo adicionarJogo(JogoRequestDTO dto, StringBuilder msgFaltantes) {

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

        List<Plataforma> plataformasEncontradas = plataformaRepository.findByNomePlataformaIn(dto.plataformas);

        // Extrai os nomes encontrados para uma lista simples
        List<String> nomesPlataformasEncontradas = plataformasEncontradas.stream()
                .map(Plataforma::getNomePlataforma)
                .toList();

        // Agora pega os nomes que vieram no DTO que **não estão** na lista de
        // encontrados
        List<String> plataformasFaltantes = dto.plataformas.stream()
                .filter(nome -> !nomesPlataformasEncontradas.contains(nome))
                .toList();

        List<Genero> generosEncontrados = generoRepository.findByNomeGeneroIn(dto.generos);

        List<String> nomesGenerosEncontrados = generosEncontrados.stream()
                .map(Genero::getNomeGenero)
                .toList();

        List<String> generosFaltantes = dto.generos.stream()
                .filter(nome -> !nomesGenerosEncontrados.contains(nome))
                .toList();

        List<Modo> modosEncontrados = modoRepository.findByNomeModoIn(dto.modos);

        List<String> nomesModosEncontrados = modosEncontrados.stream()
                .map(Modo::getNomeModo)
                .toList();

        List<String> modosFaltantes = dto.modos.stream()
                .filter(nome -> !nomesModosEncontrados.contains(nome))
                .toList();

        System.out.println("Generos encontrados: " + generosEncontrados);
        System.out.println("Modos encontrados: " + modosEncontrados);
        System.out.println("Plataformas encontrados: " + plataformasEncontradas);

        jogo.setGeneros(generosEncontrados);
        jogo.setModos(modosEncontrados);
        jogo.setPlataformas(plataformasEncontradas);

        if (!generosFaltantes.isEmpty()) {
            msgFaltantes.append("Gêneros não adicionados: ").append(String.join(", ", generosFaltantes)).append(". ");
        }
        if (!modosFaltantes.isEmpty()) {
            msgFaltantes.append("Modos não adicionados: ").append(String.join(", ", modosFaltantes)).append(". ");
        }
        if (!plataformasFaltantes.isEmpty()) {
            msgFaltantes.append("Plataformas não adicionadas: ").append(String.join(", ", plataformasFaltantes))
                    .append(". ");
        }

        return jogoRepository.save(jogo);
    }

    @Transactional
    public Jogo editarJogo(Long idJogo, JogoRequestDTO dto) {
        Jogo jogo = jogoRepository.findById(idJogo)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

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

        // Atualizar gêneros
        jogo.getGeneros().clear();
        if (dto.generos != null && !dto.generos.isEmpty()) {
            List<Genero> generosEncontrados = generoRepository.findByNomeGeneroIn(dto.generos);
            jogo.getGeneros().addAll(generosEncontrados);
        }

        // Atualizar modos
        jogo.getModos().clear();
        if (dto.modos != null && !dto.modos.isEmpty()) {
            List<Modo> modosEncontrados = modoRepository.findByNomeModoIn(dto.modos);
            jogo.getModos().addAll(modosEncontrados);
        }

        // Atualizar plataformas
        jogo.getPlataformas().clear();
        if (dto.plataformas != null && !dto.plataformas.isEmpty()) {
            List<Plataforma> plataformasEncontradas = plataformaRepository.findByNomePlataformaIn(dto.plataformas);
            jogo.getPlataformas().addAll(plataformasEncontradas);
        }

        return jogoRepository.save(jogo);
    }

    @Transactional
    public void deletarJogo(Long idJogo) {
        Jogo jogo = jogoRepository.findById(idJogo)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

        // Remove da tabela de avaliações
        avaliacaoRepository.deleteByJogo_IdJogo(idJogo);

        // Remove de listas do usuário (M:N com Lista)
        jogoAdicionadoRepository.deleteByJogos_IdJogo(idJogo);

        // Limpa relações M:N
        jogo.getGeneros().clear();
        jogo.getModos().clear();
        jogo.getPlataformas().clear();

        jogoRepository.save(jogo); // força atualizar antes de deletar

        jogoRepository.delete(jogo);
    }

}