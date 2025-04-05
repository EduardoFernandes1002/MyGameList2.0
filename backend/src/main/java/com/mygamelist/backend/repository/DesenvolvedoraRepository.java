package com.mygamelist.backend.repository;

import com.mygamelist.backend.model.Desenvolvedora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long> {
}