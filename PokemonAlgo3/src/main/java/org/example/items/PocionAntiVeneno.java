package org.example.items;

import org.example.estado.EstadoEnvenenado;
import org.example.pokemon.Pokemon;

public class PocionAntiVeneno extends ItemDeEstado{
    String nombre;
    public PocionAntiVeneno(String nombre , Integer disponible){
        super(disponible);
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void usarItem(Pokemon pokemon) {
        pokemon.usarItem(this);
        this.disponibles -= 1;
    }

    @Override
    public boolean quedanDisponibles() {
        return super.quedanDisponibles();
    }

    @Override
    public boolean sePuedeUsar(Pokemon pokemon) {
        return pokemon.getEstado().getNombre().equals("Envenenado");
    }
}
