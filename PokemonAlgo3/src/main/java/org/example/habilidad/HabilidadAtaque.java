package org.example.habilidad;

import org.example.Elemento.Element;
import org.example.pokemon.Pokemon;

public class HabilidadAtaque extends Habilidad{
    Double multiplicador_mismo_tipo;
    Element elemento;
    Integer poder_de_ataque;
    Double mismoTipo;

    final  double MATCH_TIPO_ATAQUE_Y_POKEMON=1.5;
    final double NO_MATCH_TIPO_ATAQUE_Y_POKEMON=1;
    public HabilidadAtaque(String nombre, Int cantidadDisponible, String tipoDeHabilidad,Double multiplicador_mismo_tipo, Element elemento, Integer poder_de_ataque, Double mismoTipo) {
        super(nombre,cantidadDisponible,tipoDeHabilidad)//se repite en las otras dos habilidades.
        this.multiplicador_mismo_tipo = multiplicador_mismo_tipo;
        this.elemento = elemento;
        this.poder_de_ataque = poder_de_ataque;
        this.mismoTipo = mismoTipo;
    }

    public Double getMultiplicadorMismotipo(Element elemento){
        if (this.elemento.get_tipo() == elemento.get_tipo()){
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

}
