package org.example.comando;

import org.example.Estadisticas.Estadisticas;
import org.example.estado.EstadoConfuso;
import org.example.pokemon.Pokemon;

public class DanioConfusoComando extends Comando{

    private Estadisticas estadisticas;
    public DanioConfusoComando(Estadisticas estadisticas){
        this.estadisticas = estadisticas;
    }

    @Override
    protected void ejecutarEsteComando() {
        estadisticas.confundir();
    }
}
