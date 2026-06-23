package com.mygamelist.backend.jogo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.mygamelist.backend.desenvolvedora.Desenvolvedora;
import com.mygamelist.backend.distribuidora.Distribuidora;
import com.mygamelist.backend.genero.Genero;
import com.mygamelist.backend.jogoAdicionado.JogoAdicionado;
import com.mygamelist.backend.modo.Modo;
import com.mygamelist.backend.plataforma.Plataforma;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jogo")
public class Jogo {

    // Dados do jogo:
    // Atributos exclusivos do jogo:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogo;
    @Column(name = "nm_jogo")
    private String nomeJogo;
    @Column(name = "ds_sinopse")
    private String sinopseJogo;
    @Column(name = "ds_imagem")
    private String imagemJogo;
    @Column(name = "dt_lancamento")
    private LocalDate dataLancamentoJogo;
    @Column(name = "nr_total_nota")
    private BigDecimal totalNotaJogo;

    // Chaves estrangeiras de outras tabelas:
    @ManyToOne
    @JoinColumn(name = "id_desenvolvedora", referencedColumnName = "id_desenvolvedora", nullable = false)
    private Desenvolvedora desenvolvedora;
    @ManyToOne
    @JoinColumn(name = "id_distribuidora", referencedColumnName = "id_distribuidora", nullable = false)
    private Distribuidora distribuidora;

    @OneToMany(mappedBy = "jogos")
    private List<JogoAdicionado> jogosAdicionados;

    // Atributos que representam o relacionamento com outras tabelas Muitos para
    // Muitos:
    @ManyToMany
    @JoinTable(name = "genero_do_jogo", joinColumns = @JoinColumn(name = "id_jogo"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos;

    @ManyToMany
    @JoinTable(name = "modo_de_jogo", joinColumns = @JoinColumn(name = "id_jogo"), inverseJoinColumns = @JoinColumn(name = "id_modo"))
    private List<Modo> modos;

    @ManyToMany
    @JoinTable(name = "plataforma_de_jogo", joinColumns = @JoinColumn(name = "id_jogo"), inverseJoinColumns = @JoinColumn(name = "id_plataforma"))
    private List<Plataforma> plataformas;

}
