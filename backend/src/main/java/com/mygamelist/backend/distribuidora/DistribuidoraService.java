package com.mygamelist.backend.distribuidora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistribuidoraService {

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public List<Distribuidora> getDistribuidoras() {
        return distribuidoraRepository.findAll();
    }

    public Distribuidora getDistribuidoraById(Long idDistribuidora) {
        return distribuidoraRepository.findById(idDistribuidora).orElse(null);
    }
}
