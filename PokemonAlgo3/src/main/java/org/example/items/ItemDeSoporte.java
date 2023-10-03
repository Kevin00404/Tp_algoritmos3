package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class ItemDeSoporte extends Items {
    String nombre;
    Double valor;

    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public void usarItem(Pokemon pokemon) {
    }
}
