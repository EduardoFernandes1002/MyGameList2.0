package com.mygamelist.backend.lista;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mygamelist.backend.jogo.Jogo;



@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {

    @Query("SELECT j FROM JogoAdicionado ja JOIN ja.jogos j WHERE ja.listas.idLista = :idLista AND ja.usuario.idUsuario = :idUsuario ORDER BY j.nomeJogo")
    List<Jogo> findJogosAdicionados(@Param("idLista") Long idLista, @Param("idUsuario") Long idUsuario);
}
