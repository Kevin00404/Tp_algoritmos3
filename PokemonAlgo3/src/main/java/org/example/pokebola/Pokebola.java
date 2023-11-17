package org.example.pokebola;

import org.example.Log.Log;
import org.example.pokemon.Pokemon;

import java.util.*;

public class Pokebola {
    Map<String, Pokemon> dicc;
    Integer cantidadPokemones;

    public Pokebola(Integer cantidadPokemones) {
        dicc = new HashMap<>();
        this.cantidadPokemones=cantidadPokemones;
    }

    //Agrega pokemon a pokebola. Si ya tiene la cantidad maxima de pokemones admitidos imprime error.
    public void agregarPokemon(Pokemon pokemon) {
        if (dicc.size() >= this.cantidadPokemones) {
            Log.getLog().log("Error:Pokebola ya contiene " + this.cantidadPokemones + " pokemones.");
            return;
        }
        dicc.put(pokemon.getNombre(), pokemon);
    }

    public Pokemon cambiarPokemon() {
        String nombrePokemonElegido = "";
        while (!dicc.containsKey(nombrePokemonElegido)) {
            Scanner nombreVariableScaneado = new Scanner(System.in);

            mostrarPokemones();

            nombrePokemonElegido = nombreVariableScaneado.next();

            if(nombrePokemonElegido.equals("cancelar")){
                return null;
            }
            if (!dicc.containsKey(nombrePokemonElegido)) {
                {
                    Log.getLog().log("No ingresaste el nombre correcto del pokemon. Vuelve a seleccionar.");
                }
            } else if (!dicc.get(nombrePokemonElegido).chequeoDeVida()) {
                nombrePokemonElegido = "";
                Log.getLog().log("El pokemon esta muerto, elija otro");
            }
        }
        return dicc.get(nombrePokemonElegido);
    }

    public void mostrarPokemones(){
        // Solicitar al usuario que ingrese un nombre de las opciones.
        Log.getLog().log("Pokemones disponibles: \n");


        Set<String> claves = dicc.keySet();

        // Crear un iterador para las claves
        Iterator<String> iterator = claves.iterator();

        while (iterator.hasNext()) {
            String clave = iterator.next();
            Pokemon pokemon = dicc.get(clave);
            Log.getLog().log("Nombre: " + clave + " |Vida: " + String.format("%.2f", pokemon.vida()));
        }
        Log.getLog().log("Cancelar");
    }
    public Pokemon obtenerPokemon(String pokemonSeleccionado){
        return dicc.get(pokemonSeleccionado);
    }

    public Integer cantidadPokemones(){
        return dicc.size();
    }

    public Integer pokemonesDebilitados(){
        Integer cantidadDeDebilitados = 0;
        Set<String> claves = dicc.keySet();
        Iterator<String> iterator = claves.iterator();
        while (iterator.hasNext()) {
            String clave = iterator.next();
            if (dicc.get(clave).estaDebilitado()){
                cantidadDeDebilitados++;
            }
        }
        return cantidadDeDebilitados;
    }

    public void debilitarEquipo() {
        Set<String> claves = dicc.keySet();
        Iterator<String> iterator = claves.iterator();
        while (iterator.hasNext()) {
            String clave = iterator.next();
            dicc.get(clave).debilitar();
        }
    }
    public Pokemon setPokemonInicial(){
        return dicc.values().iterator().next();
    }


    public boolean murieronTodos(){
        return (pokemonesDebilitados() == 6);
    }
}
