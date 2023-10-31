package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;

public class ModAtaque extends ModEstadistica implements ModificacionEstadistica {
    public ModAtaque(Double varAtaque) {
        this.varEstadistica=varAtaque;
        this.nombre = "ataque";
    }

    @Override
    public void modificarEstadistica(Estadisticas estadisticas) {
        estadisticas.variarAtaque(varEstadistica);
    }

}

