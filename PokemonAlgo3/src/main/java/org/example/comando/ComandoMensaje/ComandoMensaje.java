package org.example.comando.ComandoMensaje;

import org.example.Log.Log;
import org.example.comando.Comando;

public abstract class ComandoMensaje extends Comando {
    @Override
    protected void ejecutarEsteComando() {
        Log log = Log.getLog();
        log.log(armarMensaje());
    }
    public abstract String armarMensaje();

}
