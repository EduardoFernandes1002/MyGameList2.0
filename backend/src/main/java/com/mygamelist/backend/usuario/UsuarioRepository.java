package com.mygamelist.backend.usuario;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT new map( u as usuario, u.permissao.nomePermissao as PermissaoDoUsuario) FROM Usuario u WHERE u.permissao.nomePermissao = :nomePermissao")
    List<Map<String, Usuario>> findUsuarioByPermissao (String nomePermissao);

    @Query("SELECT new map( u as usuario, u.permissao.nomePermissao as PermissaoDoUsuario) FROM Usuario u")
    List<Map<String, Usuario>> findAllUsuariosByPermissao();

    Usuario findByNomeUsuario(String nomeUsuario);

    Usuario findByEmailUsuario(String emailUsuario);


    Optional<Usuario> findByEmailUsuarioOrNomeUsuario(String emailUsuario, String nomeUsuario);

}