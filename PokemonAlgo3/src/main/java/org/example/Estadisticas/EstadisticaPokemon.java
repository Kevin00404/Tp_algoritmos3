package org.example.Estadisticas;

import org.example.Elemento.Element;

public class EstadisticaPokemon extends Estadisticas{


    public EstadisticaPokemon(Double maxVida, Double ataque, Double defensa, Double velocidad, Element elemento) {
        this.maxVida = maxVida;
        this.vida = this.maxVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.elemento = elemento;
        this.nivel = 1;
    }

    public Integer getNivel() {
        return this.nivel;
    }

    public Double getAtaque(){
        return this.ataque;
    }
}
