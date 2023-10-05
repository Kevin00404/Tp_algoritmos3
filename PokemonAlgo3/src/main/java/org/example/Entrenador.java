package org.example;

import org.example.items.Mochila;
import org.example.pokemon.Pokemon;

public class Entrenador {
    Pokebola pokebola;
    Pokemon pokemonActual;
    Mochila mochila;
    Integer nroEntrenador;
    public Entrenador(Pokebola pokebola , Mochila mochila , Integer nroEntrenador) {
        this.pokebola = pokebola;
        this.pokemonActual = null;
        this.mochila = mochila;
        this.nroEntrenador = nroEntrenador;
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

    public boolean tienePokemonDisponible(){
        return pokebola.pokemonesDebilitados() < pokebola.cantidadPokemones();
    }

    public void usarItemEnMochila(int objetoElegido, Pokemon pokemon) {
        mochila.usarItem(pokemon,objetoElegido);
    }

    public void verMochila() {
        mochila.mostrarItems();
    }

    public void verEquipo() {
        pokebola.mostrarPokemones();
    }

    public Integer getNroEntrenador() {
        return nroEntrenador;
    }

    public void rendirse() {
        pokebola.debilitarEquipo();
    }

    public void mostrarPokemonEnBatalla() {
        pokemonActual.datosDeBatalla();
    }
}
