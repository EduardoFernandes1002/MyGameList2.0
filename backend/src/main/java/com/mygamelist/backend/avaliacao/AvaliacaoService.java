package com.mygamelist.backend.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // Retorna todos os usuários
    public List<Avaliacao> getAllAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Avaliacao> getAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id);
    }

    // Salva ou atualiza um usuário
    public Avaliacao saveUsuario(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    // Deleta um usuário por ID
    public void deleteAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}