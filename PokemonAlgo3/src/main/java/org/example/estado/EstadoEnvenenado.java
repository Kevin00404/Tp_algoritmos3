package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

public class EstadoEnvenenado extends Estado {
    public EstadoEnvenenado(){

    }

    @Override
    public Estado pasivo(Pokemon pokemon) {
        pokemon.envenenar();
        return this;
    }
}