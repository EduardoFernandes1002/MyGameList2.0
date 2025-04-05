package com.mygamelist.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_lista")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Long id;

    @Column(name = "nr_jogos", nullable = false)
    private Integer numeroJogos;

    @Column(name = "nm_lista", nullable = false, unique = true, length = 45)
    private String nome;

    // Getters e Setters
}