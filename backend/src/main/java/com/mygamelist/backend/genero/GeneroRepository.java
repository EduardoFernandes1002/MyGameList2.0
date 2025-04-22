package com.mygamelist.backend.genero;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mygamelist.backend.jogo.Jogo;


@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {


    // Todos jogos de um genero
     @Query("SELECT g.jogos FROM Genero g WHERE g.idGenero = :idGenero")
    List<Jogo> findJogosByGeneros(@Param("idGenero") long idGenero);
    
}
