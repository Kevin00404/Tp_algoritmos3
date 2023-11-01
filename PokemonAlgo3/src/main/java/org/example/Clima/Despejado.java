package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Despejado extends Climas{

    public Despejado(){
        this.setNombre("Despejado");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente) {}

    @Override
    public Double ventajaDeClima(Double danioHipotetico , Estadisticas estadisticas) {
        return danioHipotetico;
    }
}
