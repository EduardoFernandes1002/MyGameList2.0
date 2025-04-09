package com.mygamelist.backend.usuario;

import jakarta.persistence.*;
import java.util.Date;

import com.mygamelist.backend.permissao.Permissao;

@Entity
@Table(name = "t_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_permissao", nullable = false)
    private Permissao permissao;

    @Column(name = "nm_apelido", nullable = false, unique = true, length = 30)
    private String apelido;

    @Column(name = "ds_email", nullable = false, unique = true, length = 200)
    private String email;

    @Column(name = "ds_senha", nullable = false, length = 40)
    private String senha;

    @Column(name = "nr_telefone")
    private Integer telefone;

    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    // Getters e Setters
}