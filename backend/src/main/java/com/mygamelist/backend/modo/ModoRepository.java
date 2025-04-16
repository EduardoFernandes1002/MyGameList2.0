package com.mygamelist.backend.modo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoRepository extends JpaRepository<Modo, Long> {

    

}
