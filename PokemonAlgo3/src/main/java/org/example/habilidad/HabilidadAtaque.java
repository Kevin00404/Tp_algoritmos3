package org.example.habilidad;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.pokemon.Pokemon;

import java.util.Objects;

public class HabilidadAtaque extends Habilidad{
    Element elemento;
    Double poder_de_ataque;

    public HabilidadAtaque(Integer cantidadDisponible, Element elemento, Double poder_de_ataque) {
        super("Habilidad de Ataque",cantidadDisponible,"Ataque");//se repite en las otras dos habilidades.
        this.elemento = elemento;
        this.poder_de_ataque = poder_de_ataque;
    }

    public void atacar(Pokemon pokemon, Element element, Ataque ataque_a_realizar){
        ataque_a_realizar.setPoder(this.poder_de_ataque);
        ataque_a_realizar.setMismoTipo(this.elemento.bonus_mismo_tipo(element));
        pokemon.recibirDanio(ataque_a_realizar, elemento);
    }
}
