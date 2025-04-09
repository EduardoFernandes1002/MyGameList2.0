package com.mygamelist.backend.permissao;

import jakarta.persistence.*;

@Entity
@Table(name = "t_permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao")
    private Long id;

    @Column(name = "nm_permissao", nullable = false, unique = true, length = 45)
    private String nome;

    // Getters e Setters
}