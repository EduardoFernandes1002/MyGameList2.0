package com.mygamelist.backend.desenvolvedora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesenvolvedoraService {

    @Autowired
    private DesenvolvedoraRepository desenvolvedoraRepository;

    public List<Desenvolvedora> getDesenvolvedoras() {
        return desenvolvedoraRepository.findAll();
    }

    public Desenvolvedora getDesenvolvedoraById(Long idDesenvolvedora) {
        return desenvolvedoraRepository.findById(idDesenvolvedora).orElse(null);
    }
}
