package com.mygamelist.backend.plataforma;

import java.util.List;

import com.mygamelist.backend.jogo.Jogo;

import jakarta.persistence.*;

@Entity
@Table(name = "plataforma")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plataforma")
    private Long idPlataforma;

    @Column(name = "nm_plataforma")
    private String nomePlataforma;

    // Atributos que representam o relacionamento com outras tabelas Muitos para
    // Muitos:
    @ManyToMany(mappedBy = "plataformas")
    private List<Jogo> jogos;

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public void setNomePlataforma(String nomePlataforma) {
        this.nomePlataforma = nomePlataforma;
    }

}
