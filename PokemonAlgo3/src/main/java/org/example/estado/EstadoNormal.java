package org.example.estado;

import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoNormal extends Estado{
    public EstadoNormal(){
        this.nombre = "Normal";
    }
    @Override
    public Estado setEstadoActual(Estado estado) {
        System.out.println("el estado se cambia a: " + estado.getNombre());
        return estado;
    }

    public void aceptarEstado(Estado estado) {
        estado.curarEstado(this);
    }
}
