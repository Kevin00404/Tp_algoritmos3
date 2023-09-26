package org.example;

import org.example.pokemon.Pokemon;

import java.util.Dictionary;
import java.util.Hashtable;

public class Pokebola {
//    List<Pokemon> pokebola;
//
//    public Pokebola(List<Pokemon> pokebola) {
//        this.pokebola = pokebola;
//    }
//
    Dictionary<String, Pokemon> pokemones;

    public Pokebola() {
        pokemones = new Hashtable<String, Pokemon>();
    }

//    final int POKEMONES_POR_POKEBOLA=6;
//
    public void agregarPokemon(Pokemon pokemon){
        pokemones.put(pokemon.getNombre(), pokemon);
    }

//    public void quitarPokemon(Pokemon pokemon){
//        if pokebola.//contiene a pokemon//
//
//    }
//
//    public void cantidad(){
//        System.out.println(POKEMONES_POR_POKEBOLA);
//    }
//

}
