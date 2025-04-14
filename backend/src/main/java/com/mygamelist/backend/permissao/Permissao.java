package com.mygamelist.backend.Permissao;


import com.mygamelist.backend.Usuario.Usuario;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao")
    private Long id;

    @Column(name = "nm_permissao")
    private String permissao;

    @OneToMany(mappedBy = "permissao")
    private List<Usuario> usuarios;

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
