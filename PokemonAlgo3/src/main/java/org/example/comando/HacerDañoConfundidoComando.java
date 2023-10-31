package org.example.comando;

import org.example.Estadisticas.Estadisticas;

public class HacerDañoConfundidoComando extends Comando{
    Estadisticas estadisticas;
    public HacerDañoConfundidoComando(Estadisticas estadisticas){

    }
    @Override
    protected void ejecutarEsteComando() {
        estadisticas.confundirse();
    }
}
