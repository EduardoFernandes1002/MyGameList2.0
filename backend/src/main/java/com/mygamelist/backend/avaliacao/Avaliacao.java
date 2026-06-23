package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidade que representa uma avaliação de um jogo feita por um usuário.
 * Cada avaliação pode conter nota, comentário, data de envio e está associada a
 * um jogo e um usuário.
 */

@Getter
@Setter
@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    /**
     * Identificador único da avaliação (chave primária).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    /**
     * Jogo avaliado (relacionamento N:1).
     */
    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    /**
     * Usuário que fez a avaliação (relacionamento N:1).
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Comentário textual do usuário sobre o jogo.
     */
    @Column(name = "tx_comentario", nullable = true)
    private String comentarioUsuario;

    /**
     * Nota atribuída pelo usuário ao jogo.
     */
    @Column(name = "nr_usuario_nota", nullable = false)
    private BigDecimal notaUsuario;

    /**
     * Data em que o comentário foi enviado.
     */
    @Column(name = "dt_comentario", nullable = true)
    private LocalDate dataComentario;

    /**
     * Data em que a nota foi enviada.
     */
    @Column(name = "dt_envio", nullable = false)
    private LocalDate dataEnvioNota;
}
