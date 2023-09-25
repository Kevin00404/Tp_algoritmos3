package org.example.habilidad;

import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstado extends Habilidad{

    private TipoHabilidadEstado tipoEstado;




    public HabilidadModificacionEstado(Integer cantidadDisponible, String tipoDeHabilidad) {
        super(nombre, cantidadDisponible, tipoDeHabilidad);
    }

    private void cambiarEstado(Pokemon pokemon, Estado estado) {
        if (pokemon.getEstado() instanceof EstadoNormal){
            pokemon.setEstado(estado);
            System.out.println("El estado del pokemon "+ pokemon.getNombre()+ "cambio a estado "+estado);
        }
        System.out.println("No se cambio el estado del pokemon "+pokemon.getNombre()+". Sigue en estado "+pokemon.getEstado());
    }

    public void cambiarEstadoDormido(Pokemon pokemon,Estado estado){
        cambiarEstado(pokemon,estado);
    }

    public void cambiarEstadoParalizado(Pokemon pokemon,Estado estado){
        cambiarEstado(pokemon,estado);
    }

    public void cambiarEstadoEnvenenado(Pokemon pokemon,Estado estado){
        cambiarEstado(pokemon,estado);
    }

}
