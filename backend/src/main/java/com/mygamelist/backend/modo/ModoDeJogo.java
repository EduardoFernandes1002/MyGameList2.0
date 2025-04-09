package com.mygamelist.backend.modo;

import com.mygamelist.backend.jogo.Jogo;

import jakarta.persistence.*;

@Entity
@Table(name = "t_modo_de_jogo")
public class ModoDeJogo {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_modo", nullable = false)
    private Modo modo;

    // Getters e Setters
}