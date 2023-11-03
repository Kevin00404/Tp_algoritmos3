package org.example.Eventos;

import org.example.comando.Comando;

public interface EventoManejable {

    boolean ejecutarEvento();

    void agregarComando(Comando comando);

    void setearProblema(Comando comando);

}
