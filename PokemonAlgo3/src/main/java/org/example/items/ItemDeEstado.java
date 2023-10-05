package org.example.items;

import org.example.estado.Estado;
import org.example.pokemon.Pokemon;

public abstract class ItemDeEstado extends Items {
    public ItemDeEstado(Integer disponibles){
        super(disponibles);
    }
    @Override
    public void usarItem(Pokemon pokemon) {;
    }
}
