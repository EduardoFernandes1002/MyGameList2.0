package com.mygamelist.backend.genero;

import java.util.List;

import com.mygamelist.backend.jogo.Jogo;

import jakarta.persistence.*;

@Entity
@Table(name = "genero")
public class Genero {

    // Dados da tabela:
    // Atributos que representam o mapeamento da tabela:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;

    @Column(name = "nm_genero")
    private String nomeGenero;

    // Atributos que representam o relacionamento com outras tabelas Muitos para
    // Muitos:
    @ManyToMany(mappedBy = "generos")
    private List<Jogo> jogos;

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

}
