package com.mygamelist.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_modo")
public class Modo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modo")
    private Long id;

    @Column(name = "nm_modo", nullable = false, unique = true, length = 100)
    private String nome;

    // Getters e Setters
}