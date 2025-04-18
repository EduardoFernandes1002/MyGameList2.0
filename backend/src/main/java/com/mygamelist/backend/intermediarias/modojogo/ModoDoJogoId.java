package com.mygamelist.backend.intermediarias.modojogo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ModoDoJogoId {
    
    private Long idJogo;
    private Long idModo;

    public ModoDoJogoId() {
    }

    public ModoDoJogoId(Long idJogo, Long idModo) {
        this.idJogo = idJogo;
        this.idModo = idModo;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {    
        this.idJogo = idJogo;
    }

    public Long getIdModo() {
        return idModo;
    }

    public void setIdModo(Long idModo) {
        this.idModo = idModo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ModoDoJogoId that = (ModoDoJogoId) obj;
        return Objects.equals(idJogo, that.idJogo) &&
        Objects.equals(idModo, that.idModo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogo, idModo);
    }
}
