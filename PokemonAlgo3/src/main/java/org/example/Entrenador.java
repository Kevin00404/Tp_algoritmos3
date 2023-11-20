package org.example;

import org.example.Log.Log;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.EfectosPasivosComando;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

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

    public void setPokemonActual(Pokemon pokemon){
        this.pokemonActual=pokemon;
    }

    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public void cambiarPokemonActual(String pokemon){
        Log.getLog().log(this.nombre + " elegi tu pokemon: ");
        this.pokemonActual = pokebola.cambiarPokemon(pokemon);
    }

    public boolean murio(){
        return pokebola.murieronTodos();
    }

    public void actualizarPokemonActual() {
        if (pokemonActual == null){
            cambiarPokemonActual("");
        }
    }

    public void atacar(Entrenador entrenador, Integer habilidad){
        pokemonActual.aplicar(entrenador.getPokemonActual(), habilidad);
    }
    public Pokemon getPokemon(){
        return pokemonActual;
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

    public String getNombre() {
        return this.nombre;
    }

    public void capturarPokemon(Pokemon pokemon){
        pokebola.agregarPokemon(pokemon);
    }

    public void mostrarHabilidadesDePokemon() {
        this.pokemonActual.mostrarHabilidades();
    }

    public void efectosPasivos() {
        Comando efectosPasivos = new EfectosPasivosComando(pokemonActual);
        Eventos.getEventos().agregarComando(efectosPasivos);
    }

    public ArrayList<String> listaPokemones() {
        return pokebola.mostrarPokemones();
    }
}
