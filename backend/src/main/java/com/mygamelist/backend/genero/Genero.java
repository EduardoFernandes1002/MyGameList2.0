package com.mygamelist.backend.genero;

import jakarta.persistence.*;

@Entity
@Table(name = "t_genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long id;

    @Column(name = "nm_genero", nullable = false, unique = true, length = 100)
    private String nome;

    // Getters e Setters
}