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
    public boolean jugar() {
        Log.getLog().log("seleccione item: ");
        jugador.verMochila();
        int objetoElegido = scanner.nextInt();
        if (valorObjetoValido(objetoElegido)){
            Log.getLog().log("se ha Elegido: "+ objetoElegido);
            Log.getLog().log("seleccione pokemon: ");
            jugador.verEquipo();
            String pokemonElegido = scanner.next();
            return jugador.usarItemEnMochila(objetoElegido , pokemonElegido);
            //jugador.aplicarEfectos();
        }
        Log.getLog().log("Ese no es un objeto valido");
        return false;
    }

    private boolean valorObjetoValido(Integer num){
        return (num>0);
    }
}
