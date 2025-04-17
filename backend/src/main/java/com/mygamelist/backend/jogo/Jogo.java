package com.mygamelist.backend.jogo;

import com.mygamelist.backend.desenvolvedora.Desenvolvedora;
import com.mygamelist.backend.distribuidora.Distribuidora;

import jakarta.persistence.*;

@Entity
@Table(name = "jogo")
public class Jogo {
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
    private String dataLancamentoJogo;

    @ManyToOne
    @JoinColumn(name = "id_desenvolvedora", referencedColumnName = "id_desenvolvedora", nullable = false)
    private Desenvolvedora desenvolvedora;

    @ManyToOne
    @JoinColumn(name = "id_distribuidora", referencedColumnName = "id_distribuidora", nullable = false)
    private Distribuidora distribuidora;

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

    public String getDataLancamentoJogo() {
        return dataLancamentoJogo;
    }

    public void setDataLancamentoJogo(String dataLancamentoJogo) {
        this.dataLancamentoJogo = dataLancamentoJogo;
    }


}
