package org.example.items;

import org.example.pokemon.Pokemon;

public abstract class ItemDeCuracion extends Items{
    public ItemDeCuracion(Integer disponibles){
        super(disponibles);
    }
    Double valor;
    String nombre;
    public String getNombre() {
        return this.nombre;
    }

    public Double getValor() {
        return this.valor;
    }

}
