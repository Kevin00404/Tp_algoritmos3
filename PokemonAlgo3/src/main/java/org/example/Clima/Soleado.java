package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Soleado extends Climas {

    public Soleado(){

        this.setNombre("Soleado");
        this.setElementosConVentaja("Fuego");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente, String mensaje) {}

    @Override
    public Double ventajaDeClima(Double danioHipotetico , Estadisticas estadisticas) {
        return super.ventajaDeClima(danioHipotetico, estadisticas);
    }
}
