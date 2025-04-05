package com.mygamelist.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_distribuidora")
public class Distribuidora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distribuidora")
    private Long id;

    @Column(name = "nm_distribuidora", nullable = false, unique = true, length = 100)
    private String nome;

    // Getters e Setters
}