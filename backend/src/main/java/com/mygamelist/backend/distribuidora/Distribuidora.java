package com.mygamelist.backend.distribuidora;

import jakarta.persistence.*;

@Entity
@Table(name = "distribuidora")
public class Distribuidora {
    
    @Id
    @Column(name = "id_distribuidora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistribuidora;

    @Column(name = "nm_distribuidora")
    private String nomeDistribuidora;

    public Long getIdDistribuidora() {
        return idDistribuidora;
    }

    public void setIdDistribuidora(Long idDistribuidora) {
        this.idDistribuidora = idDistribuidora;
    }

    public String getNomeDistribuidora() {
        return nomeDistribuidora;
    }

    public void setNomeDistribuidora(String nomeDistribuidora) {
        this.nomeDistribuidora = nomeDistribuidora;
    }
}
