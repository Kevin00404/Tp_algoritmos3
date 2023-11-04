package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Niebla extends Climas {
    public Niebla(){
        this.setNombre("Niebla");
        this.setElementosConVentaja("Fantasma");
        this.setElementosConVentaja("Psiquico");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente, String mensaje) {}

}
