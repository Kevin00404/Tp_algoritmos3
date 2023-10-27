package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class Items implements Item {
    Integer disponibles;
    String nombre;
    public Items(Integer disponibles){
        this.disponibles = disponibles;
        this.nombre = "item";
    }
    public String getNombre() {
        return this.nombre;
    }
    @Override
    public abstract boolean usarItem(Pokemon pokemon);

    public Integer getDisponibles() {
        return disponibles;
    }

    public boolean quedanDisponibles() {
        return disponibles>0;
    }

}
