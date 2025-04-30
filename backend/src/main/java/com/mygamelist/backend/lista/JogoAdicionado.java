package com.mygamelist.backend.lista;



import com.mygamelist.backend.jogo.Jogo;
import com.mygamelist.backend.usuario.Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "jogo_adicionado")
public class JogoAdicionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_lista")
    private Lista listas;

    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogo jogos;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
