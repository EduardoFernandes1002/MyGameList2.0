package com.mygamelist.backend.lista;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JogoAdicionadoRepository extends JpaRepository<JogoAdicionado, JogoAdicionadoId> {

    void deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(Long idUsuario, Long idLista, Long idJogo);

    List<JogoAdicionado> findByUsuario_IdUsuarioAndJogos_IdJogo(Long idUsuario, Long idJogo);

    boolean existsByUsuario_IdUsuarioAndJogos_IdJogoAndListas_IdLista(Long idUsuario, Long idJogo, Long idLista);

}
