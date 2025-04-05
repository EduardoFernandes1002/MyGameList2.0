package com.mygamelist.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jogo_adicionado")
public class JogoAdicionado {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_lista", nullable = false)
    private Lista lista;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    // Getters e Setters
}