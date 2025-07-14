package com.mygamelist.backend.usuario;

import java.time.LocalDate;
import java.util.List;

import com.mygamelist.backend.lista.JogoAdicionado;
import com.mygamelist.backend.permissao.Permissao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

    @Column(name = "ds_senha", unique = false)
    private String senhaUsuario;

    @Column(name = "nr_telefone", nullable = true)
    private String telefoneUsuario;

    @Column(name = "dt_nascimento", nullable = true)
    private LocalDate dataNascimentoUsuario;

    @ManyToOne // Define o relacionamento de muitos-para-um entre usuários e permissões. Cada usuário possui uma única permissão.
    @JoinColumn(name = "id_permissao", referencedColumnName = "id_permissao", nullable = false)
    private Permissao permissao;

    @OneToMany(mappedBy = "usuario") // Lista de jogos associados ao usuário. Relacionamento um-para-muitos.
    private List<JogoAdicionado> jogosAdicionados;

    public Long getIdUsuario() {
        return idUsuario;
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

    public LocalDate getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(LocalDate dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    // Retorna o nome da permissão associada ao usuário. Retorna null se a permissão for nula.
   public String getNomePermissao() { 
    return permissao != null ? permissao.getNomePermissao() : null;
} 

}