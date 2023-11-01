package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Granizo extends Climas{

    public Granizo(){
        this.setNombre("Granizo");
        this.setElementosConVentaja("Hielo");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente) {
        super.danioPasivo(jugador, oponente);
    }

    @Override
    public Double ventajaDeClima(Double danioHipotetico, Estadisticas estadisticasPkmn) {
        return super.ventajaDeClima(danioHipotetico, estadisticasPkmn);
    }
}
