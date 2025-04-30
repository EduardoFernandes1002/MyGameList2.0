package com.mygamelist.backend.lista;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "lista")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Long idLista;

    @Column(name = "nm_lista")
    private String nomeLista;

    @OneToMany(mappedBy = "listas")
    private List<JogoAdicionado> jogosAdicionados;

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }
}
