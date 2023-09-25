package org.example.habilidad;

import org.example.Elemento.Element;
import org.example.pokemon.Pokemon;

import java.util.Objects;

public class HabilidadAtaque extends Habilidad{
    Double multiplicador_mismo_tipo;
    Element elemento;
    Double poder_de_ataque;
    Double mismoTipo;

    final  double MATCH_TIPO_ATAQUE_Y_POKEMON=1.5;
    final double NO_MATCH_TIPO_ATAQUE_Y_POKEMON=1.0;

    public HabilidadAtaque(Integer cantidadDisponible,Double multiplicador_mismo_tipo, Element elemento, Double poder_de_ataque, Double mismoTipo) {
        super("Habilidad de Ataque",cantidadDisponible,"Ataque");//se repite en las otras dos habilidades.
        this.multiplicador_mismo_tipo = multiplicador_mismo_tipo;
        this.elemento = elemento;
        this.poder_de_ataque = poder_de_ataque;
        this.mismoTipo = mismoTipo;
    }

    // saber si pokemon es del mismo elemento(tipo) del elemento pasado en parametro .
    public double getMultiplicadorMismotipo(Element elemento){
        if (Objects.equals(this.elemento.get_tipo(), elemento.get_tipo())){
            return MATCH_TIPO_ATAQUE_Y_POKEMON;
        }
        else{
            return NO_MATCH_TIPO_ATAQUE_Y_POKEMON;
        }
    }

    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Element element /*elemento del pokemon que está atacando*/){
        mismoTipo = this.getMultiplicadorMismotipo(element);
        pokemon.recibirDanio(poder_de_ataque, mismoTipo, elemento, pokemon.getAtaque());
    }
}
