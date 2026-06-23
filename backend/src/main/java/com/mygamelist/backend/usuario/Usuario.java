package com.mygamelist.backend.usuario;

import java.time.LocalDate;
import java.util.List;

import com.mygamelist.backend.jogoAdicionado.JogoAdicionado;
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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
