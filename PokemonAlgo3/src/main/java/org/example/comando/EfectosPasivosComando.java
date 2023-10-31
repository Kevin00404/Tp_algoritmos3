package org.example.comando;

import org.example.pokemon.Pokemon;

public class EfectosPasivosComando extends Comando {
    Pokemon pokemon;
    public EfectosPasivosComando(Pokemon pokemonActual) {
        pokemon = pokemonActual;
    }

    @Override
    protected void ejecutarEsteComando() {
        pokemon.aplicarPasivos();
    }
}
