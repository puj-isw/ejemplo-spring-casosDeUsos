package com.ingesoft.bicicletas.logic;

public class ExcepcionBicicletas extends Exception {
 
    public ExcepcionBicicletas() {
        super();
    }
    
    public ExcepcionBicicletas(String message) {
        super(message);
    }

    public ExcepcionBicicletas(String message, Throwable cause) {
        super(message, cause);
    }    

}
