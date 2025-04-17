package com.mygamelist.backend.desenvolvedora;

import jakarta.persistence.*;


@Entity
@Table(name = "desenvolvedora")
public class Desenvolvedora {
    
    @Id
    @Column(name = "id_desenvolvedora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesenvolvedora;

    @Column(name = "nm_desenvolvedora")
    private String nomeDesenvolvedora;

    public Long getIdDesenvolvedora() {
        return idDesenvolvedora;
    }

    public void setIdDesenvolvedora(Long idDesenvolvedora) {
        this.idDesenvolvedora = idDesenvolvedora;
    }

    public String getNomeDesenvolvedora() {
        return nomeDesenvolvedora;
    }

    public void setNomeDesenvolvedora(String nomeDesenvolvedora) {
        this.nomeDesenvolvedora = nomeDesenvolvedora;
    }
}
