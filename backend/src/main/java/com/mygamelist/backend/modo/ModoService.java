package com.mygamelist.backend.modo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModoService {

    @Autowired
    private ModoRepository modoRepository;

    public List<Modo> getAllModos() {
        return modoRepository.findAll();
    }

    public Optional<Modo> getModoById(Long id) {
        return modoRepository.findById(id);
    }

    public Modo saveModo(Modo modo) {
        return modoRepository.save(modo);
    }

    public void deleteModo(Long id) {
        modoRepository.deleteById(id);
    }
}