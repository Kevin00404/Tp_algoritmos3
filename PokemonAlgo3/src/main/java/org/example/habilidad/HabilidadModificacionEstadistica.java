package org.example.habilidad;

import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstadistica extends Habilidad{
    final Integer AUMENTO  5;
    final Integer DISMINUYE 5;
    final Integer MIN_VALOR=0;
    final Integer MAX_VALOR=100;

    public void aumentarDefensa(Pokemon pokemon){
        aumenta(pokemon);
    }

    //pasar pokemon que usa habilidad
    public void aumentarAtaque(Pokemon pokenon){
        aumenta(pokemon);
    }

    //pasar pokemon que se ataca
    public void disminurAtaque(Pokemon pokemon){
        disminuye(pokemon);
    }

    public void disminuirDefensa(Pokemon pokemon){
        aumenta(pokemon);
    }

    public void aumenta(Pokemon pokemon){
        pokemon.ataque+=AUMENTO;
        if pokemon.ataque<MAX_VALOR{
            pokenon.ataque=MAX_VALOR
        }
    }

    public void disminuye(Pokemon pokemon){
        pokemon.ataque-=DISMINUYE;
        if pokemon.ataque<MIN_VALOR{
            pokenon.ataque=MIN_VALOR
        }
    }

}
