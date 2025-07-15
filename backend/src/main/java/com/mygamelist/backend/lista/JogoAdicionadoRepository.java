package com.mygamelist.backend.lista;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface JogoAdicionadoRepository extends JpaRepository<JogoAdicionado, JogoAdicionadoId> {

    void deleteByUsuario_IdUsuarioAndListas_IdListaAndJogos_IdJogo(Long idUsuario, Long idLista, Long idJogo);

}
