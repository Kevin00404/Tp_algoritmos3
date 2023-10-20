package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;
import org.example.Turno.Turno;

public class ModDefensa extends ModEstadistica {
    String nombre;
    Double varDefensa;
    public ModDefensa(Double varDefensa) {
            this.varDefensa=varDefensa;
            this.nombre = "defensa";
        }

        @Override
    public void modificarEstadistica(Estadisticas estadisticas) {
            estadisticas.variarDefensa(varDefensa);
        }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean danina() {
        return this.varDefensa <= 0;
    }
}
