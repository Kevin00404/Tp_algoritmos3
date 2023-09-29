package org.example;

import org.example.pokemon.Pokemon;

public class Entrenador {
    Pokebola pokebola;
    Pokemon pokemonActual;
    public Entrenador(Pokebola pokebola) {
        this.pokebola = pokebola;
    }

    public Entrenador() {
    }

    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public void setPokemonActual(Pokemon pokemonActual) {
        this.pokemonActual = pokemonActual;
    }

    public Pokebola getPokebola() {
        return pokebola;
    }

}
