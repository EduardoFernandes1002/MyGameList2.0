package com.mygamelist.backend.avaliacao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
