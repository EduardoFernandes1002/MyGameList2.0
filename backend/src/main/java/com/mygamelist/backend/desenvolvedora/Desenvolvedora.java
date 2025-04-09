package com.mygamelist.backend.desenvolvedora;

import jakarta.persistence.*;

@Entity
@Table(name = "t_desenvolvedora")
public class Desenvolvedora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desenvolvedora")
    private Long id;

    @Column(name = "nm_desenvolvedora", nullable = false, unique = true, length = 100)
    private String nome;

    // Getters e Setters
}