package org.example.jugada;

import org.example.Entrenador;
import org.example.Log.Log;

import java.util.Scanner;

public class JugadaAtaque extends Jugada {
    Scanner scanner;
    private int habilidadAUsar;

    public JugadaAtaque(Entrenador jugador, Entrenador oponente) {
        super(jugador, oponente);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean jugar() {
        //jugador.mostrarHabilidadesDePokemon();
        //int habilidadElegida = scanner.nextInt();
        jugador.atacar(oponente, this.habilidadAUsar);
        try { Thread.sleep(500); } catch(InterruptedException e) { throw new RuntimeException(e); }
        return true;
        /*Log.getLog().log("Esa habilidad no existe, tiene que ser un numero de estos (1 - 2 - 3 - 4)");
        return false;*/
    }

    private boolean habilidadValorValida(Integer num){
        return (num < 5 && num > 0);
    }


    public void setHabilidad(int i) {
        this.habilidadAUsar = i;
    }
}
