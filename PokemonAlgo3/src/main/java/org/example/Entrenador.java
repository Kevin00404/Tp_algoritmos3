package org.example;

import org.example.Log.Log;
import org.example.comando.Comando;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
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

    public void cambiarPokemonActual(){
        Log.getLog().log(this.nombre + " elegi tu pokemon: ");
        this.pokemonActual = pokebola.cambiarPokemon();
    }

    public void jugarTurno(Entrenador oponente){
        actualizarPokemonActual();
    }

    private void actualizarPokemonActual() {
        if (pokemonActual == null){
            cambiarPokemonActual();
        }
    }

    public Pokebola getPokebola() {
        return pokebola;
    }

    public void atacar(Entrenador entrenador, Integer habilidad){
        pokemonActual.aplicar(entrenador.getPokemonActual(), habilidad);
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

    public boolean usarItemEnMochila(int objetoElegido, String pokemonElegido) {
        return mochila.usarItem(pokebola.obtenerPokemon(pokemonElegido), objetoElegido);
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

    public Comando mostrarPokemonEnBatalla() {
        return pokemonActual.datosDeBatalla();
    }

    public void aplicarEfectos() {
        pokemonActual.aplicarEfectos();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void capturarPokemon(Pokemon pokemon){
        pokebola.agregarPokemon(pokemon);
    }

    public void mostrarHabilidadesDePokemon() {
        this.pokemonActual.mostrarHabilidades();
    }
}
