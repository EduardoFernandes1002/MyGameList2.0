package com.mygamelist.backend.lista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository  extends JpaRepository<Lista, Long> {
    
}
