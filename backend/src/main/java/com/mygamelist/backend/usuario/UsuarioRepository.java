package com.mygamelist.backend.usuario;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca usuários que possuem uma permissão específica, retornando um mapa com o usuário e o nome da permissão.
    @Query("SELECT new map( u as usuario, u.permissao.nomePermissao as PermissaoDoUsuario) FROM Usuario u WHERE u.permissao.nomePermissao = :nomePermissao")
    List<Map<String, Usuario>> findUsuarioByPermissao(String nomePermissao);

    // Busca todos os usuários, retornando um mapa com cada usuário e o nome da permissão associada.
    @Query("SELECT new map( u as usuario, u.permissao.nomePermissao as PermissaoDoUsuario) FROM Usuario u")
    List<Map<String, Usuario>> findAllUsuariosByPermissao();

    // Retorna um usuário pelo nome de usuário.
    Usuario findByNomeUsuario(String nomeUsuario);

    // Retorna um usuário pelo e-mail.
    Usuario findByEmailUsuario(String emailUsuario);

}