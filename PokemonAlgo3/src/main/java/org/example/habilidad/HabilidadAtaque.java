package org.example.habilidad;

import org.example.Elemento.Element;

public class HabilidadAtaque extends Habilidad{
    String nombre;
    Double multiplicador_mismo_tipo;
    Element elemento;
    Integer poder_de_ataque;
    Integer cantidad_de_usos;
    public HabilidadAtaque(String nombre, Integer poder, Element elemento, Integer usos, Double multiplicador_mismo_tipo){
        this.nombre = nombre;
        this.elemento = elemento;
        poder_de_ataque = poder;
        cantidad_de_usos = usos;
        this.multiplicador_mismo_tipo = multiplicador_mismo_tipo;
    }


}
