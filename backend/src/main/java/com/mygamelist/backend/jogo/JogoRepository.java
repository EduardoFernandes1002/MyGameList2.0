package com.mygamelist.backend.jogo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Query("SELECT j FROM Jogo j WHERE j.nomeJogo = :nomeJogo")
    Jogo findByNomeJogo(String nomeJogo);

    @Query("SELECT new map(" +
        "j.nomeJogo as NomeJogo, " +
        "j.generos as Generos, " +
        "j.totalNotaJogo as Nota, "+
        "j.plataformas as Plataformas) "+
    "FROM Jogo j ORDER BY j.totalNotaJogo DESC LIMIT 5"
    )
    List<Map<String, Jogo>> findJogoResumidoByTopCinco();

}
