package com.mygamelist.backend.genero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getGeneros() {
        return generoRepository.findAll();
    }

    public Genero getGeneroById(Long idGenero) {
        return generoRepository.findById(idGenero).orElse(null);
    }

    /*
     * Todos jogos de um unico Genero pelo id do Genero,
     */
    public List<?> findJogosByGenero(Long idGenero) {
        return generoRepository.findJogosByGeneros(idGenero);
    }

}
