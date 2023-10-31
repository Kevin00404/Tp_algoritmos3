package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;

public abstract class ModEstadistica implements ModificacionEstadistica{
    String nombre;
    Double varEstadistica;
    @Override
    public abstract void modificarEstadistica(Estadisticas estadisticas);

    public boolean danina() {
        return this.varEstadistica <= 0;
    }
    public String getNombre() {
        return nombre;
    }

}
