package org.example;

import org.example.Elemento.*;
import org.example.pokemon.Pokemon;

public class Main {
    //Pruebas:

    public static void main(String[] args) {
        Pokemon pokemon_de_fuego = new Pokemon("Charmander", new Fuego(), "Nacio en un volcan(?");
        Pokemon pokemon_de_agua = new Pokemon("Squirtle", new Agua(), "Nacio en un Lago(?");

        Pokemon pokemon_de_tierra=new Pokemon("Tierron", new Tierra(),"Nacio de una planta(?");
        Pokemon pokjemon_electrico=new Pokemon("Pikachu", new Electrico(),"Nacio de los rayos(?");
        Stringg as="ol";


        //pokemon_de_fuego.atacar(pokemon_de_agua, );
    }
}