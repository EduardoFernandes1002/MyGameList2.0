package com.mygamelist.backend.repository;

import com.mygamelist.backend.model.Modo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoRepository extends JpaRepository<Modo, Long> {
}