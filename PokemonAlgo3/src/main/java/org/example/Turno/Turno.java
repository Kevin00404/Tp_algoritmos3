package org.example.Turno;

import org.example.comando.Comando;
import org.example.comando.ComandoManejable;
import org.example.comando.TerminarComando;
import org.example.jugada.TurnoManejable;

import java.util.ArrayList;

public class Turno implements TurnoManejable {
    private ComandoManejable comando;
    private ArrayList<ComandoManejable> historial;
    private static Turno turno;

    private Turno(){
        comando = new TerminarComando();
    }

    public static Turno getTurno(){
        if(turno == null){
            return new Turno();
        }
        return turno;
    }
    public void pasarTurno(){
        comando.ejecutar();
    }

    public void cambiarTurno(){
        historial.add(comando);
        comando = new TerminarComando();
    }

    public void agregarComando(Comando comandoNuevo){
        comandoNuevo.setNextComando(comando);
        comando = comandoNuevo;
    }


}
