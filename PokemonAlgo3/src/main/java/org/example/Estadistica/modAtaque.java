package org.example.Estadistica;

import org.example.Turno.Turno;

public class modAtaque implements ModificacionEstadistica {
    String nombre;
    Double varAtaque;
    public modAtaque(Double varAtaque) {
        this.varAtaque=varAtaque;
        this.nombre = "ataque";
    }

    @Override
    public void modificarEstadistica(Turno turno) {
        turno.setVarAtaque(varAtaque);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean danina() {
        return this.varAtaque <= 0;
    }
}

