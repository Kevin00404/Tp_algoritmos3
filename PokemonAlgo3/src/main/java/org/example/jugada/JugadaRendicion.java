package org.example.jugada;

import org.example.Entrenador;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.RendirseComando;

public class JugadaRendicion extends Jugada {
    public JugadaRendicion(Entrenador jugador, Entrenador oponente) {
        super(jugador, oponente);
    }

    @Override
    public boolean jugar() {
        Comando rendirse = new RendirseComando(jugador);
        Comando mensajeRendicion = new ComandoMensaje("jugador " + jugador.getNroEntrenador() + " se ha rendido. " + "jugador " + oponente.getNroEntrenador() + " gana la batalla.");
        mensajeRendicion.concatComands(rendirse);
        Eventos.getEventos().agregarComando(mensajeRendicion);
        return true;
    }
}
