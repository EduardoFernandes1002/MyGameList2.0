package com.mygamelist.backend.jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Query("SELECT j FROM Jogo j WHERE j.nomeJogo = :nomeJogo")
    Jogo findByNomeJogo(String nomeJogo);

}
