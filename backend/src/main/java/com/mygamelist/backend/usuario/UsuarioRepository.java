package com.mygamelist.backend.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Busca um usuário pelo nome de login (nm_usuario)
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}