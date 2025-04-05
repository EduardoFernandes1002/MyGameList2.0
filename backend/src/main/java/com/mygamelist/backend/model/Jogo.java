package com.mygamelist.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogo")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_distribuidora", nullable = false)
    private Distribuidora distribuidora;

    @ManyToOne
    @JoinColumn(name = "id_desenvolvedora", nullable = false)
    private Desenvolvedora desenvolvedora;

    @Column(name = "nm_jogo", nullable = false, unique = true, length = 200)
    private String nome;

    @Column(name = "ds_sinopse", nullable = false, columnDefinition = "TEXT")
    private String sinopse;

    @Column(name = "dt_lancamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    @Column(name = "ds_imagem", nullable = false, length = 255)
    private String imagem;

    // Getters e Setters
}