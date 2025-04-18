package com.mygamelist.backend.intermediarias.modojogo;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.modo.Modo;

import jakarta.persistence.*;

@Entity
@Table(name = "modo_de_jogo")
public class ModoDoJogo {
    
    @EmbeddedId
    private ModoDoJogoId id;

    @ManyToOne
    @MapsId("idJogo")
    @JoinColumn(name = "id_jogo")
    private Jogo idJogo;

    @ManyToOne    
    @MapsId("idModo")
    @JoinColumn(name = "id_modo")
    private Modo idModo;

    public ModoDoJogoId getId() {
        return id;
    }

    public void setId(ModoDoJogoId id) {
        this.id = id;
    }
}
