package com.mygamelist.backend.desenvolvedora;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long> {

    Optional<Desenvolvedora> findByNomeDesenvolvedora(String nome);
    
}
