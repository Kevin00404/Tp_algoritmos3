package org.example.Turno;

import org.example.comando.Comando;

public interface EventoManejable {

    boolean ejecutarEvento();

    void agregarComando(Comando comando);

    void setearProblema(Comando comando);

}
