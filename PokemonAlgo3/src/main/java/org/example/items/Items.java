package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class Items implements Item {
    Integer disponibles;
    Items(Integer disponibles){
        this.disponibles = disponibles;
    }
    @Override
    public void usarItem(Pokemon pokemon) {
    }
    public String getNombre(){ return null; }

    public Integer getDisponibles() {
        return disponibles;
    }

    public boolean quedanDisponibles() {
        return disponibles>0;
    }
}
