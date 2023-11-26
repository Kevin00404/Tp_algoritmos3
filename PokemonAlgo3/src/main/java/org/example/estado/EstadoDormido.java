package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.Eventos.Eventos;

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
    public Comando condicionarComando(Comando comando, Estadisticas estadisticas) {
        return new ComandoMensaje("Este pokemon esta dormido");
    }

    @Override
    public Estado pasivo(Estadisticas estadisticas, String nombre){
        return this.puedeDespertarse();
    }

    public Estado puedeDespertarse(){
        contadorTurnosPerdidos ++;
        double probabilidadDespertar = 0.25 + contadorTurnosPerdidos * 0.25;
        Random random = new Random();
        if (random.nextDouble() < probabilidadDespertar) {
            Estado nuevoEstado = new EstadoNormal();
            Comando comando = new ComandoMensaje("El pokemon despertó");
            nuevoEstado.agregarEstado(proximoEstado);
            return nuevoEstado;
        }
        else{
            this.turnosDormido ++;
            if(this.turnosDormido == 4){
                Estado nuevoEstado = new EstadoNormal();
                Comando comando = new ComandoMensaje("El pokemon despertó");
                Eventos.getEventos().agregarComando(comando);
                nuevoEstado.agregarEstado(proximoEstado);
                return nuevoEstado;
            }
        }
        return this;
    }
    @Override
    public Estado curarEstado(EstadoDormido estadoACurar) {
        Estado nuevoEstado = new EstadoNormal();
        Comando comando = new ComandoMensaje("El pokemon despertó");
        Eventos.getEventos().agregarComando(comando);
        nuevoEstado.agregarEstado(estadoACurar.getProximoEstado());
        return nuevoEstado;
    }
    public Estado aceptarEstado(Estado estado) {
        return estado.curarEstado(this);
    }

    @Override
    public boolean existeEstadoDormido(){
        return true;
    }
}
