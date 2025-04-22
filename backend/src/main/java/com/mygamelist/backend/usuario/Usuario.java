package com.mygamelist.backend.usuario;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mygamelist.backend.permissao.Permissao;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nm_username")
    private String nomeUsuario;

    @Column(name = "nm_apelido")
    private String apelidoUsuario;

    @Column(name = "ds_email")
    private String emailUsuario;

    @Column(name = "ds_senha")
    private String senhaUsuario;

    @Column(name = "nr_telefone")
    private String telefoneUsuario;

    @ManyToOne
    @JoinColumn(name = "id_permissao", referencedColumnName = "id_permissao", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Permissao permissao;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getApelidoUsuario() {
        return apelidoUsuario;
    }

    public void setApelidoUsuario(String apelidoUsuario) {
        this.apelidoUsuario = apelidoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

}