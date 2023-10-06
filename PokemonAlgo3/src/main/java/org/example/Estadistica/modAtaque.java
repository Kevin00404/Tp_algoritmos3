package org.example.Estadistica;

import org.example.Ataque;

public class modAtaque implements Estadistica{
    String nombre;
    Double varAtaque;
    public modAtaque(Double varAtaque) {
        this.varAtaque=varAtaque;
        this.nombre = "ataque";
    }

    @Override
    public void modificarEstadistica(Ataque ataque) {
        ataque.setVarAtaque(varAtaque);
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

