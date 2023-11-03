package org.example.comando;

import org.example.Entrenador;

public class RendirseComando extends Comando {
    Entrenador jugador;
    public RendirseComando(Entrenador jugador) {
        this.jugador = jugador;
    }

    @Override
    protected void ejecutarEsteComando() {
        jugador.rendirse();
    }
}
