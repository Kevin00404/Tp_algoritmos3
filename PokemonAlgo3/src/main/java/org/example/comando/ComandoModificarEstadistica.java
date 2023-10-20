package org.example.comando;

import org.example.Estadistica.ModEstadistica;
import org.example.Estadistica.ModificacionEstadistica;
import org.example.Estadisticas.Estadisticas;

public class ComandoModificarEstadistica extends Comando {
    ModEstadistica modificacionEstadistica;
    Estadisticas estadisticasDelPokemon;
    public ComandoModificarEstadistica(ModEstadistica modificacionEstadistica, Estadisticas estadisticas) {
        this.modificacionEstadistica = modificacionEstadistica;
        this.estadisticasDelPokemon = estadisticas;
    }

    @Override
    protected void ejecutarEsteComando() {
        this.modificacionEstadistica.modificarEstadistica(this.estadisticasDelPokemon);
    }
}
