package com.mygamelist.backend.genero;

import java.util.List;

import com.mygamelist.backend.intermediarias.generojogo.GeneroDoJogo;

import jakarta.persistence.*;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;

    @Column(name = "nm_genero")
    private String nomeGenero;

    @OneToMany(mappedBy = "idGenero")
    private List<GeneroDoJogo> generosDoJogo;

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public List<GeneroDoJogo> getGenerosDoJogo() {
        return generosDoJogo;
    }
}
