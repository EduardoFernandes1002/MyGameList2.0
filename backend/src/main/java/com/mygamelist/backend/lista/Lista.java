package com.mygamelist.backend.lista;

import java.util.List;

import com.mygamelist.backend.jogoAdicionado.JogoAdicionado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
