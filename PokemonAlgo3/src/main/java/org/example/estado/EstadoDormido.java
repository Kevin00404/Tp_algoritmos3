package org.example.estado;

import java.util.Random;

public class EstadoDormido extends Estado{
    public Integer contadorTurnosPerdidos;
    private boolean estaDormido;
    private Integer turnosDormido;

    public EstadoDormido() {
        contadorTurnosPerdidos = 0;
    }
    public void puedeDespertarse(){
        contadorTurnosPerdidos ++;
        double probabilidadDespertar = 0.25 + contadorTurnosPerdidos * 0.25;
        Random random = new Random();
        if (random.nextDouble() < probabilidadDespertar) {
            //System.out.println(nombre + " se ha despertado.");
            estaDormido = false;
            turnosDormido = 0;
        }
        else{
            turnosDormido ++;
            estaDormido = true;
            //System.out.println(nombre + " está dormido, no puede atacar.");
        }
    }
}
