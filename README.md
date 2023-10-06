# Bicicletas: Ejemplo de implementación de casos de uso

> Implementación de un caso de uso utilizando Spring Boot.

Bicicletas es un pequeño software que permite registrar usuarios y bicicletas.

## Modelo de dominio

En el software,
- Un usuario tiene un login, un password y un nombre
- Cada Usuario tiene una colección de bicicletas
- Una bicicleta tiene una descripción

El siguiente diagrama de clases representa el modelo de dominio.


![](https://www.plantuml.com/plantuml/png/ROyn2iCm34Ltd-BZCU2XQwRGkLlf0HpR185Z1ScXG-dTQqfDMkWcFNXFQDBgfUvhDkQcknTYs9F5u1piO76cG26dwZ5YxhCQ4x9NHJSU1d2WEEB2PNalcHSgJRfMeG_Qcd9dYR-qy3fBEjYpnu_JV_8nQH3Q0d7vDgTKOllb1G00)

## Casos de Uso

En este ejemplo se consideran solo dos casos de uso:

1. Registrar un usuario nuevo
2. Registrar una bicicleta de un usuario

El siguiente diagrama representa los casos de uso

![](https://www.plantuml.com/plantuml/png/RSux3i9030JGtgSOfKz13e0Yw2cGSW1hOuB5aaLhcmPnTpuYqD1DCMyqlJbNZtEcB0U75rITZevHgoJNCXDnyb8nM73L0ZO4qONJYIV1HfEcBCw66m5XajW4pLucDQ_ySxkGQsbUVDYk_bU_OnZbunRHqPqeqBRhDrzIHzJBF3xlFm00)


## CU1: Registrar Usuario

**Guión** o curso normal de eventos:

1. Actor ingresa login
2. Sistema valida que no exista otro usuario con ese login
3. Actor ingresa password
4. Sistema valida que el password tenga más de cinco letras 
5. Actor ingresa nombre
6. Sistema registra el usuario

**Excepciones:**

- (2) Cuando existe otro usuario con ese login
    1. Sistema muestra un mensaje "Existe otro usuario con ese login"
    2. Sistema termina

- (4) Cuando el password tiene menos de cinco letras
    1. Sistema muestra un mensaje "El password tiene menos de cinco letras"
    2. Sistema termina.


## CU2: Registrar Bicicleta

**Guión** o curso normal de eventos

1. Actor ingresa el login del usuario
2. Sistema valida que exista un usuario con ese login
3. Actor ingresa el nombre de la bicicleta
4. Sistema valida que ese usuario no tenga otra bicicleta con el mismo nombre
5. Registramos la bicicleta para ese usuario

**Ecepciones:**

- (2) Sistema valida que exista un usuario con ese login
    1. Sistema muestra un mensaje "No existe un usuario con ese login"
    2. Sistema termina

- (4) Sistema valida que ese usuario no tenga otra bicicleta con el mismo nombre
    1. Sistema muestra un mensaje "ya existe otra bicicleta con el mismo nombre para ese usuario"
    2. Sistema termina


## Implementación en Spring

Algunas clases de interés

En `src/main/java`

| Clase                                              | Descripción                 |
|----------------------------------------------------|-----------------------------|
| com.ingesoft.bicicletas.domain.Usuario             | Entidad Usuario             |
| com.ingesoft.bicicletas.domain.Bicicleta           | Entidad Bicicleta           |
| com.ingesoft.bicicletas.data.RepositorioUsuarios   | Repositorio de Usuarios     |
| com.ingesoft.bicicletas.data.RepositorioBicicletas | Repositorio de Bicicletas   |
| com.ingesoft.bicicletas.logic.CasosDeUsoUsuarios   | Casos de Uso de Usuarios    | 
| com.ingesoft.bicicletas.logic.ExcepcionUsuarios    | Excepción de Usuarios       |
| com.ingesoft.bicicletas.logic.CasosDeUsoBicicletas | Casos de Uso de Bicicletas  |
| com.ingesoft.bicicletas.logic.ExcepcionBicicletas  | Excepción de Bicicletas     |

en `src/test/java`


| Clase                                                   | Descripción                            |
|---------------------------------------------------------|----------------------------------------|
| com.ingesoft.bicicletas.logic.CasosDeUsoUsuariosTests   | Pruebas de Casos de Uso de Usuarios    | 



## Ejecutando el ejemplo

1. Ubicarse en el directorio del proyecto

    ```
    cd bicicletas
    ```

2. Iniciar el servidor de bases de datos

    ```
    docker compose up -d
    ```

3. Compilar la aplicación

    ```
    mvn package -DskipTests
    ```

4. Ejecutar las pruebas

    ```
    mvn test
    ```