package com.mygamelist.backend.lista;

import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.usuario.Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "jogo_adicionado")
@IdClass(JogoAdicionadoId.class)
public class JogoAdicionado {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_lista")
    private Lista listas;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogo jogos;

    public Lista getListas() {
        return listas;
    }

    public void setListas(Lista listas) {
        this.listas = listas;
    }

    public Jogo getJogos() {
        return jogos;
    }

    public void setJogos(Jogo jogos) {
        this.jogos = jogos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
