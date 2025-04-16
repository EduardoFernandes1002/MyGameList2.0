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


    public Long getId() {
        return idPermissao;
    }

    public void setId(Long idPermissao) {
        this.idPermissao = idPermissao;
        
    }

    public String getName() {
        return nomePermissao;
    }

    public void setName(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }
}
