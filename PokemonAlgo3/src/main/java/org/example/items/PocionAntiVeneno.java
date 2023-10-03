package org.example.items;

import org.example.estado.EstadoEnvenenado;
import org.example.pokemon.Pokemon;

public class PocionAntiVeneno extends ItemDeEstado{
    @Override
    public void usarItem(Pokemon pokemon) {
        pokemon.usarItem(this);
    }
}
