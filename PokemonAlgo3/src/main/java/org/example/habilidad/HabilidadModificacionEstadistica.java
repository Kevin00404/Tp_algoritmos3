package org.example.habilidad;

//restaurar parte de la vida del Pok´emon o aumentar/disminuir alguna de las
//estadisticas del adversario o de s´ı mismo.
public class HabilidadModificacionEstadistica extends Habilidad{

    //duda:dejar como constantes o que sean atributos? Así si se cambian los valores se dan al crear el objeto.
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
