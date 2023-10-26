package org.example.comando;

import org.example.estado.Estado;
import org.example.pokemon.Pokemon;

public class CambiarEstadoComando extends Comando {
    Pokemon pokemon;
    Estado estado;
    public CambiarEstadoComando(Pokemon pokemon, Estado estado) {
        this.pokemon = pokemon;
        this.estado = estado;
    }

    @Override
    protected void ejecutarEsteComando() {
        pokemon.modificarEstado(estado);
    }
}
