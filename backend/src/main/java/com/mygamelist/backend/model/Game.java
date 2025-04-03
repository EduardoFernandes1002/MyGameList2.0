package com.mygamelist.backend.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJogo; // Mapeia o campo id_Jogo

    @Column(length = 205, nullable = false)
    private String nomeJogo; // Mapeia o campo nm_Jogo

    @Column(columnDefinition = "TEXT")
    private String sinopse; // Mapeia o campo ds_Sinopse

    @Column(length = 200)
    private String imagem; // Mapeia o campo ds_Imagem

    private LocalDate dataLancamento; // Mapeia o campo dt_Jogo

    // Getters e Setters
    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}