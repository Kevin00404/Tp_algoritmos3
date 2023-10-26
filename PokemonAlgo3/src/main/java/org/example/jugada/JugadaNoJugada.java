package org.example.jugada;

import org.example.Entrenador;
import org.example.Log.Log;

public class JugadaNoJugada extends Jugada{
    public JugadaNoJugada(Entrenador jugador, Entrenador oponente){
        super(jugador, oponente);
    }
    @Override
    public boolean jugar() {
        Log.getLog().log("Opción no válida, vuelva a seleccionar");
        return false;
    }
}
