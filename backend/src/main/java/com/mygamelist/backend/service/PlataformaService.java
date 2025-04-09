package com.mygamelist.backend.service;

import com.mygamelist.backend.model.Plataforma;
import com.mygamelist.backend.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    // Retorna todos os usuários
    public List<Plataforma> getAllPlataformas() {
        return plataformaRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Plataforma> getPlataformaById(Long id) {
        return plataformaRepository.findById(id);
    }

    // Salva ou atualiza um usuário
    public Plataforma savePlataforma(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    // Deleta um usuário por ID
    public void deletePlataforma(Long id) {
        plataformaRepository.deleteById(id);
    }
}