package org.example.jugada;

import org.example.Entrenador;
import org.example.Log.Log;

import java.util.Scanner;

public class JugadaFactory {
    Entrenador jugador;
    Entrenador oponente;
    Scanner scanner;
    public JugadaFactory(Entrenador jugador, Entrenador oponente){
        this.jugador = jugador;
        this.oponente = oponente;
        this.scanner = new Scanner(System.in);
    }

    public Jugada inicializarJugada(){
        Log.getLog().log(jugador.getNroEntrenador() + ", es tu turno.");
        Log.getLog().log("Elige una opción:");
        Log.getLog().log("1. Atacar");
        Log.getLog().log("2. Usar Item");
        Log.getLog().log("3. Mostrar campo de batalla");
        Log.getLog().log("4. Cambiar Pokemon");
        Log.getLog().log("5. Rendirse");
        return jugadaElegida(scanner.nextInt());
    }
    public Jugada jugadaElegida(Integer num){
        switch (num){
            case 1: return new JugadaAtaque(jugador, oponente);
            case 2: return new JugadaItem(jugador, oponente);
            case 3: return new JugadaMirarCampo(jugador, oponente);
            case 4: return new JugadaCambioPokemon(jugador, oponente);
            case 5: return new JugadaRendicion(jugador, oponente);
            default: return new JugadaNoJugada(jugador, oponente);
        }
    }
}
