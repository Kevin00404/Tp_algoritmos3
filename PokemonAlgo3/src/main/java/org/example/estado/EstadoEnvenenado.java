package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;

public class EstadoEnvenenado extends Estado {
    public EstadoEnvenenado(){
        this.nombre = "Envenenado";
    }
    @Override
    public Estado pasivo(Estadisticas estadisticas) {
        Estado estadoNuevo = estadisticas.envenenar();
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
        return nuevoEstado;
    }
    public Estado aceptarEstado(Estado estado) {
        estado.curarEstado(this);
        return estado;
    }
}