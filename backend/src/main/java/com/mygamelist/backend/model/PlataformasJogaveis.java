package com.mygamelist.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plataformas_jogaveis")
public class PlataformasJogaveis {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_plataforma", nullable = false)
    private Plataforma plataforma;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    // Getters e Setters
}