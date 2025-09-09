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

    /*
     * Todos jogos de um unico Genero pelo nome do Genero,
     */
    public List<?> findJogosByGenero(String nomeGenero) {
        return generoRepository.findJogosByGeneros(nomeGenero);
    }


}
