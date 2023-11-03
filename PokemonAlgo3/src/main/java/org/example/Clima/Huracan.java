package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Huracan extends Climas{

    public Huracan(){
        setNombre("Huracan");
        setElementosConVentaja("Volador");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente, String mensaje) {}

    @Override
    public Double ventajaDeClima(Double danioHipotetico, Estadisticas estadisticasPkmn) {
        return super.ventajaDeClima(danioHipotetico, estadisticasPkmn);
    }
}
