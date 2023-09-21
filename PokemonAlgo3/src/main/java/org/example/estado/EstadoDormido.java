package org.example.estado;

import java.util.Random;

public class EstadoDormido extends Estado{
    public Integer contadorTurnosPerdidos;

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
    }


    public Double calcularProbabilidadDespertar(int N) {
        double probabilidadBase = 0.25;
        double probabilidadPorTurnoPerdido = 0.25;
        double probabilidadTotal = probabilidadBase + N * probabilidadPorTurnoPerdido;

        // Asegurarse de que la probabilidad máxima sea 1 (100%)
        if (probabilidadTotal >= 1.0) {
            probabilidadTotal = 1.0;
        }

        return probabilidadTotal;
    }
}
