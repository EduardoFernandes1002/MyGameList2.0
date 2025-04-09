package com.mygamelist.backend.distribuidora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistribuidoraService {

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    // Retorna todos os usuários
    public List<Distribuidora> getAllDistribuidoras() {
        return distribuidoraRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Distribuidora> getDistribuidoraById(Long id) {
        return distribuidoraRepository.findById(id);
    }

    // Salva ou atualiza um usuário
    public Distribuidora saveDistribuidora(Distribuidora distribuidora) {
        return distribuidoraRepository.save(distribuidora);
    }

    // Deleta um usuário por ID
    public void deleteDistribuidora(Long id) {
        distribuidoraRepository.deleteById(id);
    }
}