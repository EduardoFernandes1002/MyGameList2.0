package com.mygamelist.backend.avaliacao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositório de acesso a dados para avaliações.
 * Permite operações CRUD e consultas customizadas.
 * Utilização do JPA facilitar a a persistência e recuperação de dados.
 */
@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    /**
     * Busca avaliações pelo id do jogo, com suporte a paginação.
     * 
     * @param idJogo   id do jogo
     * @param pageable informações de paginação
     * @return lista de avaliações
     */
    List<Avaliacao> findByJogo_IdJogo(Long idJogo, Pageable pageable);

    Avaliacao findByUsuario_IdUsuarioAndJogo_IdJogo(Long idUsuario, Long idJogo);

    List<Avaliacao> findAllByOrderByDataComentarioDesc(Pageable pageable);


    @Query("SELECT a.notaUsuario FROM Avaliacao a WHERE a.jogo.idJogo = :idJogo AND a.notaUsuario IS NOT NULL")
    List<BigDecimal> findNotasByJogo_IdJogo(Long idJogo);

}
