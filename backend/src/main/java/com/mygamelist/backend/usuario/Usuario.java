package com.mygamelist.backend.usuario;

import jakarta.persistence.*;
import java.util.Date;

import com.mygamelist.backend.permissao.Permissao;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_permissao", nullable = false)
    private Permissao permissao;

    @Column(name = "nm_username", nullable = false, unique = true, length = 45)
    private String username;

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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}