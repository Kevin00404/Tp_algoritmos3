package org.example.Estadistica;

import org.example.Ataque;

public class modAtaque implements Estadistica{
    Double varAtaque;
    public modAtaque(Double varAtaque) {
        this.varAtaque=varAtaque;
    }

    @Override
    public void modificarEstadistica(Ataque ataque) {
        ataque.setVarAtaque(varAtaque);
    }
}

