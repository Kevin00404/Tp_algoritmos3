package org.example;

import org.example.pokemon.Pokemon;

public class Pokebola {
    List<Pokemon> pokebola;

    public Pokebola(List<Pokemon> pokebola) {
        this.pokebola = pokebola;
    }

    final int POKEMONES_POR_POKEBOLA=6;

    public void agregarPokemon(Pokemon pokemon){
        if pokebola.lenght<POKEMONES_POR_POKEBOLA{
            this.pokebola.add(pokemon)
        }
        System.out.println("Error:Pokebola ya contiene "+POKEMONES_POR_POKEBOLA + " pokemones.");
    }
    public void quitarPokemon(Pokemon pokemon){
        if pokebola.//contiene a pokemon//

    }

    public void cantidad(){
        System.out.println(POKEMONES_POR_POKEBOLA);
    }


}
