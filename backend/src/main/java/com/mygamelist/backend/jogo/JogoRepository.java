package com.mygamelist.backend.jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    // Método para buscar um jogo pelo nome
    @Query("SELECT j FROM Jogo j WHERE j.nomeJogo = :nomeJogo")
    Jogo findByNomeJogo(String nomeJogo);

    List<Jogo> findByIdJogo(Long idJogo);

    @Modifying
    @Query("UPDATE Jogo j SET j.totalNotaJogo = :nota WHERE j.idJogo = :idJogo")
    void updateNotaJogo(@Param("idJogo") Long idJogo, @Param("nota") BigDecimal totalNotaJogo);

}
