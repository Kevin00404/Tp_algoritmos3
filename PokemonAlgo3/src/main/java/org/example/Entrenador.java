package org.example;

import javafx.scene.control.ProgressBar;
import org.example.Log.Log;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.EfectosPasivosComando;
import org.example.items.Items;
import org.example.items.Mochila;
import org.example.pokebola.Pokebola;
import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
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
        System.out.println(this.pokemonActual.getNombre());
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

    public boolean usarItemEnMochila(int objetoElegido, String pokemonElegido) throws InterruptedException {
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


    /*public void pokemonSiguePeleando() {
        if (pokemonActual.estaDebilitado()){
            Log.getLog().log(pokemonActual.getNombre() + " fue debilitado ");
            cambiarPokemonActual();
        }
    }*/
  
    public ArrayList<String> listaPokemones() {
        return pokebola.mostrarPokemones();
    }

    public HashMap<String,Double> diccionario_Pokemon_vidaMax(){
        HashMap<String,Double> dicc_nombre_vida= new HashMap<String,Double>();

        ArrayList<String> listaPokemones = listaPokemones();
        dicc_nombre_vida.put(listaPokemones.get(0), pokebola.obtenerPokemon(listaPokemones.get(0)).vida());
        dicc_nombre_vida.put(listaPokemones.get(1), pokebola.obtenerPokemon(listaPokemones.get(1)).vida());
        dicc_nombre_vida.put(listaPokemones.get(2), pokebola.obtenerPokemon(listaPokemones.get(2)).vida());
        dicc_nombre_vida.put(listaPokemones.get(3), pokebola.obtenerPokemon(listaPokemones.get(3)).vida());
        dicc_nombre_vida.put(listaPokemones.get(4), pokebola.obtenerPokemon(listaPokemones.get(4)).vida());
        dicc_nombre_vida.put(listaPokemones.get(5), pokebola.obtenerPokemon(listaPokemones.get(5)).vida());

        return dicc_nombre_vida;
    }


    public Mochila getMochila() {
        return mochila;
    }

    public Pokebola getPokemones() {
        return pokebola;
    }
}
