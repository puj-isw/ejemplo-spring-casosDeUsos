package com.ingesoft.bicicletas.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.bicicletas.domain.Usuario;
import java.util.List;


@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {

    // el crea automáticamente
    //  - save
    //  - findAll
    //  - findById
    
    List<Usuario> findByLogin(String login);

}
