package com.mygamelist.backend.lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.List;
import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    // Retorna um lista por ID
    public Optional<Lista> getListaById(Long id) {
        return listaRepository.findById(id);
    }

    // Salva ou atualiza uma lista
    public Lista saveLista(Lista lista) {
        return listaRepository.save(lista);
    }
}