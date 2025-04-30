package com.mygamelist.backend.jogo;

import java.time.LocalDate;
import java.util.List;

import com.mygamelist.backend.desenvolvedora.Desenvolvedora;
import com.mygamelist.backend.distribuidora.Distribuidora;
import com.mygamelist.backend.genero.Genero;
import com.mygamelist.backend.lista.JogoAdicionado;
import com.mygamelist.backend.modo.Modo;
import com.mygamelist.backend.plataforma.Plataforma;

import jakarta.persistence.*;

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
    @JoinTable(
        name = "genero_do_jogo", 
            joinColumns = @JoinColumn(name = "id_jogo"), 
            inverseJoinColumns = @JoinColumn(name = "id_genero")
        )
    private List<Genero> generos;

    @ManyToMany
    @JoinTable(
        name = "modo_de_jogo", 
            joinColumns = @JoinColumn(name = "id_jogo"), 
            inverseJoinColumns = @JoinColumn(name = "id_modo")
    )
    private List<Modo> modos;

    @ManyToMany
    @JoinTable(
        name = "plataforma_de_jogo", 
            joinColumns = @JoinColumn(name = "id_plataforma"), 
            inverseJoinColumns = @JoinColumn(name = "id_jogo")
    )
    private List<Plataforma> plataformas;

    // Getters e Setters:
    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getSinopseJogo() {
        return sinopseJogo;
    }

    public void setSinopseJogo(String sinopseJogo) {
        this.sinopseJogo = sinopseJogo;
    }

    public String getImagemJogo() {
        return imagemJogo;
    }

    public void setImagemJogo(String imagemJogo) {
        this.imagemJogo = imagemJogo;
    }

    public LocalDate getDataLancamentoJogo() {
        return dataLancamentoJogo;
    }

    public void setDataLancamentoJogo(LocalDate dataLancamentoJogo) {
        this.dataLancamentoJogo = dataLancamentoJogo;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Modo> getModos() {
        return modos;
    }

    public void setModos(List<Modo> modos) {
        this.modos = modos;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }

}
