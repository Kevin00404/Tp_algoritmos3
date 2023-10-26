package org.example.comando;

import org.example.estado.EstadoEnvenenado;
import org.example.pokemon.Pokemon;
import org.example.estado.*;

public class ComandoCurarEstado extends Comando {
    Estado estadoACurar;
    Pokemon pokemon;
    public ComandoCurarEstado(Estado estadoACurar, Pokemon pokemon) {
        this.estadoACurar = estadoACurar;
        this.pokemon = pokemon;
    }

    @Override
    protected void ejecutarEsteComando() {
        pokemon.curarEstado(estadoACurar);
    }
}
