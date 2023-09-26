package org.example.habilidad;

import org.example.EstadoPokemon;
import org.example.Juego;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstado extends Habilidad{
    private EstadoPokemon asignarEstado;

    public HabilidadModificacionEstado(Integer cantidadDisponible, EstadoPokemon asignarEstado) {
        super("modifica estado a " + asignarEstado, cantidadDisponible,"Estado");
        this.asignarEstado = asignarEstado;
    }

    private void cambiarEstado(Pokemon pokemon) {
        if (pokemon.getEstado() instanceof EstadoNormal){
            pokemon.getEstado().setEstadoActual(this.asignarEstado);  //(this.asignarEstado);
            System.out.println("El estado del pokemon "+ pokemon.getNombre()+ "cambio a estado "+this.asignarEstado);
        }
        System.out.println("No se cambio el estado del pokemon "+pokemon.getNombre()+". Sigue en estado "+pokemon.getEstado());
    }
}
