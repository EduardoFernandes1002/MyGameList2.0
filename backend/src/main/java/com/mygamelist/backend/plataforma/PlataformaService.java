package com.mygamelist.backend.plataforma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    public List<Plataforma> getPlataformas() {
        return plataformaRepository.findAll();
    }

    public Plataforma getPlataformaById(Long idPlataforma) {
        return plataformaRepository.findById(idPlataforma).orElse(null);
    }
}
