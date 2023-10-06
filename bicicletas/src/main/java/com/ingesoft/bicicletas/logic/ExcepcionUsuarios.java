package com.ingesoft.bicicletas.logic;

public class ExcepcionUsuarios extends Exception {

    public ExcepcionUsuarios() {
        super();
    }
    
    public ExcepcionUsuarios(String message) {
        super(message);
    }

    public ExcepcionUsuarios(String message, Throwable cause) {
        super(message, cause);
    }

}
