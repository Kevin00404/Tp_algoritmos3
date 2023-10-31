package org.example.comando;

import org.example.Log.Log;
import org.example.comando.Comando;
import org.example.comando.ComandoManejable;

public class ComandoMensaje extends Comando {
    private String mensaje;

    public ComandoMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    @Override
    protected void ejecutarEsteComando() {
        Log log = Log.getLog();
        log.log(mensaje);
    }

}
