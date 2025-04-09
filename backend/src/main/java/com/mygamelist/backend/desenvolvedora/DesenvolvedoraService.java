package com.mygamelist.backend.desenvolvedora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedoraService {

    @Autowired
    private DesenvolvedoraRepository desenvolvedoraRepository;

    // Retorna todos os usuários
    public List<Desenvolvedora> getAllDesenvolvedoras() {
        return desenvolvedoraRepository.findAll();
    }

    // Retorna um usuário por ID
    public Optional<Desenvolvedora> getDesenvolvedoraById(Long id) {
        return desenvolvedoraRepository.findById(id);
    }

    // Salva ou atualiza um usuário
    public Desenvolvedora saveDesenvolvedora(Desenvolvedora desenvolvedora) {
        return desenvolvedoraRepository.save(desenvolvedora);
    }

    // Deleta um usuário por ID
    public void deleteDesenvolvedora(Long id) {
        desenvolvedoraRepository.deleteById(id);
    }
}