package com.mygamelist.backend.modo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mygamelist.backend.jogo.Jogo;

@Repository
public interface ModoRepository extends JpaRepository<Modo, Long> {

    @Query("SELECT j FROM Modo m INNER JOIN m.jogos j WHERE m.nomeModo = :nomeModo")
    List<Jogo> findJogosByModo(@Param("nomeModo") String nomeModo);

    List<Modo> findByNomeModo(String nomeModo);

    List<Modo> findByNomeModoIn(List<String> nomes);

}
