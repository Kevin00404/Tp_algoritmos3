package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;

public class EstadoEnvenenado extends Estado {
    public EstadoEnvenenado(){
        this.nombre = "Envenenado";
    }
    @Override
    public Estado pasivo(Estadisticas estadisticas, String nombrePokemon) {
        Estado estadoNuevo = estadisticas.envenenar(nombrePokemon);
        if (estadoNuevo == null){
            return this;
        }
        return estadoNuevo;
    }
    @Override
    public Estado curarEstado(EstadoEnvenenado estadoACurar){
        Estado nuevoEstado = new EstadoNormal();
        Comando comando = new ComandoMensaje("Curando veneno");
        Eventos.getEventos().agregarComando(comando);
        nuevoEstado.agregarEstado(estadoACurar.getProximoEstado());
        nuevoEstado.agregarEstado(proximoEstado);
        return nuevoEstado;
    }
    public Estado aceptarEstado(Estado estado) {
        return estado.curarEstado(this);
    }

    @Override
    public boolean existeEstadoEnvenenado(){
        return true;
    }
}