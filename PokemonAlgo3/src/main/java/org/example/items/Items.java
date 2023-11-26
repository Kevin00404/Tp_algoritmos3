package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class Items implements Item {
    Integer disponibles;
    String nombre;
    public Items(Integer disponibles){
        this.disponibles = disponibles;
    }
    public String getNombre() {
        return this.nombre;
    }
    @Override
    public abstract boolean usarItem(Pokemon pokemon) throws InterruptedException;

    public Integer getDisponibles() {
        return this.disponibles;
    }

    public boolean quedanDisponibles() {
        return disponibles>0;
    }

    public void gastar() {
        this.disponibles -= 1;
    }
}
