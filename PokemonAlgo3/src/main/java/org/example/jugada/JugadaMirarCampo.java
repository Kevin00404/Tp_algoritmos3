package org.example.jugada;

import org.example.Clima.ManejoDeClima;
import org.example.Entrenador;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;

public class JugadaMirarCampo extends Jugada {
    public JugadaMirarCampo(Entrenador jugador, Entrenador oponente) {
        super(jugador, oponente);
    }

    @Override
    public boolean jugar() {
        Comando mostrarInfoJugador = jugador.mostrarPokemonEnBatalla();
        Comando mostrarInfoOponente = oponente.mostrarPokemonEnBatalla();
        System.out.println("Clima del terreno: "+ ManejoDeClima.getTerreno().getClima());
        mostrarInfoOponente.concatComands(mostrarInfoJugador);
        Eventos.getEventos().agregarComando(mostrarInfoOponente);
        return false;
    }
}
