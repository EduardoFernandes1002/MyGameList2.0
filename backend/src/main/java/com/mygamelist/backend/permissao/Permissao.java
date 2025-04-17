package com.mygamelist.backend.permissao;


import jakarta.persistence.*;

@Entity
@Table(name = "permissao")
public class Permissao {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao")
    private Long idPermissao;

    @Column(name = "nm_permissao")
    private String nomePermissao;


    public Long getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Long idPermissao) {
        this.idPermissao = idPermissao;
        
    }

    public String getNomePermissao() {
        return nomePermissao;
    }

    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }
}
