package com.mygamelist.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_plataforma")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plataforma")
    private Long id;

    @Column(name = "nm_plataforma", nullable = false, unique = true, length = 100)
    private String nome;

    // Getters e Setters
}