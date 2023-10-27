package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.items.*;
import org.example.pokemon.Pokemon;

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
        return new EstadoNormal();
    }
    public void aceptarEstado(Estado estado) {
        estado.curarEstado(this);
    }
}