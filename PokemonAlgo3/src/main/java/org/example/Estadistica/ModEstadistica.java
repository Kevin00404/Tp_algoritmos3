package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;
import org.example.Turno.Turno;

public abstract class ModEstadistica implements ModificacionEstadistica{
    @Override
    public abstract void modificarEstadistica(Estadisticas estadisticas);



    @Override
    public abstract boolean danina();
}
