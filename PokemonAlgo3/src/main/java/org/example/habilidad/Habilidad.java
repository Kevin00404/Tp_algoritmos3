package org.example.habilidad;

import org.example.Ataque;
import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.estado.Estado;
import org.example.pokemon.Pokemon;

public class Habilidad {
    String nombre;
    Integer cantidadDisponible;
    String tipoDeHabilidad;

    protected Habilidad(String nombre, Integer cantidadDisponible, String tipoDeHabilidad) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.tipoDeHabilidad = tipoDeHabilidad;
    }
    public void atacar(Pokemon pokemon, Element element, Ataque ataque_a_realizar){}

    public String getNombre() {
        return nombre;
    }

    public Pokemon getObjetivo(Pokemon pokemon1 , Pokemon pokemon2) {
        return pokemon2;
    }

    public boolean sePuedeUsar() {
        return cantidadDisponible > 0;
    }
    protected void consumirUso(){
        this.cantidadDisponible -= 1;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
}
