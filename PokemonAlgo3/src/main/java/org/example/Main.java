package org.example;

import org.example.Elemento.*;
import org.example.habilidad.HabilidadAtaque;
import org.example.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        /*HabilidadAtaque habilidadFuegoFuerte = new HabilidadAtaque(25, new Fuego(), 50.0);
        HabilidadAtaque habilidadFuegoDebil = new HabilidadAtaque(25, new Fuego(), 2.0);
        HabilidadAtaque habilidadAguaFuerte = new HabilidadAtaque(25, new Agua(), 50.0);
        HabilidadAtaque habilidadAguaDebil = new HabilidadAtaque(25, new Agua(), 2.0);
        Pokemon pokemon_de_fuego = new Pokemon("Charmander", new Fuego(), "Nacio en un volcan(?", habilidadFuegoFuerte, habilidadFuegoDebil, habilidadAguaFuerte, habilidadAguaDebil);
        Pokemon pokemon_de_agua = new Pokemon("Squirtle", new Agua(), "Nacio en un Lago(?", habilidadFuegoFuerte, habilidadFuegoDebil, habilidadAguaFuerte, habilidadAguaDebil);
        Pokemon pokemon_de_electricidad = new Pokemon ("pikachu", new Electrico(),"hijo de los rayos", habilidadFuegoFuerte, habilidadFuegoDebil, habilidadAguaFuerte, habilidadAguaDebil);

        pokemon_de_electricidad.atacar(pokemon_de_fuego, 1);
        pokemon_de_electricidad.atacar(pokemon_de_agua, 1);
        pokemon_de_electricidad.atacar(pokemon_de_fuego, 3);
        pokemon_de_agua.atacar(pokemon_de_fuego, 3);
        pokemon_de_agua.atacar(pokemon_de_agua, 3);
        pokemon_de_agua.atacar(pokemon_de_agua, 4);*/
        Juego juego = new Juego();
    }
}