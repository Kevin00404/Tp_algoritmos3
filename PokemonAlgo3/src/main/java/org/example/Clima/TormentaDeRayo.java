package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class TormentaDeRayo extends Climas{

    public TormentaDeRayo(){
        this.setNombre("Tormenta de rayos");
        this.setElementosConVentaja("Electrico");
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
