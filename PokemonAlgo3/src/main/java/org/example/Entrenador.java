package org.example;

public class Entrenador {
    List<Pokemon> pokebola;
    Pokemon pokemonActual;


    public Entrenador(List<Pokemon> pokebola, Pokemon pokemonActual) {
        this.pokebola = pokebola;
        this.pokemonActual = pokemonActual;
    }

    public Entrenador(List<Pokemon> pokebola) {
        this.pokebola = pokebola;
    }

    //esto se cambia. Se hace una clase de pokebola.
    public Entrenador(Pokemon pokemon1,Pokemon pokemon2,Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6) {
        for
        this.pokebola = pokebola;
    }


    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public void setPokemonActual(Pokemon pokemonActual) {
        this.pokemonActual = pokemonActual;
    }



}

