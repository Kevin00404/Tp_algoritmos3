package org.example;

import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

public class Entrenador {
    Pokebola pokebola;
    Pokemon pokemonActual;
    public Entrenador(Pokebola pokebola) {
        this.pokebola = pokebola;
        this.pokemonActual = null;
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

    public void atacar(Entrenador entrenador, Integer habilidad){
        pokemonActual.atacar(entrenador.getPokemonActual(), habilidad);
    }
    public Pokemon getPokemon(){
        return pokemonActual;
    }

    public boolean estaVivo(){
        if (pokemonActual == null) {
            return false;
        }
        return true;
    }

}
