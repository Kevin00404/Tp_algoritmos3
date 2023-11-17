package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

public class Lluvia extends Climas {

    public Lluvia(){
        this.setNombre("Lluvia");
        this.setElementosConVentaja("Agua");
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente, String mensaje) {}
}
