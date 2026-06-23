package com.mygamelist.backend.distribuidora;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "distribuidora")
public class Distribuidora {

    // Atributos da tabela:
    @Id
    @Column(name = "id_distribuidora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistribuidora;

    @Column(name = "nm_distribuidora")
    private String nomeDistribuidora;

}
