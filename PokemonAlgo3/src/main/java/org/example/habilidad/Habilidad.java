package org.example.habilidad;

import org.example.Elemento.Element;
import org.example.pokemon.Pokemon;

public class Habilidad{
    String nombre;
    Double multiplicador_mismo_tipo;
    Element elemento;
    Double poder_de_ataque;
    Integer cantidad_de_usos;
    Double mismoTipo;

    public Habilidad(String nombre, Double poder, Element elemento, Integer usos, Double multiplicador_mismo_tipo){
        this.nombre = nombre;
        this.elemento = elemento;
        this.poder_de_ataque = poder;
        this.cantidad_de_usos = usos;
        this.multiplicador_mismo_tipo = multiplicador_mismo_tipo;
    }
    public Double getMultiplicadorMismotipo(Element elemento){
        if (this.elemento.get_tipo() == elemento.get_tipo()){
            return 1.5; // mismoTipo
        }
        else{
            return 1.0;
        }
    }
    public Integer getCantidad_de_usos(){
        return this.cantidad_de_usos;
    }
    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Element element /*elemento del pokemon que está atacando*/){
        mismoTipo = this.getMultiplicadorMismotipo(element);
        pokemon.recibirDanio(poder_de_ataque, mismoTipo, elemento, pokemon.getAtaque());
    }
}
