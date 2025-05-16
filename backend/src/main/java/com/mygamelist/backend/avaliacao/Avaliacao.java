package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "tx_comentario", nullable = true)
    private String comentarioUsuario;

    @Column(name = "nr_usuario_nota", nullable = false)
    private BigDecimal notaUsuario;

    @Column(name = "dt_comentario", nullable = true)
    private LocalDate dataEnvioComentario;

    @Column(name = "dt_envio", nullable = false)
    private LocalDate dataEnvioNota;

    // Getters e Setters
    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentarioUsuario() {
        return comentarioUsuario;
    }

    public void setComentarioUsuario(String comentarioUsuario) {
        this.comentarioUsuario = comentarioUsuario;
    }

    public BigDecimal getNotaUsuario() {
        return notaUsuario;
    }

    public void setNotaUsuario(BigDecimal notaUsuario) {
        this.notaUsuario = notaUsuario;
    }

    public LocalDate getDataComentario() {
        return dataEnvioComentario;
    }

    public void setDataComentario(LocalDate dataEnvioComentario) {
        this.dataEnvioComentario = dataEnvioComentario;
    }

    public LocalDate getDataEnvio() {
        return dataEnvioNota;
    }

    public void setDataEnvio(LocalDate dataEnvioNota) {
        this.dataEnvioNota = dataEnvioNota;
    }
}
