package org.example.items;

import org.example.estado.EstadoDormido;
import org.example.pokemon.Pokemon;

public class PocionDespertarDormido extends ItemDeEstado{
    @Override
    public void usarItem(Pokemon pokemon) {
        pokemon.usarItem(this);
    }
}
