package com.mygamelist.backend.intermediarias.generojogo;

import com.mygamelist.backend.genero.Genero;
import com.mygamelist.backend.jogo.Jogo;

import jakarta.persistence.*;

@Entity
@Table(name = "genero_do_jogo")
public class GeneroDoJogo {
    
    @EmbeddedId
    private GeneroDoJogoId id;

    @ManyToOne
    @MapsId("idJogo")
    @JoinColumn(name = "id_jogo")
    private Jogo idJogo;

    @ManyToOne
    @MapsId("idGenero")
    @JoinColumn(name = "id_genero")
    private Genero idGenero;

    
    public GeneroDoJogoId getId() {
        return id;
    }

    public void setId(GeneroDoJogoId id) {
        this.id = id;
    }
}
