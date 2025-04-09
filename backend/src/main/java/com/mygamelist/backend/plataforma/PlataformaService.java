package com.mygamelist.backend.plataforma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    // Retorna todas as plataformas
    public List<Plataforma> getAllPlataformas() {
        return plataformaRepository.findAll();
    }

    // Retorna uma plataforma por ID
    public Optional<Plataforma> getPlataformaById(Long id) {
        return plataformaRepository.findById(id);
    }

    // Salva ou atualiza uma plataforma
    public Plataforma savePlataforma(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    // Deleta uma plataforma por ID
    public void deletePlataforma(Long id) {
        plataformaRepository.deleteById(id);
    }
}
