package com.mygamelist.backend.genero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mygamelist.backend.jogo.Jogo;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    @Query("SELECT j FROM Genero g INNER JOIN g.jogos j WHERE g.nomeGenero = :nomeGenero")
    List<Jogo> findJogosByGeneros(@Param("nomeGenero") String nomeGenero);

    List<Genero> findByNomeGenero(String nomeGenero);
    
}
