package org.example.jugada;

import org.example.Entrenador;

import java.util.Scanner;

public abstract class Jugada implements JugadaI{
    Entrenador jugador;
    Entrenador oponente;
    public Jugada(Entrenador jugador, Entrenador oponente){
        this.jugador = jugador;
        this.oponente = oponente;
    }

    public abstract boolean jugar() throws InterruptedException;
}
