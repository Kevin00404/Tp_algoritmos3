package org.example.Eventos;

import org.example.comando.Comando;
import org.example.comando.ComandoManejable;

import java.util.ArrayList;

public class Eventos implements EventoManejable {
    private ComandoManejable comando;
    private ArrayList<ComandoManejable> historial;

    private Comando problema;
    private static Eventos eventos;

    private Eventos(){
        comando = null;
        problema = null;
        historial = new ArrayList<ComandoManejable>();
    }

    public static Eventos getEventos(){
        if(eventos == null){
            eventos = new Eventos();
            return eventos;
        }
        return eventos;
    }
    public boolean ejecutarEvento(){
        if(problema == null){
            if (comando != null){
                comando.ejecutar();
            }
            cambiarEvento();
            return true;
        }
        problema.ejecutar();
        resetearEvento();
        return false;
    }

    private void cambiarEvento(){
        historial.add(comando);
        comando = null;
    }

    public void resetearEvento(){
        problema = null;
        comando = null;
    }

    public void agregarComando(Comando comandoNuevo){
        comandoNuevo.concatComands(comando);
        comando = comandoNuevo;
    }

    @Override
    public void setearProblema(Comando comando) {
        comando.concatComands(problema);
        problema = comando;
    }





}
