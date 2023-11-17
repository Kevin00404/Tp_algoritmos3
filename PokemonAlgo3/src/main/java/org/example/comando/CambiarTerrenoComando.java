package org.example.comando;

import org.example.Clima.Climas;
import org.example.Clima.ManejoDeClima;
import org.example.pokemon.Pokemon;

public class CambiarTerrenoComando extends Comando{

    Climas clima;
    Pokemon pokemonActual;

    public CambiarTerrenoComando(Pokemon pokemonActual, Climas nuevoClima){
        this.clima = nuevoClima;
        this.pokemonActual = pokemonActual;
    }
    @Override
    protected void ejecutarEsteComando() {
        if (!pokemonActual.estaDebilitado()){
            ManejoDeClima.getTerreno().cambiarClima(clima);
        }
    }
}
