package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.items.*;
import org.example.pokemon.Pokemon;

import java.util.Random;

public class EstadoDormido extends Estado{
    public Integer contadorTurnosPerdidos;
    private Integer turnosDormido;

    public EstadoDormido() {
        contadorTurnosPerdidos = 0;
        turnosDormido = 0;
        this.nombre = "Dormido";
    }

    @Override
    public Comando condicionarComando(Comando comando) {
        return new ComandoMensaje("Este pokemon esta dormido");
    }

    @Override
    public Estado pasivo(Estadisticas estadisticas){
        return this.puedeDespertarse();
    }

    public Estado puedeDespertarse(){
        contadorTurnosPerdidos ++;
        double probabilidadDespertar = 0.25 + contadorTurnosPerdidos * 0.25;
        Random random = new Random();
        if (random.nextDouble() < probabilidadDespertar) {
            System.out.println("el pokemon desperto");
            return new EstadoNormal();
        }
        else{
            this.turnosDormido ++;
            if(this.turnosDormido == 4){
                System.out.println("el pokemon desperto");
                return new EstadoNormal();
            }
        }
        return this;

    }
    @Override
    public Estado curarEstado(EstadoDormido estadoACurar) {
        return new EstadoNormal();
    }
    public void aceptarEstado(Estado estado) {
        estado.curarEstado(this);
    }
}
