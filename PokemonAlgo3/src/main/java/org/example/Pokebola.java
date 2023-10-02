package org.example;

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
            System.out.println("Error:Pokebola ya contiene " + this.cantidadPokemones + " pokemones.");
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

            _mostrarPokemones();

            nombrePokemonElegido = nombreVariableScaneado.next();

            if (!dicc.containsKey(nombrePokemonElegido)) {
                {
                    System.out.println("No ingresaste el nombre correcto del pokemon. Vuelve a seleccionar.");
                }
            }
        }
        return dicc.get(nombrePokemonElegido);
    }

    private void _mostrarPokemones(){
        // Solicitar al usuario que ingrese un nombre de las opciones.
        System.out.print("Pokemones disponibles: ");


        Set<String> claves = dicc.keySet();

        // Crear un iterador para las claves
        Iterator<String> iterator = claves.iterator();

        while (iterator.hasNext()) {
            String clave = iterator.next();
            Pokemon pokemon = dicc.get(clave);
            System.out.println("Nombre: " + clave + "|Vida: " + pokemon.getVida());
        }
    }

    public void mostratPokemones(){
        _mostrarPokemones();
    }

    public Pokemon setPokemonInicial(){
        return dicc.values().iterator().next();
    }

    public void cantidadPokemones(){
        System.out.println(dicc.size());
    }
}
