package com.mygamelist.backend.intermediarias.generojogo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class GeneroDoJogoId implements Serializable{

    private Long idJogo;
    private Long idGenero;

    public GeneroDoJogoId() {
    }
    public GeneroDoJogoId(Long idJogo, Long idGenero) {
        this.idJogo = idJogo;
        this.idGenero = idGenero;

    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GeneroDoJogoId that = (GeneroDoJogoId) obj;
        return Objects.equals(idJogo, that.idJogo) && 
        Objects.equals(idGenero, that.idGenero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogo, idGenero);
    }

}
