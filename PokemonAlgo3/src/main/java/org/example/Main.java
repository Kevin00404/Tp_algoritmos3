package org.example;

import org.example.Elemento.*;
import org.example.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Pokemon pokemon_de_fuego = new Pokemon("Charmander", new Fuego(), "Nacio en un volcan(?");
        Pokemon pokemon_de_agua = new Pokemon("Squirtle", new Agua(), "Nacio en un Lago(?");
        Pokemon pikachu=new Pokemon ("pikachu",new Agua(),"hijo de los rayos");

        //pokemon_de_fuego.atacar(pokemon_de_agua, );
    }
}