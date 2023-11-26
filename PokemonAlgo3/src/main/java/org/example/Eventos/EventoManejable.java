package org.example.Eventos;

import org.example.comando.Comando;

public interface EventoManejable {

    boolean ejecutarEvento() throws InterruptedException;

    void agregarComando(Comando comando);

    void setearProblema(Comando comando);

}
