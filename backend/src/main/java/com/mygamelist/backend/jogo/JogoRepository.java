package com.mygamelist.backend.jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    @Query("""
    SELECT new com.mygamelist.backend.jogo.JogoDetalhesDTO(
                j.idJogo, 
                j.nomeJogo, 
                j.sinopseJogo, 
                j.imagemJogo, 
                j.dataLancamentoJogo, 
                d.nomeDesenvolvedora, 
                di.nomeDistribuidora
            )
            FROM Jogo j
                INNER JOIN j.desenvolvedora d
                INNER JOIN j.distribuidora di
            WHERE j.idJogo = :idJogo
        """)
    JogoDetalhesDTO findJogoDetalhes(@Param("idJogo") Long idJogo);

}
