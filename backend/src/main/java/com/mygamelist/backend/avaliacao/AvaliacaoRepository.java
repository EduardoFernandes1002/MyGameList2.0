package com.mygamelist.backend.avaliacao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    // Método para buscar comentários de um jogo específico
    @Query("SELECT a FROM Avaliacao a WHERE a.jogo.idJogo = :idJogo")
    List<Avaliacao> findByJogoId(@Param("idJogo") Long idJogo);

    @Query("SELECT a FROM Avaliacao a WHERE a.jogo.idJogo = :idJogo")
    Page<Avaliacao> findByJogoId(@Param("idJogo") Long idJogo, Pageable pageable);
}
