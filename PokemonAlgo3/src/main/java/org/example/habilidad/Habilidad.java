package org.example.habilidad;

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

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getTipoDeHabilidad() {
        return tipoDeHabilidad;
    }

    public void atacar(Pokemon pokemon, Element element, Ataque ataque) {

        System.out.println("solo es un ejemplo");
    }
}
