package com.mygamelist.backend.jogoAdicionado;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@RequiredArgsConstructor
public class JogoAdicionadoId implements Serializable {
    private Long listas;
    private Long usuario;
    private Long jogos;

    public JogoAdicionadoId(Long listas, Long usuario, Long jogos) {
        this.listas = listas;
        this.usuario = usuario;
        this.jogos = jogos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JogoAdicionadoId)) return false;
        JogoAdicionadoId that = (JogoAdicionadoId) o;
        return Objects.equals(listas, that.listas) &&
               Objects.equals(usuario, that.usuario) &&
               Objects.equals(jogos, that.jogos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listas, usuario, jogos);
    }
}
