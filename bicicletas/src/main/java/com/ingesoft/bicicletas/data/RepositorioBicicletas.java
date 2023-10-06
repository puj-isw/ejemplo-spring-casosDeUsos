package com.ingesoft.bicicletas.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.bicicletas.domain.Bicicleta;

@Repository
public interface RepositorioBicicletas extends JpaRepository<Bicicleta, Long> {
    
}
