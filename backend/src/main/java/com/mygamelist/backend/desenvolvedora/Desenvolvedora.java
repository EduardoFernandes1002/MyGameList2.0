package com.mygamelist.backend.desenvolvedora;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "desenvolvedora")
public class Desenvolvedora {

    @Id
    @Column(name = "id_desenvolvedora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesenvolvedora;

    @Column(name = "nm_desenvolvedora")
    private String nomeDesenvolvedora;

}
