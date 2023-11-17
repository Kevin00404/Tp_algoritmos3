package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class ItemDeSoporte extends Items {
    Double valor;
    public ItemDeSoporte(Integer disponibles){
        super(disponibles);
    }
    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public boolean usarItem(Pokemon pokemon) {
        return false;
    }
}
