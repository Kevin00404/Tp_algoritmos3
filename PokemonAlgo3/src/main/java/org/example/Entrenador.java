package org.example;

import org.example.items.Mochila;
import org.example.pokemon.Pokemon;

public class Entrenador {
    Pokebola pokebola;
    Pokemon pokemonActual;
    Mochila mochila;
    String nombre;
    public Entrenador(Pokebola pokebola , Mochila mochila , String nombre) {
        this.pokebola = pokebola;
        this.pokemonActual = null;
        this.mochila = mochila;
        this.nombre = nombre;
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

    public boolean atacar(Entrenador entrenador, Integer habilidad){
        return pokemonActual.atacar(entrenador.getPokemonActual(), habilidad);
    }
    public Pokemon getPokemon(){
        return pokemonActual;
    }

    public boolean pokemonEstaVivo(){
        return pokemonActual.chequeoDeVida();
    }

    public boolean tienePokemonDisponible(){
        return pokebola.pokemonesDebilitados() < pokebola.cantidadPokemones();
    }

    public boolean usarItemEnMochila(int objetoElegido, Pokemon pokemon) {
        return mochila.usarItem(pokemon,objetoElegido);
    }

    public void verMochila() {
        mochila.mostrarItems();
    }

    public void verEquipo() {
        pokebola.mostrarPokemones();
    }

    public String getNroEntrenador() {
        return nombre;
    }

    public void rendirse() {
        pokebola.debilitarEquipo();
    }

    public void mostrarPokemonEnBatalla() {
        pokemonActual.datosDeBatalla();
    }

    public void aplicarEfectos() {
        pokemonActual.aplicarEfectos();
    }

    public String getNombre() {
        return this.nombre;
    }
}
