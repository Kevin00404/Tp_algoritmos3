package org.example.comando;

import org.example.Estadistica.ModEstadistica;
import org.example.pokemon.Pokemon;

public class ComandoAplicacionPocionBufeo extends Comando {
    ModEstadistica modEstadistica;
    Pokemon pokemon;
    public ComandoAplicacionPocionBufeo(ModEstadistica modEstadistica, Pokemon pokemon) {
        this.modEstadistica = modEstadistica;
        this.pokemon = pokemon;
    }

    @Override
    protected void ejecutarEsteComando() {
        pokemon.bufearEstadisticas(modEstadistica);
    }
}
