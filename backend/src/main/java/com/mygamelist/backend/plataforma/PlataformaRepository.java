package com.mygamelist.backend.plataforma;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mygamelist.backend.jogo.Jogo;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {

    @Query("SELECT j FROM Plataforma p JOIN p.jogos j WHERE p.nomePlataforma = :nomePlataforma")
    List<Jogo> findJogosByPlataforma(@Param("nomePlataforma") String nomePlataforma);

    List<Plataforma> findByNomePlataforma(String nomePlataforma);

}
