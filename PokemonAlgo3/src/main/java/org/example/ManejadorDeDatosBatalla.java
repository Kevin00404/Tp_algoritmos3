package org.example;

import org.example.Estadisticas.Estadisticas;
import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class ManejadorDeDatosBatalla {

    Entrenador entrenador_actual;
    Entrenador entrenador_contrario;
    Juego juego;
    Pokemon pokemon_entrenador_actual;
    Pokemon pokemon_entrenador_contrario;
    Integer jugador_actual_num;
    Integer jugador_contrario_num;
    Estadisticas estadisticas_pokemon_actual;

    Estadisticas estadisticas_pokemon_contrario;


    public ManejadorDeDatosBatalla(){
        jugador_actual_num = 1;
        jugador_contrario_num = 2;
    }

    public void ordenarData(Juego juego) {
        this.juego = juego;
        entrenador_actual = this.juego.getEntrenador(jugador_actual_num);
        entrenador_contrario = this.juego.getEntrenador(jugador_contrario_num);
        pokemon_entrenador_actual = entrenador_actual.getPokemonActual();
        pokemon_entrenador_contrario = entrenador_contrario.getPokemonActual();
        estadisticas_pokemon_actual = pokemon_entrenador_actual.getEstadisticas();
        estadisticas_pokemon_contrario = pokemon_entrenador_contrario.getEstadisticas();
    }

    public HashMap<String, Double> getVidaMaximaJugadorActual() {
        return entrenador_actual.diccionario_Pokemon_vidaMax();
    }

    public HashMap<String, Double> getVidaMaximaJugadorContrario() {
        return entrenador_contrario.diccionario_Pokemon_vidaMax();
    }

    public String getNombrePokemonAtacante() {
        return pokemon_entrenador_actual.getNombre();
    }

    public String getNombrePokemonContrario() {
        return pokemon_entrenador_contrario.getNombre();
    }

    public Double getVidaPokemonAtacante() {
        return estadisticas_pokemon_actual.getVida();
    }

    public Double getVidaPokemonContrario() {
        return estadisticas_pokemon_contrario.getVida();
    }

    public String getEntrenadorActualNombre() {
        return entrenador_actual.getNombre();
    }

    public String getEntrenadorContrarioNombre() {
        return entrenador_contrario.getNombre();
    }

    public ArrayList<String> getPokemonesPokebolaJugadorActual() {
        return entrenador_actual.listaPokemones();
    }

    public void cambiaPokemon(String nombreNuevoPokemonActual) {
        entrenador_actual.cambiarPokemonActual(nombreNuevoPokemonActual);
    }
}
