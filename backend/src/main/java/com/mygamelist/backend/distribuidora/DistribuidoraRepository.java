package com.mygamelist.backend.distribuidora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Long> {

}
