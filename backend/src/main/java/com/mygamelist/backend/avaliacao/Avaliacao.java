package com.mygamelist.backend.avaliacao;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.usuario.Usuario;
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

    @Column(name = "tx_comentario", length = 500, nullable = true)
    private String txComentario;

    @Column(name = "nr_usuario_nota", nullable = false)
    private int nrUsuarioNota;

    @Column(name = "dt_comentario", nullable = true)
    private LocalDate dtComentario;

    @Column(name = "dt_envio", nullable = false)
    private LocalDate dtEnvio;

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
        return txComentario;
    }

    public void setComentarioUsuario(String txComentario) {
        this.txComentario = txComentario;
    }

    public int getNotaUsuario() {
        return nrUsuarioNota;
    }

    public void setNotaUsuario(int nrUsuarioNota) {
        this.nrUsuarioNota = nrUsuarioNota;
    }

    public LocalDate getDataComentario() {
        return dtComentario;
    }

    public void setDataComentario(LocalDate dtComentario) {
        this.dtComentario = dtComentario;
    }

    public LocalDate getDataEnvio() {
        return dtEnvio;
    }

    public void setDataEnvio(LocalDate dtEnvio) {
        this.dtEnvio = dtEnvio;
    }
}
