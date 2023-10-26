package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class ItemDeEstado extends Items {
    public ItemDeEstado(Integer disponibles){
        super(disponibles);
    }
    @Override
    public boolean usarItem(Pokemon pokemon) {;
        return false;
    }
}
