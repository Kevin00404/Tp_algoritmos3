package org.example.Estadisticas;

import org.example.Elemento.Element;
import org.json.simple.JSONObject;

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

    public EstadisticaPokemon(JSONObject pkmn, Element elemento) {
        this.maxVida = ((Long) pkmn.get("vidaMaxima")).doubleValue();
        this.vida = this.maxVida;
        this.ataque = ((Long) pkmn.get("ataque")).doubleValue();
        this.defensa = ((Long) pkmn.get("defensa")).doubleValue();
        this.velocidad = ((Long) pkmn.get("velocidad")).doubleValue();
        this.elemento = elemento;
        this.nivel = ((Long) pkmn.get("nivel")).intValue();
    }


    public Integer getNivel() {
        return this.nivel;
    }

    public Double getAtaque(){
        return this.ataque;
    }
}
