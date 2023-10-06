package com.ingesoft.bicicletas.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    Long id;

    String login;
    String password;

    String nombre;

    @OneToMany(mappedBy = "usuario")
    List<Bicicleta> bicicletas;

}
