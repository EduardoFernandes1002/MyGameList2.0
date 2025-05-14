package com.mygamelist.backend.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    // Método para buscar comentários de um jogo específico com paginação
    @Query("SELECT a FROM Avaliacao a WHERE a.jogo.nomeJogo = :nomeJogo")
    Page<Avaliacao> findByJogoNome(@Param("nomeJogo") String nomeJogo, Pageable pageable);
}
