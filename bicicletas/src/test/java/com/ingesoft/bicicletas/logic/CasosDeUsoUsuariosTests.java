package com.ingesoft.bicicletas.logic;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingesoft.bicicletas.data.RepositorioUsuarios;
import com.ingesoft.bicicletas.domain.Usuario;

@SpringBootTest
public class CasosDeUsoUsuariosTests {

    // SUT -- Subject under test
    @Autowired
    CasosDeUsoUsuarios casosDeUsoUsuarios;

    // Fixing -- Clases adicionales necesarias para la prueba
    @Autowired
    RepositorioUsuarios usuarios;


    // Arrange
    // -------
    @BeforeAll
    public static void prepararAmbienteParaTodaLaSuite() {
        System.out.println("Antes de todas las pruebas de la clase");
        System.out.println();
    }
    
    @BeforeEach
    public void prepararAmbienteDePruebas() {
        System.out.println("Antes de cada pruebas");
        System.out.println();

        usuarios.deleteAll();

        Usuario u = new Usuario();
        u.setLogin("jaime");
        u.setNombre("jaime");
        u.setPassword("jaime");
        usuarios.save(u);

    }

    // CU1: Registrar Usuario
    // ----------------------

    // Curso normal de eventos -- "caso feliz"
    @Test
    public void registrarUsuarioSinErrores() {

        try {

            // Arrange

            // Act
            casosDeUsoUsuarios.registrarUsuario(
                "juan", 
                "SoyElMejor", 
                "Juan El mejor");

            // Assert
            List<Usuario> usuariosConNombreJuan = usuarios.findByLogin("juan");
            if (usuariosConNombreJuan.size() == 0) {
                // mal !!
                fail("No se grabó el usuario");
            }

        } catch (ExcepcionUsuarios e) {

            // mal !!
            fail("Se generó error y no debería", e);
        }
    }

    // Curso alternativo -- 
    // (2) Cuando existe otro usuario con ese login
    @Test
    public void registrarUsuarioConLoginQueYaExiste() {

        try {

            // Arrange

            // Act
            casosDeUsoUsuarios.registrarUsuario("jaime", "jaime", "jaime");

            // Assert
            fail("Dejó grabar otro usuario con un login que ya existia");

        } catch (ExcepcionUsuarios e) {
            // ok !!
        }

    }

    // Curso alternativo -- 
    // (4) Cuando el password tiene menos de cinco letras
    @Test
    public void registrarUsuarioConPasswordDeMenosDe5Letras() {

        try {

            // Arrange

            // Act
            casosDeUsoUsuarios.registrarUsuario(
                "jorge", 
                "xx", 
                "jorge");

            // Assert
            fail("Dejó grabar el usuario con un contraseña de menos de 5 letras");

        }  catch(ExcepcionUsuarios e) {
            // ok !!
        }

    }


    // Clean Up
    // --------

    @AfterEach
    public void despuesDeLaPrueba() {
        System.out.println("Luego de cada prueba");
        System.out.println();
    }

    @AfterAll
    public static void despuesDeTodasLasPruebas() {
        System.out.println("Luego de todas las pruebas");
        System.out.println();
    }


}
