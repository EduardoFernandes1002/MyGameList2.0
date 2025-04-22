package com.mygamelist.backend.genero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mygamelist.backend.jogo.Jogo;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    /*
     * Todos jogos de um unico Genero pelo id do Genero,
     * sendo equivalente ao Select nativo abaixo:
     * SELECT g.jogos FROM genero g WHERE g.id_genero = gj.id_genero
     */
    @Query("SELECT j FROM Genero g JOIN g.jogos j WHERE g.idGenero = :idGenero")
    List<Jogo> findJogosByGeneros(@Param("idGenero") Long idGenero);

}
