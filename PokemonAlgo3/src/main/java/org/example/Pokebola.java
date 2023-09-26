package org.example;

import org.example.pokemon.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pokebola {
    Map<String, Pokemon> dicc;


    final int POKEMONES_POR_POKEBOLA = 6;

    public Pokebola() {
        dicc = new HashMap<>();
    }

    //Agrega pokemon a pokebola. Si ya tiene la cantidad maxima de pokemones admitidos imprime error.
    public void agregarPokemon(Pokemon pokemon) {
        if (dicc.size() >= POKEMONES_POR_POKEBOLA) {
            System.out.println("Error:Pokebola ya contiene " + POKEMONES_POR_POKEBOLA + " pokemones.");
            return;
        }
        dicc.put(pokemon.getNombre(), pokemon);
    }

    public void quitarPokemon(Pokemon pokemon) {
        if (!dicc.containsKey(pokemon.getNombre())) {
            System.out.println("El pokemon " + pokemon.getNombre() + " no esta en pokebola.");
            return;
        }
        dicc.remove(pokemon.getNombre());
    }

    public Pokemon cambiarPokemon() {
        String nombrePokemonElegido = "";
        while (!dicc.containsKey(nombrePokemonElegido)) {
            Scanner nombreVariableScaneado = new Scanner(System.in);

            // Solicitar al usuario que ingrese un nombre de las opciones.
            System.out.print("Pokemones disponibles: ");

            for (String nombrePokemon : dicc.keySet()) {
                System.out.println(nombrePokemon);
            }

            nombrePokemonElegido = nombreVariableScaneado.next();

            if (!dicc.containsKey(nombrePokemonElegido)) {
                {
                    System.out.println("No ingresaste el nombre correcto del pokemon. Vuelve a seleccionar.");
                }
            }
        }
        return dicc.get(nombrePokemonElegido);
    }



    public void cantidadPokemones(){
        System.out.println(dicc.size());
    }
}
