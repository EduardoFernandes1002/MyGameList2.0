package com.mygamelist.backend.modo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModoService {
    
    @Autowired
    private ModoRepository modoRepository;

    public List<Modo> getModos() {
        return modoRepository.findAll();
    }

    public Modo getModoById(Long idModo) {
        return modoRepository.findById(idModo).orElse(null);
    }
    

}
