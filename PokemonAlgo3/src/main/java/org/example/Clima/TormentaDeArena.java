package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class TormentaDeArena extends Climas{

    public TormentaDeArena(){
        this.setNombre("Tormenta de Arena");
        this.setElementosConVentaja("Tierra");
        this.setElementosConVentaja("Roca");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente, String mensaje) {
        super.danioPasivo(jugador, oponente, mensaje);
    }

    @Override
    public Double ventajaDeClima(Double danioHipotetico, Estadisticas estadisticasPkmn) {
        return super.ventajaDeClima(danioHipotetico, estadisticasPkmn);
    }
}
