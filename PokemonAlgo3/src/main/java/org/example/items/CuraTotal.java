package org.example.items;

import org.example.pokemon.Pokemon;

public class CuraTotal extends ItemDeEstado{
    String nombre;
    public CuraTotal(String nombre , Integer disponibles){
        super(disponibles);
        this.nombre = nombre;
    }
    @Override
    public void usarItem(Pokemon pokemon) {
        pokemon.usarItem(this);
        this.disponibles-=1;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean quedanDisponibles() {
        return super.quedanDisponibles();
    }
}
