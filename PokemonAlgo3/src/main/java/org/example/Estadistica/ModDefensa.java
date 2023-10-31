package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;

public class ModDefensa extends ModEstadistica {

    public ModDefensa(Double varDefensa) {
            this.varEstadistica=varDefensa;
            this.nombre = "defensa";
        }
        @Override
    public void modificarEstadistica(Estadisticas estadisticas) {
            estadisticas.variarDefensa(varEstadistica);
        }

}
