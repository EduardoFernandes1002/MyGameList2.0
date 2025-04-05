package com.mygamelist.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "tx_comentario", columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "nr_usuario_nota", nullable = false, precision = 3, scale = 1)
    private Double nota;

    @Column(name = "dt_comentario")
    @Temporal(TemporalType.DATE)
    private Date dataComentario;

    @Column(name = "dt_envio", nullable = false, length = 45)
    private String dataEnvio;

    // Getters e Setters
}