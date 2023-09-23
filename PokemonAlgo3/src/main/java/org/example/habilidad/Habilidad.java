package org.example.habilidad;

import org.example.Elemento.Element;
import org.example.pokemon.Pokemon;

public asbtract class Habilidad {
    String nombre;
    Int cantidadDisponible;
    String tipoDeHabilidad;
   // String poder;   //Este atributo esta en el enunciado de TP pero sólo se usa en habilidad Ataque. Se declara el atributo en esa habilidad.

    protected Habilidad(String nombre, Int cantidadDisponible, String tipoDeHabilidad) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.tipoDeHabilidad = tipoDeHabilidad;
    }


//    Double multiplicador_mismo_tipo;
//    Element elemento;
//    Double poder_de_ataque;
//    Integer cantidad_de_usos;
//    Double mismoTipo;
}