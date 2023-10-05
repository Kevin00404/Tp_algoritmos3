package org.example.items;

import org.example.pokemon.Pokemon;

public class PocionDeAtaque extends ItemDeSoporte {

    public PocionDeAtaque(String nombre, Double valor , Integer disponible) {
        super(disponible);
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
        this.disponibles -=1;
    }

    @Override
    public boolean quedanDisponibles() {
        return super.quedanDisponibles();
    }
}
