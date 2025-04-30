package com.mygamelist.backend.lista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public List<Lista> getListas() {
        return listaRepository.findAll();
    }

    public Lista getListaById(Long idLista) {
        return listaRepository.findById(idLista).orElse(null);
    }

    public List<?> getJogosAdicionados(Long idLista, Long idUsuario) {
        return listaRepository.findJogosAdicionados(idLista, idUsuario);
    }
}
