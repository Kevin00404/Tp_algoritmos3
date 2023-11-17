package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public interface Clima {
    Double ventajaDeClima(Double danioHipotetico, Estadisticas estadisticasPkmn);

    void danioPasivo(Entrenador jugador, Entrenador oponente, String mensajeRecibido);
}
