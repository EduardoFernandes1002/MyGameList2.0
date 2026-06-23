package com.mygamelist.backend.modo;

import java.util.List;

import com.mygamelist.backend.jogo.Jogo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "modo")
public class Modo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modo")
    private Long idModo;

    @Column(name = "nm_modo")
    private String nomeModo;

    // Atributos que representam o relacionamento com outras tabelas Muitos para
    // Muitos:
    @ManyToMany(mappedBy = "modos")
    private List<Jogo> jogos;

}
