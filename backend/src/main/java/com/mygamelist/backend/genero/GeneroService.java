package com.mygamelist.backend.genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    // Retorna todos os usuários
    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Genero> getGeneroById(Long id) {
        return generoRepository.findById(id);
    }

    // Salva ou atualiza um usuário
    public Genero saveGenero(Genero usuario) {
        return generoRepository.save(usuario);
    }

    // Deleta um usuário por ID
    public void deleteGenero(Long id) {
        generoRepository.deleteById(id);
    }
}