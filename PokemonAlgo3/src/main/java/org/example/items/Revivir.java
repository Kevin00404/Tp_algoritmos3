package org.example.items;

import org.example.pokemon.Pokemon;

public class Revivir extends ItemDeCuracion{
    Revivir(Double valor , String nombre){
        this.valor = valor;
        this.nombre = nombre;
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
