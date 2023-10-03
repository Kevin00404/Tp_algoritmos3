package org.example.items;

import org.example.pokemon.Pokemon;

public class PocionCurarParalisis extends ItemDeEstado{
    @Override
    public void usarItem(Pokemon pokemon) {
        pokemon.usarItem(this);
    }
}
