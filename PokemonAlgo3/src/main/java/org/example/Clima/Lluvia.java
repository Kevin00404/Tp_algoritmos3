package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Lluvia extends Climas {

    public Lluvia(){
        this.setNombre("Lluvia");
        this.setElementosConVentaja("Agua");
    }

    @Override
    public Double ventajaDeClima(Double danioHipotetico, Estadisticas estadisticasPkmn) {
        return super.ventajaDeClima(danioHipotetico, estadisticasPkmn);
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente) {}
}
