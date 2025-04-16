package com.mygamelist.backend.permissao;


import jakarta.persistence.*;

@Entity
@Table(name = "permissao")
public class Permissao {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao")
    private Long id;

    @Column(name = "nm_permissao")
    private String permissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        
    }

    public String getName() {
        return permissao;
    }

    public void setName(String name) {
        this.permissao = name;
    }
}
