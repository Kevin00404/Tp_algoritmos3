package org.example.items;

import org.example.pokemon.Pokemon;

public class PocionDeDefensa extends ItemDeSoporte{
    public PocionDeDefensa(String nombre, Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public Double getValor() {
        return super.getValor();
    }
    @Override
    public void usarItem(Pokemon pokemon) {
        pokemon.usarItem(this);
    }
}
