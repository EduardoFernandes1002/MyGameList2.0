package com.mygamelist.backend.genero;

import com.mygamelist.backend.jogo.Jogo;

import jakarta.persistence.*;

@Entity
@Table(name = "t_genero_do_jogo")
public class GeneroDoJogo {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    // Getters e Setters
}