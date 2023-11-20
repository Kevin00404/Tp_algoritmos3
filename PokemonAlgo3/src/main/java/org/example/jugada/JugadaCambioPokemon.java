package org.example.jugada;

import org.example.Entrenador;
import org.example.pokemon.Pokemon;

public class JugadaCambioPokemon extends Jugada {
    public JugadaCambioPokemon(Entrenador jugador, Entrenador oponente) {
        super(jugador, oponente);
    }

    @Override
    public boolean jugar() {
        System.out.println("x: cancelar");
        jugador.cambiarPokemonActual("");
        return true;
    }
}
