package org.example.jugada;

import org.example.Entrenador;
import org.example.Log.Log;

import java.util.Scanner;

public class JugadaItem extends Jugada {
    Scanner scanner;
    public JugadaItem(Entrenador jugador, Entrenador oponente) {
        super(jugador, oponente);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean jugar() throws InterruptedException {
        /*jugador.verMochila();
        int objetoElegido = scanner.nextInt();
        if (valorObjetoValido(objetoElegido)){

            jugador.verEquipo();
            String pokemonElegido = scanner.next();
            return jugador.usarItemEnMochila(objetoElegido , pokemonElegido);
            //jugador.aplicarEfectos();
        }*/
        return false;
    }

    private boolean valorObjetoValido(Integer num){
        return (num>0);
    }
}
