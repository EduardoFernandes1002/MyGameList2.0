package com.mygamelist.backend.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "Select u.nm_username, u.nm_apelido, p.nm_permissao From Usuario as u " + 
                "INNER Join permissao as p" + 
                "On p.id_permissao = u.id_permissao" + 
                "Where p.id_permissao = 1;", nativeQuery = true)
    List<Object[]> findByAdministrator();
}