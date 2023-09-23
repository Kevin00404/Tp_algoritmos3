package org.example.habilidad;

public class HabilidadModificacionEstado extends Habilidad{

    private void cambiarEstado(Pokemon pokemon,Estado estado) {
        if pokemon.estado ==/*estadoNormal*/{
            pokemon.estado=estado
    }
    }

    public void cambiarEstadoDormido(Pokemon pokemon,Estado estado){
        cambiarEstado(pokemon,estado)
    }

    public void cambiarEstadoParalizado(Pokemon pokemon,Estado estado){
        cambiarEstado(pokemon,estado)
    }

    public void cambiarEstadoEnvenenado(Pokemon pokemon,Estado estado){
        cambiarEstado(pokemon,estado)
    }



}
