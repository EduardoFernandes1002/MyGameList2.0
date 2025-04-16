package com.mygamelist.backend.modo;

import jakarta.persistence.*;

@Entity
public class Modo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modo")
    private Long idModo;

    @Column(name = "nm_modo")
    private String nomeModo;


    public Long getIdModo() {
        return idModo;
    }

    public void setIdModo(Long idModo) {
        this.idModo = idModo;
    }

    public String getNomeModo() {
        return nomeModo;
    }
    public void setNomeModo(String nomeModo) {
        this.nomeModo = nomeModo;
    }
}
